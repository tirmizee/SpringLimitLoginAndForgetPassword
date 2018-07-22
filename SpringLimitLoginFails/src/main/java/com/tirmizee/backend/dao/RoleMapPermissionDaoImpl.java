package com.tirmizee.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.RoleMapPermission;
import com.tirmizee.core.repository.RoleMapPermissionRepositoryImpl;

@Repository("RoleMapPermissionDao")
public class RoleMapPermissionDaoImpl extends RoleMapPermissionRepositoryImpl implements RoleMapPermissionDao{

	@Override
	public List<RoleMapPermission> findByRoleId(Integer roleId) {
		StringBuilder select = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_ROLE_MAP_PERMISSION)
			.append(" WHERE ").append(COL_FKROLEID).append(" = ? ");
		return getJdbcOps().query(select.toString(),ROW_MAPPER , params(roleId));
	}

}
