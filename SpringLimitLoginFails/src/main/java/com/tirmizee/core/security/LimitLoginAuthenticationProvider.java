package com.tirmizee.core.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tirmizee.backend.service.MemberAttemptService;

public class LimitLoginAuthenticationProvider extends DaoAuthenticationProvider {
	
	public static final Logger LOG = Logger.getLogger(LimitLoginAuthenticationProvider.class);
	
	@Autowired
	private MemberAttemptService memberAttemptService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username = authentication.getName();
		try{
			Authentication authen = super.authenticate(authentication);
			if (authen.isAuthenticated()) {
				memberAttemptService.resetMemberAttempt(username);
			}
			return authen;
		}catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException(username);
		}catch (BadCredentialsException e) {
			memberAttemptService.updateMemberAttempt(username);
			throw new BadCredentialsException(username);
		}
	}

}
    