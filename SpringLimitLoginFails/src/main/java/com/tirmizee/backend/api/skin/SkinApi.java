package com.tirmizee.backend.api.skin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.skin.data.SearchSkinDTO;
import com.tirmizee.backend.dao.SkinDao;
import com.tirmizee.backend.service.SkinService;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.annotaion.CurrentUser;
import com.tirmizee.core.domain.Skin;
import com.tirmizee.core.security.UserProfile;

@RestController
@RequestMapping(path = "api/skin")
public class SkinApi {
	
	@Autowired
	private SkinDao skinDao;
	
	@Autowired
	private SkinService skinService; 

	@PreAuthorize("hasAnyAuthority('TR006')")
	@PostMapping(path = "/findByTerm")
	public Page<Skin> findByTerm(@RequestBody SearchSkinDTO search){
		return skinDao.findByTerm(search);
	}
	
	@PreAuthorize("hasAnyAuthority('TR006')")
	@GetMapping(path = "/holder/update/{id}")
	public ResponseMessage update(@PathVariable Integer id, @CurrentUser UserProfile profile){
		return skinService.updateByUsername(profile.getUsername(), id);
	}
	
}
