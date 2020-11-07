package com.liugx.testsystem.controller.manage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManageHomeController {
	@GetMapping("/manage/home")
	public String goTOHome() {
		return "/manage/home";
	}
	
	@PostMapping("/manage/createquestion")
	public String goToCreateQuestion() {
		return "/manage/createquestion";
	}
	
	
}
