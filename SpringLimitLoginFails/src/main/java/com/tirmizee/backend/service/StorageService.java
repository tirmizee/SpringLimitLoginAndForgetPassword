package com.tirmizee.backend.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	
	void store(MultipartFile file);
	
	void delete(String fileName);

}
