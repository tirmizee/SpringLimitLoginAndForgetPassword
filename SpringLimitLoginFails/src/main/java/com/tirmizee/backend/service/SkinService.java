package com.tirmizee.backend.service;

import com.tirmizee.backend.web.data.ResponseMessage;

public interface SkinService {
	
	ResponseMessage updateByUsername(String username, Integer skinId);
	
}
