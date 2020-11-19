package com.liugx.testsystem.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.service.TestHistoryService;

@Controller
public class TestHistroyController {

	@Autowired
	private TestHistoryService testHistoryService;
	
	@GetMapping("/user/testhistory/row/{testId}")
	public String row(Model model
			,@PathVariable("testId")Long testId
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "3")Integer size) {
		TestDTO testDTO=testHistoryService.selectByTestId(testId);
		PaginationDTO paginationDTO = testHistoryService.list(page, size,testId);
		model.addAttribute("pagination", paginationDTO);
		model.addAttribute("test", testDTO);
		return "/user/row";
	}
	
	@GetMapping("/user/testhistory/report/{testId}")
	public String report(Model model
			,@PathVariable("testId")Long testId
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		TestDTO testDTO=testHistoryService.selectByTestId(testId);
		PaginationDTO paginationDTO = testHistoryService.userReport(testId,user);
		model.addAttribute("pagination", paginationDTO);
		model.addAttribute("test", testDTO);
		return "/user/testreport";
	}
	
	@GetMapping("/user/testhistory/testInfo/{testId}")
	public String testInfo(Model model
			,@PathVariable("testId")Long testId
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "1")Integer size
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		TestDTO testDTO=testHistoryService.selectByTestId(testId);
		PaginationDTO paginationDTO = testHistoryService.userQuestionOfTest(testId,user,page,size);
		model.addAttribute("pagination", paginationDTO);
		model.addAttribute("test", testDTO);
		return "/user/usertestinfo";
	}
}
