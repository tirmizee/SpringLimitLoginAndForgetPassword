package com.tirmizee.backend.service;

import com.tirmizee.backend.api.permission.data.RoleMapPermissonDTO;
import com.tirmizee.backend.web.data.ResponseMessage;

public interface PermissionService {

	ResponseMessage createPermissionOfRole(RoleMapPermissonDTO mapPermissonDTO);
	
	ResponseMessage deletePermissionOfRole(RoleMapPermissonDTO mapPermissonDTO);
	
}
