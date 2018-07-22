package com.tirmizee.core.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.tirmizee.core.config.SecurityConfig;
import com.tirmizee.core.exception.IAccountExpiredException;
import com.tirmizee.core.exception.IBadCredentialsException;
import com.tirmizee.core.exception.ICredentialsExpiredException;
import com.tirmizee.core.exception.ICredentialsFirstloginException;
import com.tirmizee.core.exception.IDisabledException;
import com.tirmizee.core.exception.ILockedException;
import com.tirmizee.core.exception.IUsernameNotFoundException;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
	
	private final RedirectStrategy strategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {

		if (exception instanceof IUsernameNotFoundException) {
			
			determineRedirectUrl(request, response, "/login?error=Username Not Found");
			
		}else if(exception instanceof ILockedException){
			
			determineRedirectUrl(request, response, "/login?error=User account is locked");
			
		}else if(exception instanceof IAccountExpiredException){
			
			determineRedirectUrl(request, response, "/login?error=User account has expired");
			
		}else if(exception instanceof IDisabledException){
			
			determineRedirectUrl(request, response, "/login?error=User account is disabled");
			
		}else if(exception instanceof IBadCredentialsException) {
			
			determineRedirectUrl(request, response, "/login?error=Credentials Not Valid");
			
		}else if (exception instanceof ICredentialsFirstloginException) {
			
			final ICredentialsFirstloginException firstloginEx = (ICredentialsFirstloginException) exception;
			final String username = firstloginEx.getUsername();
			SecurityContextHolderUtils.grantAuthority(username, SecurityConfig.FORCE_CHANGE_PASSWAORD);
			request.setAttribute("username", username);
			determineUrl(request, response, "/ForcePasswordChange");
	
		}else if(exception instanceof ICredentialsExpiredException) {
			
			final ICredentialsExpiredException credentialsExpiredEx = (ICredentialsExpiredException) exception;
			final String username = credentialsExpiredEx.getUsername();
			SecurityContextHolderUtils.grantAuthority(username,SecurityConfig.CHANGE_PASSWAORD_EXPIRED);
			request.setAttribute("username", username);
			determineUrl(request, response, "/ForcePasswordChangeExpired" );
		
		}
		
	}
	
	private void determineUrl( HttpServletRequest request, HttpServletResponse response, String url)
			throws ServletException, IOException{
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void determineRedirectUrl( HttpServletRequest request, HttpServletResponse response, String url) 
			throws ServletException, IOException{
		strategy.sendRedirect(request, response, url);
	}
	
}
