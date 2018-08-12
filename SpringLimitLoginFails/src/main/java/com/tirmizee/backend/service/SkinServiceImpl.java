package com.tirmizee.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.domain.Member;

@Service
public class SkinServiceImpl implements SkinService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public ResponseMessage updateByUsername(String username, Integer skinId) {
		Member entity = memberDao.findOne(username);
		entity.setFkSkinId(skinId);
		memberDao.save(entity);
		return new ResponseMessage();
	}

}
