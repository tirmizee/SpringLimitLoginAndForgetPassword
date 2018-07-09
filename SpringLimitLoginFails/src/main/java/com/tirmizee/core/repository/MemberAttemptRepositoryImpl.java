package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("MemberAttemptRepository")
public class MemberAttemptRepositoryImpl extends AbstractMssqlRepository<MemberAttempt, Long> implements MemberAttemptRepository{

	public MemberAttemptRepositoryImpl() {
		this(TABLE_MEMBERATTEMPT);
	}
	
	public MemberAttemptRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_ID);
	}
	
	public static final RowMapper<MemberAttempt> ROW_MAPPER = new RowMapper<MemberAttempt>() {
		@Override
		public MemberAttempt mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberAttempt memberattempt = new MemberAttempt();
			memberattempt.setId(rs.getLong(COL_ID));
			memberattempt.setUsername(rs.getString(COL_USERNAME));
			memberattempt.setAttempts(rs.getInt(COL_ATTEMPTS));
			memberattempt.setLastModified(rs.getTimestamp(COL_LASTMODIFIED));
			return memberattempt.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<MemberAttempt> ROW_UNMAPPER = new RowUnmapper<MemberAttempt>() {
		@Override
		public Map<String, Object> mapColumns(MemberAttempt param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(COL_ID, param.getId());
			map.put(COL_USERNAME, param.getUsername());
			map.put(COL_ATTEMPTS, param.getAttempts());
			map.put(COL_LASTMODIFIED, param.getLastModified());
			return map;
		}
	};

	@Override
	protected <S extends MemberAttempt> S postCreate(S entity, Number generatedId) {
		entity.setId(generatedId.longValue());
		return entity;
	}
	
}
