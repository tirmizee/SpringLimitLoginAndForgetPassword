package com.tirmizee.backend.api.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.permission.data.PermissionDTO;
import com.tirmizee.backend.api.permission.data.RoleMapPermissonDTO;
import com.tirmizee.backend.api.permission.data.SearchPermissionDTO;
import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.backend.service.PermissionService;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.component.PageMapper;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestTable;
import com.tirmizee.core.datatable.ResponseTable;
import com.tirmizee.core.domain.Permission;

@RestController
@RequestMapping(path="api/permission")
public class ApiPermission {
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private PageMapper mapper;
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/findAll")
	public ResponseTable<PermissionDTO> findAll(@RequestBody RequestTable<SearchPermissionDTO> request){
		Pageable pageable = PageRequestHelper.build(request, PermissionDTO.class);
		Page<Permission> page = permissionDao.findByCriteria(request.getSerch(), pageable);
		return new ResponseTable<>(mapper.map(page, PermissionDTO.class));
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/findAllByRole")
	public ResponseTable<PermissionDTO> findAllByRole(@RequestBody RequestTable<SearchPermissionDTO> request){
		Pageable pageable = PageRequestHelper.build(request, PermissionDTO.class);
		Page<PermissionDTO> page = permissionDao.findPermissionOfRole(request.getSerch(), pageable);
		return new ResponseTable<>(page);
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/createRoleMapPermission")
	public ResponseMessage createRoleMapPermission(@RequestBody RoleMapPermissonDTO request){
		return permissionService.createPermissionOfRole(request);
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/deleteRoleMapPermission")
	public ResponseMessage deleteRoleMapPermission(@RequestBody RoleMapPermissonDTO request){
		return permissionService.deletePermissionOfRole(request);
	}
	
}
 