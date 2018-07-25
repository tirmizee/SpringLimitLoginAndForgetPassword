package com.tirmizee.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.api.image.data.ChangeImageProfileDTO;
import com.tirmizee.backend.web.data.ResponseMessage;

@Service
public class MemberImageServiceImpl implements MemberImageService{
	
	@Autowired @Qualifier("StorageImageService")
	private StorageService storageImageService;

	@Override
	public ResponseMessage updateProfile(ChangeImageProfileDTO profileDTO) {
		storageImageService.store(profileDTO.getImgProfile());
		return new ResponseMessage();
	}

}
