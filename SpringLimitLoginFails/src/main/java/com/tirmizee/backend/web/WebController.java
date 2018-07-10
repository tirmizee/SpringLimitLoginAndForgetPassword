package com.tirmizee.backend.web;

import org.assertj.core.internal.cglib.core.Local;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
//	private static Logger LOG = Logger.getLogger(WebController.class);
	
	@PreAuthorize("hasAnyAuthority('TR001')")
	@GetMapping(path = "/main")
	public ModelAndView main(){
		return new ModelAndView("pages/main");
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@GetMapping(path = "/permission")
	public ModelAndView permission(){
		System.out.println(LocaleContextHolder.getLocale().getLanguage());
		return new ModelAndView("pages/permission");
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@GetMapping(path = "/role")
	public ModelAndView role(){
		return new ModelAndView("pages/role");
	}
	
	@PreAuthorize("hasAnyAuthority('TR004')")
	@GetMapping(path = "/setting")
	public ModelAndView setting(){
		return new ModelAndView("pages/setting");
	}
	
}
