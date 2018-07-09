package com.tirmizee.backend.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.api.permission.data.SearchPermissionDTO;
import com.tirmizee.core.domain.Permission;
import com.tirmizee.core.repository.PermissionRepository;

public interface PermissionDao extends PermissionRepository{
	
	List<Permission> findByUsername(String username);
	
	Page<Permission> findByCriteria(SearchPermissionDTO search, Pageable pageable);

}
