package com.tirmizee.backend.service;

import com.tirmizee.backend.api.image.data.ChangeImageProfileDTO;
import com.tirmizee.backend.web.data.ResponseMessage;

public interface MemberImageService {
	
	ResponseMessage updateProfile(ChangeImageProfileDTO profileDTO);

}
