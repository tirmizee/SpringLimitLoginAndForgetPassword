package com.tirmizee.backend.service;

import com.tirmizee.backend.api.role.data.CreateRoleDTO;
import com.tirmizee.backend.api.role.data.EditRoleDTO;
import com.tirmizee.backend.web.data.ResponseMessage;

public interface RoleService {
	
	ResponseMessage create(CreateRoleDTO createRoleDTO);
	
	ResponseMessage delete(Integer roleId);
	
	ResponseMessage edit(EditRoleDTO editRoleDTO);
	
}
