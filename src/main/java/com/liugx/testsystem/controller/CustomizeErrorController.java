package com.liugx.testsystem.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class CustomizeErrorController implements ErrorController  {
	
	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		BasicErrorController e;
		return "error";
	}
	@RequestMapping(produces = MediaType.TEXT_HTML_VALUE)
	public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		HttpStatus status = getStatus(request);
		if(status.is4xxClientError()) {
			model.addAttribute("message", "请求错误,请重新请求");
		}else if(status.is5xxServerError()) {
			model.addAttribute("message", "服务端错误，请稍后再试");
		}
		return new ModelAndView("error");
	}
	private HttpStatus getStatus(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Integer statusCode = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		}
		catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}
}
