package com.tirmizee.backend.service;

import com.tirmizee.backend.service.data.SampleMailInfo;

public interface MailService {
	
	void send(SampleMailInfo mailInfo);
}
