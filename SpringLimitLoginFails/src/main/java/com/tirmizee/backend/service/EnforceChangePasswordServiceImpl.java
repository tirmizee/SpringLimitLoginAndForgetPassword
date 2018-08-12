package com.tirmizee.backend.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.api.password.data.ChangePasswordDTO;
import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.core.domain.Member;
import com.tirmizee.core.exception.BussinesException;

@Service("ForcePasswordChangeService")
public class EnforceChangePasswordServiceImpl implements EnforceChangePasswordService {
	
	@Autowired
	private MemberDao memberDao; 
	
	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Override
	public void changePasswordFirstLogin(ChangePasswordDTO changePasswordDTO) {
		
		String principal = SecurityContextHolder.getContext().getAuthentication().getName();
		if (!changePasswordDTO.getUsername().equals(principal)) {
			throw new BussinesException(HttpStatus.FORBIDDEN, "FORBIDDEN");
		}
		
		Member member = memberDao.findFirstLogin(changePasswordDTO.getUsername());
		if (member == null || !changePasswordDTO.isPasswordsEqualConstraint()) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
		}
		
		member.setPassword(passwordEncoder.encode(changePasswordDTO.getPassword()));
		member.setUpdateDate(nowTimestamp());
		member.setInitialLogin(false);
		memberDao.save(member);
		
	}
	
	@Override
	public void changePasswordExpired(ChangePasswordDTO changePasswordDTO) {
		
		Member member = memberDao.findOne(changePasswordDTO.getUsername());
		if (member == null || !changePasswordDTO.isPasswordsEqualConstraint()) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, "BAD REQUEST");
		}
		
		member.setPassword(passwordEncoder.encode(changePasswordDTO.getPassword()));
		member.setInitialLogin(false);
		member.setCredentialsNonExpired(true);
		member.setCredentialsExpiredDate(plus60Days());
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		
	}
	
	@Override
	public void updatePasswordExpired(String username) {
		Member member = memberDao.findOne(username);
		member.setCredentialsNonExpired(false);
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
	}
	
	@Override
	public boolean isPasswordExpired(Timestamp ExpiryDate){
		return nowTimestamp().after(ExpiryDate);
	}
	
	private Timestamp plus60Days(){
		LocalDateTime localDateTime = LocalDateTime.now().plusDays(60);
		return Timestamp.valueOf(localDateTime);
	}
	
	private Timestamp nowTimestamp(){
		return new Timestamp(new Date().getTime());
	}

}
