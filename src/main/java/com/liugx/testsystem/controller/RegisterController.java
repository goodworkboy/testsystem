package com.liugx.testsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.RegisterDTO;
import com.liugx.testsystem.service.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("submit")
	public String submit(@RequestParam(value="name",required = false)String name
			,@RequestParam(value="studentNum",required = false)String studentNum
			,@RequestParam(value="password1" ,required = false)String password1
			,@RequestParam(value="password2" ,required = false)String password2
			,Model model) {
		model.addAttribute("name", name);
		model.addAttribute("studentNum", studentNum);
		model.addAttribute("password1", password1);
		model.addAttribute("password2", password2);
		if(name==null || name.length()==0) {
			System.out.println("姓名不能为空！");
			model.addAttribute("error", "姓名不能为空！");
			return "register";
		}
		if(studentNum==null || studentNum.length()==0) {
			System.out.println("学号不能为空！");
			model.addAttribute("error", "学号不能为空！");
			return "register";
		}
		if(studentNum!=null && studentNum.length()!=8) {
			System.out.println("学号不能为空！");
			model.addAttribute("error", "请输入正确的学号格式（8位）！");
			return "register";
		}
		if(password1==null || password1.length()==0) {
			System.out.println("密码不能为空！");
			model.addAttribute("error", "密码不能为空！");
			return "register";
		}
		if(password2==null || password2.length()==0) {
			System.out.println("确认密码不能为空！");
			model.addAttribute("error", "确认密码不能为空！");
			return "register";
		}
		if(!password1.equals(password2)) {
			System.out.println("确认密码与输入密码不一致");
			model.addAttribute("error", "确认密码与输入密码不一致");
			return "register";
		}
		RegisterDTO registerDTO = new RegisterDTO();
		registerDTO.setName(name);
		registerDTO.setPassword(password1);
		registerDTO.setStudentNum(studentNum);
		registerDTO.setCreateT(System.currentTimeMillis());
		registerDTO.setModifiedT(registerDTO.getCreateT());
		if(userService.selectUserByStudentNum(studentNum)!=null) {
			model.addAttribute("error", "学号"+studentNum+"的同学已经注册过了！");
			return "register";
		}
		if(userService.createUser(registerDTO)) {
			model.addAttribute("message", "恭喜"+name+"同学注册成功！");
			return "success";
		}else {
			model.addAttribute("error", "账户注册失败，请稍后重试！");
			return "register";
		}
	}
	
	@PostMapping("returnHome")
	public String returnHome() {
		return "redirect:/";
	}
}
