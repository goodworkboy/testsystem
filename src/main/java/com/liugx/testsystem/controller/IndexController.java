package com.liugx.testsystem.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.UserDTO;
import com.liugx.testsystem.execption.CustomizeErrorCode;
import com.liugx.testsystem.execption.CustomizeException;
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
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="studentNum",required=false)Long studentNum,
			@RequestParam(value="password",required=false)String password,
			HttpServletRequest request) {
		model.addAttribute("studentNum", studentNum);
		if(studentNum==null) {
			System.out.println("学号不能为空！");
			model.addAttribute("studentNumerror", "学号不能为空！");
			return "index";
		}
		if(password==null || password.length()==0) {
			System.out.println("密码不能为空！");
			model.addAttribute("passworderror", "密码不能为空！");
			return "index";
		}
		UserDTO userdto=new UserDTO();
		userdto.setStudentNum(studentNum);
		userdto.setPassword(password);
		User user=userService.selectUser(userdto);
		if(user!=null) {
			request.setAttribute("user", user);
			return "success";
		}else {
			model.addAttribute("error", "学号或密码错误！");
			return "index";
		}
	}
	
	@PostMapping("redirectToRegister")
	public String redirectToRegister() {
		return "register";
	}
}
