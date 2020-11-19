package com.liugx.testsystem.controller.manage;

import java.util.Date;

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
import com.liugx.testsystem.dto.ResultDTO;
import com.liugx.testsystem.dto.TestCreateDTO;
import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.service.manage.PaperService;
import com.liugx.testsystem.service.manage.TestService;

@Controller
public class TestController {
	
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private TestService testService;
	
	@PostMapping("/manage/publish/submit")
	@ResponseBody
	public Object testCreateSubmit(@RequestBody TestCreateDTO testCreateDTO) {
		if(testCreateDTO.getName() == null || testCreateDTO.getName().length() == 0) {
			return ResultDTO.errorOf(CustomizeErrorCode.TEST_NAME_IS_NULL);
		}
		if(testCreateDTO.getStartTime() == null || testCreateDTO.getStartTime().getTime() < System.currentTimeMillis()) {
			return ResultDTO.errorOf(CustomizeErrorCode.START_TIME_TOO_EARLY);
		}
		if(testCreateDTO.getDuration() == null || 
				(testCreateDTO.getDuration().getTime()==0)) {
			return ResultDTO.errorOf(CustomizeErrorCode.DURATION_TOO_QUICK);
		}
		if(testCreateDTO.getPaperId() == null || testCreateDTO.getPaperId()==0) {
			return ResultDTO.errorOf(CustomizeErrorCode.PAPER_NOT_FOUND);
		}
		testService.publishTest(testCreateDTO);
		return ResultDTO.okOf("/manage/home");
	}
	
	@GetMapping("/manage/testhistory")
	public String testHistory(Model model
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size) {
		PaginationDTO paginationDTO = testService.list(page,size);
		model.addAttribute("pagination", paginationDTO);
		return "/manage/testhistory";
	}
	
	@GetMapping("/manage/modifytest/{id}")
	public String modifyTest(Model model
			,@PathVariable(name = "id") Long id
			,@RequestParam(name="paperId",required = false)Long paperId) {
		TestDTO testDTO = testService.selectById(id,paperId);
		model.addAttribute("test", testDTO);
		return "/manage/modifytest";
	}
	
	@GetMapping("/manage/modifytest/papers/{id}")
	public String choosePaper(Model model
			,@PathVariable(name = "id") Long id
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size
			) {
		
		PaginationDTO paginationDTO = paperService.list(page, size);
		model.addAttribute("testId", id);
		model.addAttribute("pagination", paginationDTO);
		return "/manage/paperlist";
	}
	
	@PostMapping("/manage/modifytest/submit")
	@ResponseBody
	public Object modifyTestSubmit(@RequestBody TestCreateDTO testCreateDTO) {
		if(testCreateDTO.getName() == null || testCreateDTO.getName().length() == 0) {
			return ResultDTO.errorOf(CustomizeErrorCode.TEST_NAME_IS_NULL);
		}
		if(testCreateDTO.getStartTime() == null || testCreateDTO.getStartTime().getTime() < System.currentTimeMillis()) {
			return ResultDTO.errorOf(CustomizeErrorCode.START_TIME_TOO_EARLY);
		}
		if(testCreateDTO.getDuration() == null || 
				(testCreateDTO.getDuration().getTime()==0)) {
			return ResultDTO.errorOf(CustomizeErrorCode.DURATION_TOO_QUICK);
		}
		if(testCreateDTO.getPaperId() == null || testCreateDTO.getPaperId()==0) {
			return ResultDTO.errorOf(CustomizeErrorCode.PAPER_NOT_FOUND);
		}
		System.out.println("开始提交");
		Object result=testService.modifyTest(testCreateDTO);
		System.out.println("提交完毕");
		if(result==null)
			return ResultDTO.okOf("/manage/home");
		else return result;
	}
	
}	
