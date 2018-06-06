package com.tirmizee.backend.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.ForgetPasswordDao;
import com.tirmizee.backend.service.ForgetPasswordService;
import com.tirmizee.core.exception.UrlNotFoundException;
import com.tirmizee.core.security.AuthenticationMessages;

@Controller
public class WebController {
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private AuthenticationMessages authMessages;
	
	@Autowired
	private ForgetPasswordDao forgetPasswordDao;
	
	@Autowired
	private ForgetPasswordService forgetPasswordService;
	
	@GetMapping(path = "/")
	public ModelAndView index(){
		return new ModelAndView("index");
	}
	
	@GetMapping(value = "/login")
	public ModelAndView login(@RequestParam(required = false) String error){
        ModelAndView model = new ModelAndView("index");
		if (error != null) {
			model.addObject("error", authMessages.getLastError(httpServletRequest));
		}
		return model;
	}
	
	@GetMapping(path = "/main")
	public ModelAndView main(){
		return new ModelAndView("pages/main");
	}
	
	@GetMapping(path = "/ForgetPassword")
	public ModelAndView forgetPassword(){
		return new ModelAndView("pages/forgetPassword");
	}
	
	@GetMapping(path="/ResetPassword/{token}")
	public ModelAndView resetPassword(@PathVariable String token){
		if (forgetPasswordDao.findByToken(token) == null) {
			throw new UrlNotFoundException(); 
		}
		if (forgetPasswordService.isTokenExpired(token)) {
			throw new UrlNotFoundException(); 
		}
		ModelAndView modelAndView = new ModelAndView("pages/resetPassword");
		modelAndView.addObject("token",token);
		return modelAndView;
	}

}
