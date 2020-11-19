package com.liugx.testsystem.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.PaperDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.ResultDTO;
import com.liugx.testsystem.dto.paper.PaperDeleteDTO;
import com.liugx.testsystem.dto.paper.PaperPageDTO;
import com.liugx.testsystem.dto.paper.QuestionDeleteDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.service.manage.PaperService;
import com.liugx.testsystem.service.manage.QuestionService;

@Controller
public class PaperController {
	
	@Autowired
	PaperService paperService;
	
	@Autowired
	QuestionService questionService;
	
	@PostMapping("/manage/papersubmit")
	public String paperCreate(Model model,
			@RequestParam(value="papername",required = false)String papername,
			@RequestParam(value = "questionIds",required = false)List<Long> questionIds) {
		List<QuestionDTO> questions=questionService.list(); //return questionDTO list
		model.addAttribute("questions", questions);
		model.addAttribute("papername", papername);
		String errorurl = "/manage/papercreate";
		
		PaperDTO paperDTO=new PaperDTO();
		paperDTO.setName(papername);
		
		if(papername==null || papername.length()==0) {
			model.addAttribute("error", "试卷标题不能为空！");
			return errorurl;
		}
		
		if(questionIds==null || questionIds.size()<5) {
			model.addAttribute("error", "试卷包含的题目不能小于5个"+"    questions is"+(questionIds==null));
			return errorurl;
		}
		paperService.insertPaper(paperDTO,questionIds);
		return "/manage/home";
	}
	
	@GetMapping("/manage/modifypaper/{id}")
	public String modifyPaper(Model model
			,@PathVariable("id")Long id
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size) {
		PaperDTO paper = paperService.getById(id);
		PaginationDTO<QuestionDTO> paginationDTO = paperService.list(page,size,paper);
		model.addAttribute("paper", paper);
		model.addAttribute("pagination", paginationDTO);
		return "/manage/modifypaper";
	}
	
	@GetMapping("/manage/papers")
	public String papers(Model model
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size) {
		PaginationDTO<PaperDTO> paginationDTO = paperService.list(page,size);
		model.addAttribute("pagination", paginationDTO);
		return "/manage/papers";
	}
	
	@GetMapping("/manage/modifypaper/questiondelete")
	public String questionDelete(
			@RequestParam(name = "page") Integer page
            ,@RequestParam(name = "paperid")Long paperId
            ,@RequestParam(name = "questionid")Long questionId
            ,@RequestParam(name = "questionnum")Integer questionNum
            ,@RequestParam(name = "status")Boolean status) {
		QuestionDeleteDTO questionDeleteDTO = new QuestionDeleteDTO();
		questionDeleteDTO.setPaperId(paperId);
		questionDeleteDTO.setQuestionId(questionId);
		questionDeleteDTO.setQuestionNum(questionNum);
		questionDeleteDTO.setStatus(status);
		paperService.deleteQuestion(questionDeleteDTO);
		return "redirect:/manage/modifypaper/"+paperId+"?page="+page;
		
	}
	
	@PostMapping("/manage/modifypaper/modifyname")
	public String modifyPaperName(@RequestParam(name = "paperid")Long paperId
			,@RequestParam(name = "status")Boolean status
			,@RequestParam(name = "papername")String papername
			,@RequestParam(name = "page")Integer page) {
		if(!status&&papername != null&&papername.length()!=0) {
			PaperDTO paperDTO = new PaperDTO();
			paperDTO.setId(paperId);
			paperDTO.setStatus(status);
			paperDTO.setName(papername);
			paperService.updatePaper(paperDTO);
		}
		return "redirect:/manage/modifypaper/"+paperId+"?page="+page;
	}
	
	@PostMapping("/manage/modifypaper/deletepaper")
	@ResponseBody
	public Object paperDelete(@RequestBody PaperDeleteDTO paperDeleteDTO) {
		if(paperDeleteDTO.getStatus()) {
			return ResultDTO.errorOf(new CustomizeException(CustomizeErrorCode.PAPER_IS_USING));
		}else {
			paperService.deletePaper(paperDeleteDTO);
			return ResultDTO.okOf("/manage/papers");
		}
	}
	
	@PostMapping("/manage/modifypaper/papermodifysubmit")
	@ResponseBody
	public Object paperModifySubmit(@RequestBody PaperDeleteDTO paperDeleteDTO) {
		if(paperDeleteDTO.getStatus()) {
			return ResultDTO.errorOf(new CustomizeException(CustomizeErrorCode.PAPER_IS_USING));
		}else {
			return ResultDTO.okOf("/manage/papers");
		}
	}
	
	@PostMapping("/manage/modifypaper/paperquestionadd")
	@ResponseBody
	public Object paperQuestionAdd(@RequestBody PaperPageDTO paperPageDTO) {
		if(paperPageDTO.getStatus()) {
			return ResultDTO.errorOf(new CustomizeException(CustomizeErrorCode.PAPER_IS_USING));
		}else {
			return ResultDTO.okOf("/manage/modifypaper/paperQuestionAdd/"+paperPageDTO.getId());
		}
	}
	
	@GetMapping("/manage/modifypaper/paperQuestionAdd/{id}")
	public String paperQuestionAddRedirect(@PathVariable("id")Long Id
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size
			,Model model) {
		PaginationDTO paginationDTO = questionService.list(page,size);
		model.addAttribute("pagination", paginationDTO);
		model.addAttribute("paperId", Id);
		return "/manage/paper_question_add";
	}
	
	
	@PostMapping("/manage/modifypaper/paperQuestionAddSubmit")
	@ResponseBody
	public Object paperQuestionAddSubmit(@RequestBody PaperPageDTO paperPageDTO) {
		return	paperService.addQuestion(paperPageDTO);
	}
	
	/**
	 * 
	 * @author liugx
	 *接受修改考试的时候查看试卷的请求
	 *得到一个能显示试卷具体信息的页面
	 */
	@GetMapping("/manage/modifytest/paperInfo/{id}")
	public String paperInfo(@PathVariable("id")Long Id
			,@RequestParam(name = "returnUrl",defaultValue = "/manage/home")String returnUrl
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "1") Integer size
			,Model model) {
		PaperDTO paper = paperService.getById(Id);
		PaginationDTO<QuestionDTO> paginationDTO = paperService.list(page,size,paper);
		model.addAttribute("paper", paper);
		model.addAttribute("pagination", paginationDTO);
		model.addAttribute("returnUrl", returnUrl);
		return "/manage/paperInfo";
	}
	
}