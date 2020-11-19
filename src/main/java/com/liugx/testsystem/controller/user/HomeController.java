package com.liugx.testsystem.controller.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/user/home")
	public String home() {
		return "/user/home";
	}
}
