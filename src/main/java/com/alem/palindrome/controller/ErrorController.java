package com.alem.palindrome.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Alemberhan Getahun
 *
 */

@Controller("error")
public class ErrorController {
	
	private final static Logger logger = LoggerFactory.getLogger(ErrorController.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException
		(HttpServletRequest request, Exception ex){
		ModelAndView mv = new ModelAndView();

		mv.addObject("exception", ex.getMessage());
		mv.setViewName("error");
		logger.error(ex.getMessage());
		return mv;
	}

}