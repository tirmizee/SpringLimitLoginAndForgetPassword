package com.tirmizee.backend.api.member;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.member.data.MemberAccountNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberAccountNonLockedDTO;
import com.tirmizee.backend.api.member.data.MemberCredentialsNonExpiredDTO;
import com.tirmizee.backend.api.member.data.MemberDTO;
import com.tirmizee.backend.api.member.data.MemberEnabledDTO;
import com.tirmizee.backend.api.member.data.MemberProfile;
import com.tirmizee.backend.api.member.data.MemberUpdateDTO;
import com.tirmizee.backend.api.member.data.RegisterDTO;
import com.tirmizee.backend.api.member.data.SearchMemberDTO;
import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.service.MemberService;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.component.PageMapper;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestTable;
import com.tirmizee.core.datatable.ResponseTable;
import com.tirmizee.core.domain.Member;

@RestController
@RequestMapping(path="api/member")
public class ApiMember {
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private PageMapper mapper;
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@PostMapping(path = "/findAllPage")
	public ResponseTable<MemberDTO> findAllPage(@RequestBody RequestTable<SearchMemberDTO> request){
		Pageable pageable = PageRequestHelper.build(request, MemberDTO.class);
		Page<MemberDTO> page = memberDao.findAllPage(request.getSerch(), pageable);
		return new ResponseTable<>(page);
	}
	
	@PostMapping(path = "/register")
	public Boolean register(@RequestBody @Valid RegisterDTO registerDto){
		return memberService.registerMember(registerDto);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@PostMapping(path = "/update")
	public ResponseMessage edit(@RequestBody @Valid MemberUpdateDTO memberDTO){
		return memberService.update(memberDTO);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@GetMapping(path = "/delete/{username}")
	public ResponseMessage delete(@PathVariable String username){
		return memberService.delete(username);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@PostMapping(path = "/updateAccountNonLocked")
	public ResponseMessage updateAccountNonLocked(@RequestBody @Valid MemberAccountNonLockedDTO accountNonLockedDTO){
		return memberService.updateAccountNonLocked(accountNonLockedDTO);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@PostMapping(path = "/updateAccountNonExpired")
	public ResponseMessage updateAccountNonExpired(@RequestBody @Valid MemberAccountNonExpiredDTO accountExpiredDTO){
		return memberService.updateAccountNonExpired(accountExpiredDTO);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@PostMapping(path = "/credentialsNonExpired")
	public ResponseMessage credentialsNonExpired(@RequestBody @Valid MemberCredentialsNonExpiredDTO memberCreNonExpiredDTO){
		return memberService.updateCredentialsNonExpired(memberCreNonExpiredDTO);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@PostMapping(path = "/updateEnabled")
	public ResponseMessage updateEnabled(@RequestBody @Valid MemberEnabledDTO enabledDTO){
		return memberService.updateEnabled(enabledDTO);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@GetMapping(path = "/get/{username}")
	public MemberDTO get(@PathVariable String username){
		Member member = memberDao.findOne(username);
		return mapper.map(member, MemberDTO.class);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@GetMapping(path = "/getProfile/{username}")
	public MemberProfile getProfile(@PathVariable String username){
		return memberDao.findProfileByUsername(username);
	}
	
	@PreAuthorize("hasAnyAuthority('TR003')")
	@GetMapping(path = "/getImageProfile/{username}", produces = { MediaType.IMAGE_JPEG_VALUE,	MediaType.IMAGE_PNG_VALUE })
	public Resource getProfileImage(@PathVariable String username){
		return memberService.getImageProfile(username);
	}
	
}
