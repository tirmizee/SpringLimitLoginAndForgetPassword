package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Member;
import com.tirmizee.core.jdbcrepository.AbstractJdbcRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("MemberRepository")
public class MemberRepositoryImpl extends AbstractJdbcRepository<Member, String> implements MemberRepository{

	public MemberRepositoryImpl() {
		this(TABLE_MEMBER);
	}
	
	public MemberRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_USERNAME);
	}
	
	public static final RowMapper<Member> ROW_MAPPER = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int arg1) throws SQLException {
			Member member = new Member();
			member.setUsername(rs.getString(COL_USERNAME));
			member.setPassword(rs.getString(COL_PASSWORD));
			member.setEmail(rs.getString(COL_EMAIL));
			member.setFkRoleId(rs.getInt(COL_FKROLEID));
			member.setEnabled(rs.getBoolean(COL_ENABLED));
			member.setAccountNonLocked(rs.getBoolean(COL_ACCOUNTNONLOCKED));
			member.setAccountNonExpired(rs.getBoolean(COL_ACCOUNTNONEXPIRED));
			member.setCredentialsNonExpired(rs.getBoolean(COL_CREDENTIALSNONEXPIRED));
			member.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			member.setUpdateDate(rs.getTimestamp(COL_UPDATEDATE));
			return member.withPersisted(true);
		}
	};
	
	public static final RowUnmapper<Member> ROW_UNMAPPER = new RowUnmapper<Member>() {
		@Override
		public Map<String, Object> mapColumns(Member param) {
			LinkedHashMap<String, Object> map = new LinkedHashMap<>();
			map.put(COL_USERNAME, param.getUsername());
			map.put(COL_PASSWORD, param.getPassword());
			map.put(COL_FKROLEID, param.getFkRoleId());
			map.put(COL_EMAIL, param.getEmail());
			map.put(COL_ENABLED, param.getEnabled());
			map.put(COL_ACCOUNTNONLOCKED, param.getAccountNonLocked());
			map.put(COL_ACCOUNTNONEXPIRED, param.getAccountNonExpired());
			map.put(COL_CREDENTIALSNONEXPIRED, param.getCredentialsNonExpired());
			map.put(COL_CREATEDATE, param.getCreateDate());
			map.put(COL_UPDATEDATE, param.getUpdateDate());
			return map;
		}
	};

	@Override
	protected <S extends Member> S postUpdate(S entity) {
		entity.setPersisted(true);
		return entity;
	}

	@Override
	protected <S extends Member> S postCreate(S entity, Number generatedId) {
		entity.setPersisted(true);
		return entity;
	}

}
