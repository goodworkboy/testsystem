package com.liugx.testsystem.controller.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.liugx.testsystem.dto.PaperDTO;
import com.liugx.testsystem.dto.QuestionDTO;
import com.liugx.testsystem.dto.TestCreateDTO;
import com.liugx.testsystem.service.manage.PaperService;
import com.liugx.testsystem.service.manage.QuestionService;

@Controller
public class ManageHomeController {
	
	@Autowired
	private PaperService paperService;
	
	@Autowired
	private QuestionService questionService;
	
	@GetMapping("/manage/home")
	public String goTOHome() {
		return "/manage/home";
	}
	
	
	
	@PostMapping("/manage/createquestion")
	public String goToCreateQuestion() {
		return "/manage/createquestion";
	}
	
	
	@PostMapping("/manage/papercreate")
	public String goTOPaperCreate(Model model) {
		List<QuestionDTO> questionList = questionService.list();
		model.addAttribute("questions", questionList);
		return "/manage/papercreate";
	}
	

	@PostMapping("/manage/publish")
	public String goToPublish(Model model) {
		TestCreateDTO testDTO = new TestCreateDTO();
		model.addAttribute("test",testDTO);
		List<PaperDTO> paperDTOs = paperService.list();
		model.addAttribute("papers", paperDTOs);
		return "/manage/publish";
	}
}
