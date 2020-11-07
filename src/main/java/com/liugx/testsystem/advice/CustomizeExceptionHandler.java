package com.liugx.testsystem.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.liugx.testsystem.execption.CustomizeException;

@ControllerAdvice
public class CustomizeExceptionHandler {
	@ExceptionHandler(Exception.class)
	ModelAndView handle(HttpServletRequest request, Throwable ex,
			Model model) {
		 if (ex instanceof CustomizeException) {
             model.addAttribute("message", ex.getMessage());
         }
         return new ModelAndView("error");
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}
}
