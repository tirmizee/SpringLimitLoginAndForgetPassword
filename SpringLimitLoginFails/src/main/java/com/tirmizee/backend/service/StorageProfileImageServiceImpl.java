package com.tirmizee.backend.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service("StorageImageService")
public class StorageProfileImageServiceImpl implements StorageService{
	
	public static final String UPLOAD_PATH = "D:\\ProjectSpring\\images\\profile\\";
	
	@Override
	public void store(MultipartFile fileToStore) {
		
		String extension = FilenameUtils.getExtension(fileToStore.getOriginalFilename());
		
		try {
			File file = new File(UPLOAD_PATH + UUID.randomUUID().toString() + "." + extension);
			FileCopyUtils.copy(fileToStore.getBytes(),file);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}

	@Override
	public void delete(String fileName) {
		try {
			FileUtils.forceDelete(FileUtils.getFile(UPLOAD_PATH + fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
