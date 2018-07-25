package com.tirmizee.backend.service;

import org.springframework.core.io.Resource;

import com.tirmizee.backend.api.member.data.MemberAccountNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberAccountNonLockedDTO;
import com.tirmizee.backend.api.member.data.MemberCredentialsNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberEnabledDTO;
import com.tirmizee.backend.api.member.data.MemberUpdateDTO;
import com.tirmizee.backend.api.member.data.RegisterDTO;
import com.tirmizee.backend.web.data.ResponseMessage;

public interface MemberService {
	
	void checkUsername(String username);
	
	Boolean registerMember(RegisterDTO registerDto);

	ResponseMessage delete(String username);
	
	ResponseMessage update(MemberUpdateDTO memberDTO);
	
	ResponseMessage updateEnabled(MemberEnabledDTO enabledDTO);
	
	ResponseMessage updateAccountNonLocked(MemberAccountNonLockedDTO accountNonLockedDTO);
	
	ResponseMessage updateAccountNonExpired(MemberAccountNonExpiredDTO accountExpiredDTO);
	
	ResponseMessage updateCredentialsNonExpired(MemberCredentialsNonExpiredDTO credentialsNonExpiredDTO);
	
	Resource getImageProfile(String username);

}
