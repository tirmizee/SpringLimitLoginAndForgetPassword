package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Role;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("RoleRepository")
public class RoleRepositoryImpl extends AbstractMssqlRepository<Role, Integer> implements RoleRepository{

	public RoleRepositoryImpl() {
		this(TABLE_ROLE);
	}
	
	public RoleRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_ROLEID);
	}
	
	public static final RowMapper<Role> ROW_MAPPER = new RowMapper<Role>() {
		@Override
		public Role mapRow(ResultSet rs, int arg1) throws SQLException {
			Role role = new Role();
			role.setRoleId(rs.getInt(COL_ROLEID));
			role.setRoleName(rs.getString(COL_ROLENAME));
			role.setRoleDesc(rs.getString(COL_ROLEDESC));
			role.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			role.setUpdateDate(rs.getTimestamp(COL_UPDATEDATE));
			return role.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<Role> ROW_UNMAPPER = new RowUnmapper<Role>() {
		@Override
		public Map<String, Object> mapColumns(Role param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(COL_ROLEID, param.getRoleId());
			map.put(COL_ROLENAME, param.getRoleName());
			map.put(COL_ROLEDESC, param.getRoleDesc());
			map.put(COL_CREATEDATE, param.getCreateDate());
			map.put(COL_UPDATEDATE, param.getUpdateDate());
			return map;
		}
	};

	@Override
	protected <S extends Role> S postCreate(S entity, Number generatedId) {
		entity.setRoleId(generatedId.intValue());
		return entity;
	}
	
	

}
