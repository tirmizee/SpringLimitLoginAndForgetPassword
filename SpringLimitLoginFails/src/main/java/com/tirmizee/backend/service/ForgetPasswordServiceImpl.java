package com.tirmizee.backend.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.api.password.data.ResetPasswordDTO;
import com.tirmizee.backend.dao.ForgetPasswordDao;
import com.tirmizee.backend.dao.MemberAttemptDao;
import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.service.data.SimpleMailInfo;
import com.tirmizee.core.component.TemplateUtils;
import com.tirmizee.core.domain.ForgetPassword;
import com.tirmizee.core.domain.Member;
import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.exception.BussinesException;

@Service("ForgetPasswordService")
public class ForgetPasswordServiceImpl implements ForgetPasswordService{
	
	public static final  int EXPIRED_MINITE = 5;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberAttemptDao memberAttemptDao;
	
	@Autowired
	private HttpServletRequest request;

	@Autowired
	private ForgetPasswordDao forgetPasswordDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private TemplateUtils template;
	
	@Override
	public Boolean forgetPassword(String email) {
	    
		Member member = memberDao.findByEmail(email);
		if (member == null) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, "ERROR001");
		}
		
		ForgetPassword forgetPassword = forgetPasswordDao.findByUsername(member.getUsername());
		if (forgetPassword == null) {
			forgetPassword = new ForgetPassword();
		}
		
		forgetPassword.setUsername(member.getUsername());
		forgetPassword.setExpiryDate(getExpiryDate());
		forgetPassword.setCreateDate(nowTimestamp());
		forgetPassword.setToken(generateUUID());
		forgetPassword.setAccessIP(request.getRemoteAddr());
		forgetPasswordDao.save(forgetPassword);
		
		sendMailForgetPassword(email,forgetPassword.getToken());
		
		return true;
	}
	
	@Override
	public void resetPassword(ResetPasswordDTO resetDTO) {
		
		final String token = resetDTO.getToken();
		ForgetPassword forgetPassword = forgetPasswordDao.findByToken(token);

		if (forgetPassword == null) {
			throw new BussinesException(HttpStatus.NOT_FOUND,"Not Found");
		}
		
		if (!resetDTO.isPasswordsEqualConstraint()) {
			throw new BussinesException(HttpStatus.BAD_REQUEST,"Bad Request");
		}
		
		if (isTokenExpired(token)) {
			throw new BussinesException(HttpStatus.REQUEST_TIMEOUT,"Request Timeout");
		}
		
		Member member = memberDao.findByToken(token);
		member.setAccountNonLocked(true);
		member.setPassword(passwordEncoder.encode(resetDTO.getPassword()));
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		
		MemberAttempt memberAttempt = memberAttemptDao.findByUsername(member.getUsername());
		memberAttempt.setAttempts(0);
		memberAttemptDao.save(memberAttempt);
		
	}
	
	@Override
	public Boolean isTokenExpired(String token) {
		ForgetPassword forgetPassword = forgetPasswordDao.findByToken(token);
		return nowTimestamp().after(forgetPassword.getExpiryDate());
	}
	
	public String generateUUID(){
		return UUID.randomUUID().toString();
	}
	
	public String generateUrl(String token){
		String baseUrl = String.format("%s://%s:%d%s", request.getScheme(), request.getServerName(), request.getServerPort(), request.getContextPath());
		return baseUrl + "/ResetPassword/" + token;
	}
	
	public Timestamp nowTimestamp() {
		return new Timestamp(new Date().getTime());
	}
	
	public Timestamp getExpiryDate() {
		LocalDateTime dateTime = LocalDateTime.now().plusMinutes(EXPIRED_MINITE);
		return Timestamp.valueOf(dateTime);
	}
	
	public void sendMailForgetPassword(String email,String token){
		
		Map<String, Object> model = new HashMap<>();
		model.put("url", generateUrl(token));
		
		SimpleMailInfo info = new SimpleMailInfo();
		info.setDate(new Date());
		info.setFrom("tirmizee@com");
		info.setTo("pratyay@generali.co.th");
		info.setSubject("Reset Password");
		info.setContent(template.load("ForgetPassword.ftl", model));
		mailService.sendSimpleMail(info);
		
	}

}
