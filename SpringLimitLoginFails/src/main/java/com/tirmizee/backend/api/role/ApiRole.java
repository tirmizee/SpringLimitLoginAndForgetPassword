package com.tirmizee.backend.api.role;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tirmizee.backend.api.role.data.CreateRoleDTO;
import com.tirmizee.backend.api.role.data.EditRoleDTO;
import com.tirmizee.backend.api.role.data.RoleDTO;
import com.tirmizee.backend.api.role.data.SearchRoleDTO;
import com.tirmizee.backend.dao.RoleDao;
import com.tirmizee.backend.service.RoleService;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.component.PageMapper;
import com.tirmizee.core.datatable.PageRequestHelper;
import com.tirmizee.core.datatable.RequestTable;
import com.tirmizee.core.datatable.ResponseTable;
import com.tirmizee.core.domain.Role;

@RestController
@RequestMapping(path="api/role")
public class ApiRole {
	
	@Autowired 
	private RoleDao roleDao;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private PageMapper mapper;
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/findAll")
	public ResponseTable<RoleDTO> findAll(@RequestBody RequestTable<SearchRoleDTO> request){
		Pageable pageable = PageRequestHelper.build(request, RoleDTO.class);
		Page<Role> page = roleDao.findByCriteria(request.getSerch(), pageable);
		return new ResponseTable<>(mapper.map(page, RoleDTO.class));
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/create")
	public ResponseMessage create(@Valid @RequestBody CreateRoleDTO createRoleDTO){
		return roleService.create(createRoleDTO);
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@GetMapping(path = "/delete/{roleId}")
	public ResponseMessage delete(@PathVariable Integer roleId){
		return roleService.delete(roleId);
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@PostMapping(path = "/edit")
	public ResponseMessage edit(@Valid @RequestBody EditRoleDTO dto){
		return roleService.edit(dto);
	}
	
	@PreAuthorize("hasAnyAuthority('TR002')")
	@GetMapping(path = "/get/{roleId}")
	public RoleDTO get(@PathVariable Integer roleId){
		Role role = roleDao.findOne(roleId);
		return mapper.map(role, RoleDTO.class);
	}
	
}
