package com.tirmizee.backend.api.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.image.data.ChangeImageProfileDTO;
import com.tirmizee.backend.service.MemberImageService;
import com.tirmizee.backend.web.data.ResponseMessage;

@RestController
@RequestMapping(path = "api/image")
public class MemberImageApi {
	
	@Autowired
	private MemberImageService MemberImageService;
	
	@PostMapping(path = "/updateProfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseMessage updateProfile(@ModelAttribute ChangeImageProfileDTO dto) {
		return MemberImageService.updateProfile(dto);
	}
	
}
