package com.tirmizee.core.repository;

import com.tirmizee.core.domain.RoleMapPermission;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface RoleMapPermissionRepository extends JdbcRepository<RoleMapPermission, Long>{

	public static final String TABLE_ROLE_MAP_PERMISSION = "Role_Map_Permission";
	public static final String COL_ID = "id";
	public static final String COL_FKROLEID = "fkRoleId";
	public static final String COL_FKPERID = "fkPerId";
	public static final String COL_CREATEDATE = "createDate";
	
	public static final String ID = "Role_Map_Permission.id";
	public static final String FKROLEID = "Role_Map_Permission.fkRoleId";
	public static final String FKPERID = "Role_Map_Permission.fkPerId";
	public static final String CREATEDATE = "Role_Map_Permission.createDate";
	
}