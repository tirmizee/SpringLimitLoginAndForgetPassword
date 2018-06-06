package com.tirmizee.core.repository;

import com.tirmizee.core.jdbcrepository.JdbcRepository;
import com.tirmizee.core.domain.Role;

public interface RoleRepository extends JdbcRepository<Role, Integer>{

	public static final String TABLE_ROLE = "Role";
	public static final String COL_ROLEID = "roleId";
	public static final String COL_ROLENAME = "roleName";
	public static final String COL_ROLEDESC = "roleDesc";
	public static final String COL_CREATEDATE = "createDate";
	public static final String COL_UPDATEDATE = "updateDate";
	
	public static final String ROLEID = "Role.roleId";
	public static final String ROLENAME = "Role.roleName";
	public static final String ROLEDESC = "Role.roleDesc";
	public static final String CREATEDATE = "Role.createDate";
	public static final String UPDATEDATE = "Role.updateDate";
	
}