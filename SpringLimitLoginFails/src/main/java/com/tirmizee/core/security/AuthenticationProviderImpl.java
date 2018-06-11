package com.tirmizee.core.security;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tirmizee.backend.service.EnforceChangePasswordService;
import com.tirmizee.backend.service.MemberAttemptService;
import com.tirmizee.core.exception.GTCredentialsExpiredException;
import com.tirmizee.core.exception.CredentialsFirstloginException;

public class AuthenticationProviderImpl extends DaoAuthenticationProvider {
	
	public static final Logger LOG = Logger.getLogger(AuthenticationProviderImpl.class);
	
	@Autowired
	private MemberAttemptService memberAttemptService;
	
	@Autowired
	private EnforceChangePasswordService enforceChangePasswordService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username = authentication.getName();
		UserProfile userProfile;
		try{
			Authentication authen = super.authenticate(authentication);
			userProfile =  (UserProfile) authen.getPrincipal();
			if (userProfile.isInitialLogin()) {
				throw new CredentialsFirstloginException( username , "Force password change");
			}
			if (enforceChangePasswordService.isPasswordExpired(userProfile.getCredentialsExpiredDate())) {
				enforceChangePasswordService.updatePasswordExpired(username);
				throw new GTCredentialsExpiredException(username,"User account credentials have expired");
			}
			if (authen.isAuthenticated()) {
				memberAttemptService.resetMemberAttempt(username);
			}
			return authen;
		}catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException(username);
		}catch (BadCredentialsException e) {
			memberAttemptService.updateMemberAttempt(username);
			throw new BadCredentialsException(username);
		}catch (CredentialsExpiredException e) {
			throw new GTCredentialsExpiredException(username,"User account credentials have expired");
		}
	}
	
}
        