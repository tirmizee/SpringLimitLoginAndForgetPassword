package com.tirmizee.backend.web;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorWebController {
	
	private static final Logger LOGGER = Logger.getLogger(ErrorWebController.class);
	
	@GetMapping(value = "/AccessDenied")
	@ResponseStatus(code = HttpStatus.FORBIDDEN)
	public ModelAndView accessDenied(ModelAndView modelAndView) {
		LOGGER.debug("/AccessDenied");
		modelAndView.setViewName("error/403");
		return modelAndView;
	}
	
	@GetMapping(value = "/NotFound")
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ModelAndView notFound(ModelAndView modelAndView, @RequestParam String RequestURL) {
		LOGGER.debug("/NotFound");
		modelAndView.setViewName("error/404");
		modelAndView.addObject("RequestURL", RequestURL);
		return modelAndView;
	}
	
	@GetMapping(value = "/ServerError")
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	public ModelAndView serverError(ModelAndView modelAndView) {
		LOGGER.debug("/ServerError");
		modelAndView.setViewName("error/500");
		return modelAndView;
	}
	
}
