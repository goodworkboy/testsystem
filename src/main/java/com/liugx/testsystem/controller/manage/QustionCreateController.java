package com.liugx.testsystem.controller.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.QuestionCreateDTO;
import com.liugx.testsystem.service.manage.QuestionService;

@Controller
public class QustionCreateController {
	
	@Autowired
	private QuestionService questionService;
	
	
	@PostMapping("/manage/questionsubmit")
	public String creatQuestion(@RequestParam("head")String head
			,@RequestParam(value="answerA",required = false)String answerA
			,@RequestParam(value="answerB",required = false)String answerB
			,@RequestParam(value="answerC",required = false)String answerC
			,@RequestParam(value="answerD",required = false)String answerD
			,@RequestParam(value="answer", required = false)String answer,
			Model model) {
		String errorurl="/manage/createquestion";
		model.addAttribute("head", head);
		model.addAttribute("answerA", answerA);
		model.addAttribute("answerB", answerB);
		model.addAttribute("answerC", answerC);
		model.addAttribute("answerD", answerD);
		model.addAttribute("answer", answer);
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
		
		QuestionCreateDTO questionDTO=new QuestionCreateDTO();
		questionDTO.setHead(head);
		questionDTO.setAnswer(answer);
		questionDTO.setAnswerA(answerA);
		questionDTO.setAnswerB(answerB);
		questionDTO.setAnswerC(answerC);
		questionDTO.setAnswerD(answerD);
		
		if(questionService.insert(questionDTO)) {
			model.addAttribute("message", "题目创建成功成功！");
			return "/manage/home";
		}else {
			model.addAttribute("error", "题目创建注册失败，请稍后重试！");
			return "errorurl";
		}
		
	}
}
