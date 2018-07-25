package com.tirmizee.backend.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.ForgetPasswordDao;
import com.tirmizee.backend.service.ForgetPasswordService;
import com.tirmizee.core.exception.UrlNotFoundException;

@Controller
public class RootWebController {
	
	public static Logger LOG = Logger.getLogger(RootWebController.class);
	
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
		if (error != null){	model.addObject("error",error); }
		return model;
	}
	
	@PostMapping(path = "/ForcePasswordChange")
	public ModelAndView forcePasswordChange(HttpServletRequest request){
		return new ModelAndView("pages/changePasswordFirstLogin");
	}
	
	@PostMapping(path = "/ForcePasswordChangeExpired")
	public ModelAndView forcePasswordChangeExpired(HttpServletRequest request){
		return new ModelAndView("pages/changePasswordExpired");
	}
	
	@GetMapping(path = "/ForgetPassword")
	public ModelAndView forgetPassword(){
		return new ModelAndView("pages/forgetPassword");
	}
	
	@GetMapping(path = "/Register")
	public ModelAndView register(){
		return new ModelAndView("pages/register");
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
