package com.liugx.testsystem.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.UserDTO;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.service.UserService;

/*
 * 登录，注册controller
 */
@Controller
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("index")
	public String index1() {
		return "index";
	}
	
	
	
	@PostMapping("redirectToRegister")
	public String redirectToRegister() {
		return "register";
	}
}
