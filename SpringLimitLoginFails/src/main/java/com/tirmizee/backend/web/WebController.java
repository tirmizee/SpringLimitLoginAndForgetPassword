package com.tirmizee.backend.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	private static Logger LOG = Logger.getLogger(WebController.class);
	
	@GetMapping(path = "/main")
	public ModelAndView main(){
		return new ModelAndView("pages/main");
	}
	
	@GetMapping(path = "/permission")
	public ModelAndView permission(){
		return new ModelAndView("pages/permission");
	}
	
}
