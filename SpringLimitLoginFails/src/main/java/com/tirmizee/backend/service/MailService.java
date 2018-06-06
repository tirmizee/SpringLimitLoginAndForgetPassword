package com.tirmizee.backend.service;

import com.tirmizee.backend.service.data.MailInfo;

public interface MailService {
	
	void send(MailInfo mailInfo);
}
