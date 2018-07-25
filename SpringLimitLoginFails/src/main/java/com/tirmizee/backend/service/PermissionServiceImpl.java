package com.tirmizee.backend.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tirmizee.backend.api.permission.data.RoleMapPermissonDTO;
import com.tirmizee.backend.dao.RoleMapPermissionDao;
import com.tirmizee.backend.web.data.ResponseMessage;
import com.tirmizee.core.domain.RoleMapPermission;
import com.tirmizee.core.exception.BussinesException;

@Service
public class PermissionServiceImpl implements PermissionService{
	
	@Autowired
	private RoleMapPermissionDao roleMapPermissionDao;

	@Override
	public ResponseMessage createPermissionsOfRole(RoleMapPermissonDTO mapPermissonDTO) {
		RoleMapPermission entity = new RoleMapPermission();
		Integer roleId = mapPermissonDTO.getRoleId();
		Long perId = mapPermissonDTO.getPerId();
		Long newId = concatenateDigits(roleId,perId);
		
		checkIdDuplicate(newId);
		
		entity.setFkRoleId(roleId);
		entity.setId(newId);
		entity.setFkPerId(perId);
		entity.setCreateDate(nowTimestamp());
		roleMapPermissionDao.save(entity);
		return new ResponseMessage();
	}
	
	@Override
	public ResponseMessage deletePermissionOfRole(RoleMapPermissonDTO mapPermissonDTO) {
		Long id = concatenateDigits(mapPermissonDTO.getRoleId(),mapPermissonDTO.getPerId());
		roleMapPermissionDao.delete(id);
		return new ResponseMessage();
	}

	private void checkIdDuplicate(Long newId) {
		RoleMapPermission roleMapPermission = roleMapPermissionDao.findOne(newId);
		if (roleMapPermission != null) {
			throw new BussinesException(HttpStatus.BAD_REQUEST,"Already in the system");
		}
	}

	private Long concatenateDigits(Integer roleId, Long perId){
		return Long.valueOf(String.valueOf(roleId) + String.valueOf(perId));
	}
	
	private Timestamp nowTimestamp(){
		return new Timestamp(new Date().getTime());
	}

}
