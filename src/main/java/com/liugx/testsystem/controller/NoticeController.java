package com.liugx.testsystem.controller;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.MessageDTO;
import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.enums.MessageTypeEnum;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.service.NoticeService;

@Controller
public class NoticeController {
	 
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("/user/notice")
	public String notice(HttpServletRequest request
			,@RequestParam(name = "page", defaultValue = "1") Integer page
            ,@RequestParam(name = "size", defaultValue = "3") Integer size
			,Model model) {
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) 
			return  "redirect:/";
		PaginationDTO paginationDTO=noticeService.list(user,page,size);
		model.addAttribute("pagination", paginationDTO);
		return "/user/notice";
	}
	
	@GetMapping("/user/notice/{id}")
	public String profile(HttpServletRequest request,
			@PathVariable(name = "id") Long id) {
		User user = (User) request.getSession().getAttribute("user");
		if(user == null) 
			return  "redirect:/";
		MessageDTO messageDTO = noticeService.read(id,user);
		if(MessageTypeEnum.isAllUser(messageDTO.getMessageType())) {
			return "redirect:/user/test/testInfo/"+messageDTO.getTestId();
		}else {
			return "redirect:/user/preTest?testId="+messageDTO.getTestId();
		}
		
	}
}
