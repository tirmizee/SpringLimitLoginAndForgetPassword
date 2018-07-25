package com.tirmizee.backend.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.api.member.data.MemberAccountNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberAccountNonLockedDTO;
import com.tirmizee.backend.api.member.data.MemberCredentialsNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberEnabledDTO;
import com.tirmizee.backend.api.member.data.MemberUpdateDTO;
import com.tirmizee.backend.api.member.data.RegisterDTO;
import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.dao.MemberImageDao;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.component.PageMapper;
import com.tirmizee.core.domain.Member;
import com.tirmizee.core.domain.MemberImage;
import com.tirmizee.core.exception.BussinesException;
import com.tirmizee.core.exception.UrlNotFoundException;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired 
	private PageMapper mapper;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberImageDao memberImageDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Boolean registerMember(RegisterDTO registerDto) {
		
		checkUsername(registerDto.getUsername());
		
		Member member = new Member();
		member.setEmail(registerDto.getEmail());
		member.setUsername(registerDto.getUsername());
		member.setPassword(passwordEncoder.encode(registerDto.getPassword()));
		member.setFkRoleId(2);
		member.setAccountNonExpired(true);
		member.setAccountNonLocked(true);
		member.setEnabled(true);
		member.setCredentialsNonExpired(true);
		member.setInitialLogin(false);
		member.setCredentialsExpiredDate(plus60Days());
		member.setCreateDate(nowTimestamp());
		memberDao.save(member);
		return true;
	}
	
	@Override
	public void checkUsername(String username) {
		Member member = memberDao.findOne(username);		
		if ( member != null) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, "ERROR002", username);
		}
	}
	
	@Override
	public ResponseMessage updateAccountNonLocked(MemberAccountNonLockedDTO AccountNonLockedDTO) {
		Member member = memberDao.findOne(AccountNonLockedDTO.getUsername());
		mapper.map(AccountNonLockedDTO, member);
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		return new ResponseMessage();
	}
	
	@Override
	public ResponseMessage updateAccountNonExpired(MemberAccountNonExpiredDTO accountExpiredDTO) {
		Member member = memberDao.findOne(accountExpiredDTO.getUsername());
		mapper.map(accountExpiredDTO, member);
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		return new ResponseMessage();
	}
	
	@Override
	public ResponseMessage updateEnabled(MemberEnabledDTO enabledDTO) {
		Member member = memberDao.findOne(enabledDTO.getUsername());
		mapper.map(enabledDTO, member);
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		return new ResponseMessage();
	}
	
	@Override
	public ResponseMessage updateCredentialsNonExpired(MemberCredentialsNonExpiredDTO credentialsNonExpiredDTO) {
		Member member = memberDao.findOne(credentialsNonExpiredDTO.getUsername());
		mapper.map(credentialsNonExpiredDTO, member);
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		return new ResponseMessage();
	}

	@Override
	public ResponseMessage update(MemberUpdateDTO memberDTO) {
		Member member = memberDao.findOne(memberDTO.getUsername());
		mapper.map(memberDTO, member);
		member.setUpdateDate(nowTimestamp());
		memberDao.save(member);
		return new ResponseMessage();
	}
	
	@Override
	public ResponseMessage delete(String username) {
		memberDao.delete(username);
		return new ResponseMessage();
	}
	
	private Timestamp nowTimestamp(){
		return new Timestamp(new Date().getTime());
	}
	
	private Timestamp plus60Days(){
		LocalDateTime localDateTime = LocalDateTime.now().plusDays(60);
		return Timestamp.valueOf(localDateTime);
	}

	@Override
	public Resource getImageProfile(String username) {
		MemberImage image = memberImageDao.findByUsername(username);
		if (image == null) {
			throw new UrlNotFoundException();
		}
		return new FileSystemResource( StorageImageServiceImpl.UPLOAD_PATH + image.getImgOriginalName());
	}

}