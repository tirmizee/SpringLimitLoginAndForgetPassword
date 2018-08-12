package com.tirmizee.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;


@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler{
	
	public static final Logger LOG = Logger.getLogger(AccessDeniedHandlerImpl.class);

	private static final String URL_ACCESSDENIED = "/AccessDenied";
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		response.sendRedirect(request.getContextPath() + URL_ACCESSDENIED);
	}

}
