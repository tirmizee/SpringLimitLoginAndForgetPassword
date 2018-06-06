package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.RoleMapPermission;
import com.tirmizee.core.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("RoleMapPermissionRepository")
public class RoleMapPermissionRepositoryImpl extends AbstractJdbcRepository<RoleMapPermission, Long> implements RoleMapPermissionRepository{

	public RoleMapPermissionRepositoryImpl() {
		this(TABLE_ROLE_MAP_PERMISSION);
	}
	
	public RoleMapPermissionRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_ID);
	}
	
	public static final RowMapper<RoleMapPermission> ROW_MAPPER = new RowMapper<RoleMapPermission>() {
		@Override
		public RoleMapPermission mapRow(ResultSet rs, int arg1) throws SQLException {
			RoleMapPermission rolemappermission = new RoleMapPermission();
			rolemappermission.setId(rs.getLong(COL_ID));
			rolemappermission.setFkRoleId(rs.getInt(COL_FKROLEID));
			rolemappermission.setFkPerId(rs.getLong(COL_FKPERID));
			rolemappermission.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			return rolemappermission.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<RoleMapPermission> ROW_UNMAPPER = new RowUnmapper<RoleMapPermission>() {
		@Override
		public Map<String, Object> mapColumns(RoleMapPermission param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(COL_ID, param.getId());
			map.put(COL_FKROLEID, param.getFkRoleId());
			map.put(COL_FKPERID, param.getFkPerId());
			map.put(COL_CREATEDATE, param.getCreateDate());
			return map;
		}
	};

	@Override
	protected <S extends RoleMapPermission> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.longValue());
		return entity;
	}

}
