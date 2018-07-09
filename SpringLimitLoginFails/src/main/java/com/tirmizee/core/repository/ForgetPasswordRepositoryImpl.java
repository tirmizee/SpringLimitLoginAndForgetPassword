package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import com.tirmizee.core.domain.ForgetPassword;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

public class ForgetPasswordRepositoryImpl extends AbstractMssqlRepository<ForgetPassword, Long> implements ForgetPasswordRepository{


	public ForgetPasswordRepositoryImpl() {
		this(TABLE_FORGETPASSWORD);
	}
	
	public ForgetPasswordRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_ID);
	}
	
	protected static final RowMapper<ForgetPassword> ROW_MAPPER = new RowMapper<ForgetPassword>() {
		@Override
		public ForgetPassword mapRow(ResultSet rs, int arg1) throws SQLException {
			ForgetPassword forgetPassword = new ForgetPassword();
			forgetPassword.setId(rs.getLong(COL_ID));
			forgetPassword.setUsername(rs.getString(COL_USERNAME));
			forgetPassword.setToken(rs.getString(COL_TOKEN));
			forgetPassword.setAccessIP(rs.getString(COL_ACCESSIP));
			forgetPassword.setExpiryDate(rs.getTimestamp(COL_EXPIRYDATE));
			forgetPassword.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			return forgetPassword;
		}
	};
	
	protected static final RowUnmapper<ForgetPassword> ROW_UNMAPPER = new RowUnmapper<ForgetPassword>() {
		@Override
		public Map<String, Object> mapColumns(ForgetPassword param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(COL_ID , param.getId());
			map.put(COL_USERNAME , param.getUsername());
			map.put(COL_TOKEN , param.getToken());
			map.put(COL_ACCESSIP, param.getAccessIP());
			map.put(COL_EXPIRYDATE , param.getExpiryDate());
			map.put(COL_CREATEDATE, param.getCreateDate());
			return map;
		}
	};

	@Override
	protected <S extends ForgetPassword> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.longValue());
		return entity;
	}

}
