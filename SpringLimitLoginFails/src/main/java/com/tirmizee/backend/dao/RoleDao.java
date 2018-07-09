package com.tirmizee.backend.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tirmizee.backend.api.role.data.SearchRoleDTO;
import com.tirmizee.core.domain.Role;
import com.tirmizee.core.repository.RoleRepository;

public interface RoleDao extends RoleRepository {
	
	Page<Role> findByCriteria(SearchRoleDTO searchCriteria, Pageable pageable);

}
