package com.tirmizee.backend.service;

import com.tirmizee.backend.service.data.SimpleMailInfo;

public interface MailService {
	
	void sendSimpleMail(SimpleMailInfo mailInfo);
}
