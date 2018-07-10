package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Permission;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface PermissionRepository extends JdbcRepository<Permission, Long>{

	public static final String TABLE_PERMISSION = "Permission";
	public static final String COL_PERID = "perId";
	public static final String COL_PERCODE = "perCode";
	public static final String COL_PERNAME = "perName";
	public static final String COL_PERDESC = "perDesc";
	public static final String COL_CREATEDATE = "createDate";
	public static final String COL_UPDATEDATE = "updateDate";
	
	public static final String ALL = "Permission.*";
	public static final String PERID = "Permission.perId";
	public static final String PERCODE = "Permission.perCode";
	public static final String PERNAME = "Permission.perName";
	public static final String PERDESC = "Permission.perDesc";
	public static final String CREATEDATE = "Permission.createDate";
	public static final String UPDATEDATE = "Permission.updateDate";
	
}