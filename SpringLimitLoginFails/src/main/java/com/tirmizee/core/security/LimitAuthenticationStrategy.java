package com.tirmizee.core.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

public class LimitAuthenticationStrategy  extends RegisterSessionAuthenticationStrategy{
	
	public static final int MAX_USERS = 1;
	
	private SessionRegistry sessionRegistry;

	public LimitAuthenticationStrategy(SessionRegistry sessionRegistry) {
		super(sessionRegistry);
		this.sessionRegistry = sessionRegistry;
	}

	@Override
	public void onAuthentication(Authentication authentication, HttpServletRequest request,
			HttpServletResponse response) {
		if (sessionRegistry.getAllPrincipals().size() > MAX_USERS) {
            throw new SessionAuthenticationException("Maximum number of users exceeded");
        }
		super.onAuthentication(authentication, request, response);
	}
	
}
