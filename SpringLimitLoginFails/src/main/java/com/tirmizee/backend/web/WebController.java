package com.tirmizee.backend.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tirmizee.backend.dao.RoleDao;

@Controller
public class WebController {
	
	public static Logger LOGGER = Logger.getLogger(WebController.class);
	
	@Autowired
	private RoleDao roleDao;
	
	@GetMapping(path = "/profile")
	public ModelAndView profile(){
		return new ModelAndView("pages/profile/profile");
	}
	
	@PreAuthorize("hasAnyAuthority('TR001')")
	@GetMapping(path = "/main")
	public ModelAndView main(){
		return new ModelAndView("pages/main/main");
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@GetMapping(path = "/role")
	public ModelAndView permission(){
		return new ModelAndView("pages/role/role");
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@GetMapping(path = "/member")
	public ModelAndView member(){
		ModelAndView modelAndView = new ModelAndView("pages/member/member");
		modelAndView.addObject("roles", roleDao.findAll());
		return modelAndView;
	}
	
	@PreAuthorize("hasAnyAuthority('TR004')")
	@GetMapping(path = "/log")
	public ModelAndView log(){
		return new ModelAndView("pages/log/log");
	}
	
}
