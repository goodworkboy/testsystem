package com.liugx.testsystem.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.UserDTO;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.service.UserService;

@Controller
public class AuthorizeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(Model model,
			@RequestParam(value="studentNum",required=false)String studentNum,
			@RequestParam(value="password",required=false)String password,
			HttpServletRequest request,
			HttpServletResponse response) {
		model.addAttribute("studentNum", studentNum);
		if(studentNum==null) {
			System.out.println("学号不能为空！");
			model.addAttribute("error", "学号不能为空！");
			return "index";
		}
		if(password==null || password.length()==0) {
			System.out.println("密码不能为空！");
			model.addAttribute("error", "密码不能为空！");
			return "index";
		}
		UserDTO userdto=new UserDTO();
		userdto.setStudentNum(studentNum);
		userdto.setPassword(password);
		User user=userService.selectUser(userdto);
		Cookie cookie = new Cookie("token", user.getId().toString());
		cookie.setPath("/");
		response.addCookie(cookie);
		if(user!=null) {
			request.setAttribute("user", user);
			return "redirect:/user/home";
		}else {
			model.addAttribute("error", "学号或密码错误！");
			return "index";
		}
	}
	
	@GetMapping(value="/user/logout")
	public String logout(HttpServletRequest request,
            HttpServletResponse response) {
		request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
		return "redirect:/";
	}
}
