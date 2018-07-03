package com.tirmizee.backend.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.dao.MemberAttemptDao;
import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.core.domain.Member;
import com.tirmizee.core.domain.MemberAttempt;

@Service("MemberAttemptService")
public class MemberAttemptServiceImpl implements MemberAttemptService{
	
	public static final int MAX_LOGIN_FAIL = 3;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberAttemptDao memberAttemptDao;
	
	@Override
	public void resetMemberAttempt(final String username) {
		MemberAttempt attempt = memberAttemptDao.findByUsername(username);
		if (attempt == null) {
			attempt = new MemberAttempt();
			attempt.setUsername(username);
		}
		attempt.setAttempts(0);
		memberAttemptDao.save(attempt);
	}
	
	@Override
	public void updateMemberAttempt(final String username) {
		
		MemberAttempt memberAttempt = memberAttemptDao.findByUsername(username);
		if (memberAttempt == null) {
			memberAttempt = new MemberAttempt();
			memberAttempt.setUsername(username);
			memberAttempt.setAttempts(0);
		}
		
		final int attemp = memberAttempt.getAttempts();
		memberAttempt.setAttempts(plusOne(attemp));
		memberAttempt.setLastModified(nowTimestamp());
		memberAttemptDao.save(memberAttempt);
		
		if ((attemp + 1) >= MAX_LOGIN_FAIL) {
			Member member = memberDao.findByUsername(username);
			member.setAccountNonLocked(false);
			memberDao.save(member);
		}
		
	}
	
	private int plusOne(int attempts){
		return attempts + 1;
	}
	
	private Timestamp nowTimestamp(){
		return new Timestamp(new Date().getTime());
	}

}
