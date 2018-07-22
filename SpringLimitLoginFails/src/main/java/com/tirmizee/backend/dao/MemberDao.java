package com.tirmizee.backend.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.api.member.data.MemberDTO;
import com.tirmizee.backend.api.member.data.MemberProfile;
import com.tirmizee.backend.api.member.data.SearchMemberDTO;
import com.tirmizee.core.domain.Member;
import com.tirmizee.core.domain.MemberAndRole;
import com.tirmizee.core.repository.MemberRepository;

public interface MemberDao extends MemberRepository{
	
	MemberProfile findProfileByUsername(String username);
	
	MemberAndRole findMemberAndRoleByUsername(String username);
	
	Member findByUsername(String username);
	
	Member findByEmail(String email);
	
	Member findByToken(String token);
	
	Member findFirstLogin(String username);
	
	Page<MemberDTO> findAllPage(SearchMemberDTO search, Pageable pageable);
	
	List<Member> findByFKRoleId(Integer Id);
	
}
