package com.tirmizee.backend.api.image.data;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ChangeImageProfileDTO implements Serializable{

	private static final long serialVersionUID = -2640777860098491337L;
	
	private String name;
	private MultipartFile imgProfile;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImgProfile() {
		return imgProfile;
	}
	public void setImgProfile(MultipartFile imgProfile) {
		this.imgProfile = imgProfile;
	}
	
}
