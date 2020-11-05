package com.liugx.testsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * 登录，注册controller
 */
@Controller
public class IndexController {

	@GetMapping("index")
	public String login(@RequestParam("name")String name
			,Model model) {
		model.addAttribute("name", name);
		return "index";
	}
}
