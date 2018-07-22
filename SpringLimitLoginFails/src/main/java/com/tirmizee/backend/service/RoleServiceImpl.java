package com.tirmizee.backend.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tirmizee.backend.api.role.data.CreateRoleDTO;
import com.tirmizee.backend.api.role.data.EditRoleDTO;
import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.dao.RoleDao;
import com.tirmizee.backend.dao.RoleMapPermissionDao;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.component.PageMapper;
import com.tirmizee.core.config.RepositoryConfig;
import com.tirmizee.core.domain.Member;
import com.tirmizee.core.domain.Role;
import com.tirmizee.core.domain.RoleMapPermission;
import com.tirmizee.core.exception.BussinesException;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired 
	private RoleDao roleDao;
	
	@Autowired 
	private MemberDao memberDao;
	
	@Autowired
	private RoleMapPermissionDao roleMapPermissionDao;
	
	@Autowired
	private PageMapper mapper;

	@Override
	@Transactional(value = RepositoryConfig.MSSQL_TRANSACTION)
	public ResponseMessage create(CreateRoleDTO createRoleDTO) {
		
		checkRoleDuplicate(createRoleDTO.getRoleName());
		
		Role entity = mapper.map(createRoleDTO, Role.class);
		entity.setCreateDate(nowTimestamp());
		
		Role persist = roleDao.save(entity);
		RoleMapPermission roleMapPermission = new RoleMapPermission();
		roleMapPermission.setId(concatenateDigits(persist.getId(),1L));
		roleMapPermission.setFkRoleId(persist.getId());
		roleMapPermission.setFkPerId(1L);
		roleMapPermission.setCreateDate(nowTimestamp());
		roleMapPermissionDao.save(roleMapPermission);
		
		return new ResponseMessage();
	}
	
	@Override
	@Transactional(value = RepositoryConfig.MSSQL_TRANSACTION)
	public ResponseMessage delete(Integer roleId) {
		checkDeleteRoleNotExist(roleId);
		checkIsUsedByMember(roleId);
		roleMapPermissionDao.delete(roleMapPermissionDao.findByRoleId(roleId));
		roleDao.delete(roleId);
		return new ResponseMessage();
	}
	
	@Override
	@Transactional(value = RepositoryConfig.MSSQL_TRANSACTION)
	public ResponseMessage edit(EditRoleDTO editRoleDTO) {
		checkEditNotDuplicate(editRoleDTO.getRoleName(),editRoleDTO.getRoleId());
		Role entity = roleDao.findOne(editRoleDTO.getRoleId());
		mapper.map(editRoleDTO, entity);
		entity.setUpdateDate(nowTimestamp());
		roleDao.save(entity);
		return new ResponseMessage();
	}
	
	private void checkEditNotDuplicate(String roleName, Integer roleId) {
		Role role = roleDao.findByRoleNameAndNotExistsRoleId(roleName, roleId);
		if (role != null) {
			throw new BussinesException(HttpStatus.BAD_REQUEST,"This role is not exist");
		}
	}

	private void checkIsUsedByMember(Integer roleId) {
		List<Member> list = memberDao.findByFKRoleId(roleId);
		if (list != null && !list.isEmpty()) {
			throw new BussinesException(HttpStatus.BAD_REQUEST, "The role is used by another");
		}
	}

	private void checkDeleteRoleNotExist(Integer roleId) {
		Role persist = roleDao.findOne(roleId);
		if (persist == null) {
			throw new BussinesException(HttpStatus.BAD_REQUEST,"This role is not exist");
		}
	}
	
	private void checkRoleDuplicate(String roleName) {
		Role persist = roleDao.findByRoleName(roleName);
		if (persist != null) {
			throw new BussinesException(HttpStatus.BAD_REQUEST,"This role is already in the system.");
		}
	}

	private Timestamp nowTimestamp(){
		return new Timestamp(new Date().getTime());
	}
	
	private Long concatenateDigits(Integer roleId, Long perId){
		return Long.valueOf(String.valueOf(roleId) + String.valueOf(perId));
	}

	

}
