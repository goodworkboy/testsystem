package com.liugx.testsystem.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.QuestionCreateDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.service.manage.QuestionService;

@Controller
public class QuestionsController {
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/manage/questions")
	public String questions(Model model
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size) {
		PaginationDTO paginationDTO = questionService.list(page,size);
		model.addAttribute("pagination", paginationDTO);
		return "/manage/questions";
	}
	
	@GetMapping("/manage/modifyquestion/{id}")
	public String modifyQuestion(Model model
			,@PathVariable(name = "id") Long id) {
		QuestionDTO questionDTO = questionService.getById(id);
		if(questionDTO==null) {
			System.out.println("questionDTO is null!");
		}
		model.addAttribute("question", questionDTO);
		return "/manage/modifyquestion";
	}
	
	@PostMapping("/manage/modifyquestion")
	public String modifyAndSubmit(@RequestParam(value="head",required = false)String head
			,@RequestParam(value="answerA",required = false)String answerA
			,@RequestParam(value="answerB",required = false)String answerB
			,@RequestParam(value="answerC",required = false)String answerC
			,@RequestParam(value="answerD",required = false)String answerD
			,@RequestParam(value="answer", required = false)String answer
			,@RequestParam(value="status",required = false)boolean status
			,@RequestParam(value="id",required = false)Long id
			,Model model) {
		String errorurl="/manage/modifyquestion";
		QuestionDTO questionDTO=new QuestionDTO();
		questionDTO.setHead(head);
		questionDTO.setAnswer(answer);
		questionDTO.setAnswerA(answerA);
		questionDTO.setAnswerB(answerB);
		questionDTO.setAnswerC(answerC);
		questionDTO.setAnswerD(answerD);
		questionDTO.setStatus(status);
		questionDTO.setId(id);
		model.addAttribute("question", questionDTO);
		if(status==true) {
			model.addAttribute("error", "该题目已被使用，无法被修改！");
			return errorurl;
		}
		
		if(head==null || head.length()==0) {
			model.addAttribute("error", "题干不能为空！");
			return errorurl;
		}
		if(answerA==null || answerA.length()==0) {
			model.addAttribute("error", "A选项不能为空！");
			return errorurl;
		}
		if(answerB==null || answerB.length()==0) {
			model.addAttribute("error", "B选项不能为空！");
			return errorurl;
		}
		if(answerC==null || answerC.length()==0) {
			model.addAttribute("error", "C选项不能为空！");
			return errorurl;
		}
		if(answerD==null || answerD.length()==0) {
			model.addAttribute("error", "D选项不能为空！");
			return errorurl;
		}
		if(answer==null || answer.length()==0) {
			model.addAttribute("error", "正确选项不能为空！");
			return errorurl;
		}
		if(questionService.update(questionDTO)) {
			model.addAttribute("message", "题目修改成功成功！");
			return "/manage/home";
		}else {
			model.addAttribute("error", "数据库更新失败，请稍后重试！");
			return "errorurl";
		}
		
	}
	
	@PostMapping("/manage/questiondelete")
	public String deleteAndSubmit(@RequestParam(value="head",required = false)String head
			,@RequestParam(value="answerA",required = false)String answerA
			,@RequestParam(value="answerB",required = false)String answerB
			,@RequestParam(value="answerC",required = false)String answerC
			,@RequestParam(value="answerD",required = false)String answerD
			,@RequestParam(value="answer", required = false)String answer
			,@RequestParam(value="status",required = false)boolean status
			,@RequestParam(value="id",required = false)Long id
			,Model model) {
		String errorurl="/manage/modifyquestion";
		QuestionDTO questionDTO=new QuestionDTO();
		questionDTO.setHead(head);
		questionDTO.setAnswer(answer);
		questionDTO.setAnswerA(answerA);
		questionDTO.setAnswerB(answerB);
		questionDTO.setAnswerC(answerC);
		questionDTO.setAnswerD(answerD);
		questionDTO.setStatus(status);
		questionDTO.setId(id);
		model.addAttribute("question", questionDTO);
		if(status==true) {
			model.addAttribute("error", "该题目已被使用，无法被修改！");
			return errorurl;
		}
		if(questionService.delete(questionDTO)) {
			model.addAttribute("message", "题目删除成功！");
			return "/manage/home";
		}else {
			model.addAttribute("error", "数据库删除失败，请稍后重试！");
			return "errorurl";
		}
		
	}
	
}
