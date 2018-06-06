package com.tirmizee.core.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationMessages {
	
	public String getLastError(HttpServletRequest request){
		final Exception exception = (Exception) request.getSession().getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		if (exception instanceof UsernameNotFoundException ) {
			return "Username Not Found ";
		}else if(exception instanceof LockedException) {
			return exception.getMessage();
		}else if(exception instanceof BadCredentialsException) {
			return "Credentials Not Valid";
		}
		return exception.getMessage();
	}

}
