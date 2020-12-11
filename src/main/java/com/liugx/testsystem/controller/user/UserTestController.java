package com.liugx.testsystem.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liugx.testsystem.dto.PaginationDTO;
import com.liugx.testsystem.dto.ResultDTO;
import com.liugx.testsystem.dto.TestDTO;
import com.liugx.testsystem.dto.TestIdDTO;
import com.liugx.testsystem.dto.UserAnswerDTO;
import com.liugx.testsystem.dto.UserTestDTO;
import com.liugx.testsystem.execption.CustomizeException;
import com.liugx.testsystem.model.User;
import com.liugx.testsystem.service.UserAndTestService;
import com.liugx.testsystem.service.manage.TestService;

@Controller
public class UserTestController {
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private UserAndTestService userAndTestService;
	
	@GetMapping("/user/allTest")
	public String allTest(Model model
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "3")Integer size) {
		PaginationDTO paginationDTO = testService.list(page, size);
		model.addAttribute("pagination", paginationDTO);
		return "/user/allTest";
	}
	
	@PostMapping("/user/test/signup")
	@ResponseBody
	public Object signUp(@RequestBody TestIdDTO testIdDTO
			,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		Object object = userAndTestService.signUp(testIdDTO,user);
		if( object !=null &&object instanceof CustomizeException) {
			return ResultDTO.errorOf((CustomizeException)object);
		}else {
			return ResultDTO.okOf();
		}
		
	}
	
	@PostMapping("/user/test/signOut")
	@ResponseBody
	public Object signOut(@RequestBody TestIdDTO testIdDTO
			,HttpServletRequest request) {
		User user=(User) request.getSession().getAttribute("user");
		Object object = userAndTestService.signOut(testIdDTO,user);
		if( object !=null &&object instanceof CustomizeException) {
			return ResultDTO.errorOf((CustomizeException)object);
		}else {
			return ResultDTO.okOf();
		}
		
	}
	
	@GetMapping("/user/test/testInfo/{testId}")
	public String testInfo(Model model
			,@PathVariable("testId")Long testId) {
		TestDTO testDTO = testService.selectById(testId);
		model.addAttribute("testInfo", testDTO);
		return "/user/testInfo";
	}
	
	
	@GetMapping("/user/test/testInfo1/{testId}")
	public String testInfo1(Model model
			,@PathVariable("testId")Long testId) {
		TestDTO testDTO = testService.selectById(testId);
		model.addAttribute("testInfo", testDTO);
		return "/user/testInfo1";
	}
	
	//未开始的考试
	@GetMapping("/user/notBeginTest")
	public String notBeginTest(Model model
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "3")Integer size
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		PaginationDTO paginationDTO = userAndTestService.listNotBegin(page, size,user);
		model.addAttribute("pagination", paginationDTO);
		return "/user/notBeginTest";
	}
	
	//正在进行的考试
	@GetMapping("/user/startingTest")
	public String testStarting(Model model
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "3")Integer size
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		PaginationDTO paginationDTO = userAndTestService.listStartingTest(page, size, user);
		model.addAttribute("pagination", paginationDTO);
		return "/user/startingTest";
	}
	
	@PostMapping("/user/startingTest/startTest")
	@ResponseBody
	public Object testBegin(@RequestBody TestIdDTO testIdDTO
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		Object object=userAndTestService.initUserTest(testIdDTO,user);
		if(object ==null) {
			return ResultDTO.okOf("/user/startingTest/doTest/"+testIdDTO.getTestId());
		}else {
			return object;
		}
	}
	
	@GetMapping("/user/startingTest/doTest/{testId}")
	public String onTest(Model model
			,@PathVariable("testId")Long testId
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "1")Integer size
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		TestIdDTO testIdDTO =new TestIdDTO(testId);
		TestDTO testDTO = userAndTestService.getTestByTestIdDTO(testIdDTO);
		PaginationDTO paginationDTO = userAndTestService.listTestQuestion(testIdDTO,page, size, user);
		model.addAttribute("pagination", paginationDTO);
		model.addAttribute("test",testDTO);
		return "/user/doTest";
	}
	
	@PostMapping("/user/startingTest/doTest/submit")
	@ResponseBody
	public Object questionSubmit(@RequestBody UserAnswerDTO userAnswerDTO
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		ResultDTO resultDTO=(ResultDTO)userAndTestService.updateUserTestQuestionAnswer(user,userAnswerDTO);
		if(resultDTO!=null) {
			resultDTO.setRedirect("/user/home");
		}else {
			resultDTO=ResultDTO.okOf();
		}
		return resultDTO;
	}
	
	@PostMapping("/user/startingTest/doTest/submitAll")
	@ResponseBody
	public Object allQuestionSubmit(@RequestBody TestIdDTO testIdDTO
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		userAndTestService.submitUserTest(user, testIdDTO.getTestId());
		return ResultDTO.okOf();
	}
	
	@GetMapping("/user/testhistory")
	public String testHistory(Model model
			,@RequestParam(value="page",defaultValue = "1")Integer page
			,@RequestParam(value="size",defaultValue = "3")Integer size
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		PaginationDTO paginationDTO = userAndTestService.listEnd(page, size,user);
		model.addAttribute("pagination", paginationDTO);
		return "/user/testhistory";
	}
	
	@GetMapping("/user/preTest")
	public String preTest(Model model
			,@RequestParam(value="testId")Long testId
			,HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("user");
		TestDTO testDTO = testService.selectById(testId);
		UserTestDTO userTestDTO=userAndTestService.listStartingTest(testId,user);
		model.addAttribute("testInfo", testDTO);
		model.addAttribute("userTest", userTestDTO);
		return "/user/preTest";
	}
	
}
