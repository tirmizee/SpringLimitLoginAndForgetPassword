package com.tirmizee.backend.service;

import com.tirmizee.backend.api.member.data.MemberAccountNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberAccountNonLockedDTO;
import com.tirmizee.backend.api.member.data.MemberCredentialsNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberEnabledDTO;
import com.tirmizee.backend.api.member.data.MemberUpdateDTO;
import com.tirmizee.backend.api.member.data.RegisterDto;
import com.tirmizee.backend.web.data.ResponseMessage;

public interface MemberService {
	
	void checkUsername(String username);
	
	Boolean registerMember(RegisterDto registerDto);

	ResponseMessage delete(String username);
	
	ResponseMessage update(MemberUpdateDTO memberDTO);
	
	ResponseMessage updateEnabled(MemberEnabledDTO enabledDTO);
	
	ResponseMessage updateAccountNonLocked(MemberAccountNonLockedDTO accountNonLockedDTO);
	
	ResponseMessage updateAccountNonExpired(MemberAccountNonExpiredDTO accountExpiredDTO);
	
	ResponseMessage updateCredentialsNonExpired(MemberCredentialsNonExpiredDTO credentialsNonExpiredDTO);

}
