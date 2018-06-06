package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Permission;
import com.tirmizee.core.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("PermissionRepository")
public class PermissionRepositoryImpl extends AbstractJdbcRepository<Permission, Long> implements PermissionRepository{

	public PermissionRepositoryImpl() {
		this(TABLE_PERMISSION);
	}
	
	public PermissionRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_PERID);
	}
	
	public static final RowMapper<Permission> ROW_MAPPER = new RowMapper<Permission>() {
		@Override
		public Permission mapRow(ResultSet rs, int arg1) throws SQLException {
			Permission permission = new Permission();
			permission.setPerId(rs.getLong(COL_PERID));
			permission.setPerCode(rs.getString(COL_PERCODE));
			permission.setPerName(rs.getString(COL_PERNAME));
			permission.setPerDesc(rs.getString(COL_PERDESC));
			permission.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			permission.setUpdateDate(rs.getTimestamp(COL_UPDATEDATE));
			return permission.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<Permission> ROW_UNMAPPER = new RowUnmapper<Permission>() {
		@Override
		public Map<String, Object> mapColumns(Permission param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(COL_PERID, param.getPerId());
			map.put(COL_PERCODE, param.getPerCode());
			map.put(COL_PERNAME, param.getPerName());
			map.put(COL_PERDESC, param.getPerDesc());
			map.put(COL_CREATEDATE, param.getCreateDate());
			map.put(COL_UPDATEDATE, param.getUpdateDate());
			return map;
		}
	};

	@Override
	protected <S extends Permission> S postCreate(S entity, Number generatedId) {
		entity.setPerId(generatedId.longValue());
		return entity;
	}
	
}
