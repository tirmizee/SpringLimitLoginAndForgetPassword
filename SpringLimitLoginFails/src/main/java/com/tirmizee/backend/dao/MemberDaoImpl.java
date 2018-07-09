package com.tirmizee.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Member;
import com.tirmizee.core.domain.MemberAndRole;
import com.tirmizee.core.repository.ForgetPasswordRepository;
import com.tirmizee.core.repository.MemberRepositoryImpl;
import com.tirmizee.core.repository.RoleRepository;

@Repository("MemberDao")
public class MemberDaoImpl extends MemberRepositoryImpl implements MemberDao {

	public static final RowMapper<MemberAndRole> MEMBER_AND_ROLE_MAPPER = new RowMapper<MemberAndRole>() {
		@Override
		public MemberAndRole mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberAndRole memberAndRole = new MemberAndRole();
			memberAndRole.setUsername(rs.getString(COL_USERNAME));
			memberAndRole.setPassword(rs.getString(COL_PASSWORD));
			memberAndRole.setEmail(rs.getString(COL_EMAIL));
			memberAndRole.setFkRoleId(rs.getInt(COL_FKROLEID));
			memberAndRole.setEnabled(rs.getBoolean(COL_ENABLED));
			memberAndRole.setAccountNonLocked(rs.getBoolean(COL_ACCOUNTNONLOCKED));
			memberAndRole.setAccountNonExpired(rs.getBoolean(COL_ACCOUNTNONEXPIRED));
			memberAndRole.setCredentialsNonExpired(rs.getBoolean(COL_CREDENTIALSNONEXPIRED));
			memberAndRole.setInitialLogin(rs.getBoolean(COL_INITIALLOGIN));
			memberAndRole.setCredentialsExpiredDate(rs.getTimestamp(COL_CREDENTIALSEXPIREDDATE));
			memberAndRole.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			memberAndRole.setUpdateDate(rs.getTimestamp(COL_UPDATEDATE));
			memberAndRole.setRoleId(rs.getInt(RoleRepository.COL_ROLEID));
			memberAndRole.setRoleName(rs.getString(RoleRepository.COL_ROLENAME));
			memberAndRole.setRoleDesc(rs.getString(RoleRepository.COL_ROLEDESC));
			memberAndRole.setCreateDate(rs.getTimestamp(RoleRepository.COL_CREATEDATE));
			memberAndRole.setUpdateDate(rs.getTimestamp(RoleRepository.COL_UPDATEDATE));
			return memberAndRole;
		}
	};

	@Override
	public Member findByUsername(String username) {
		try {
			StringBuilder select = new StringBuilder()
					.append("SELECT * FROM ").append(TABLE_MEMBER)
					.append(" WHERE ").append(COL_USERNAME).append(" = ?");
			return getJdbcOps().queryForObject(select.toString(), new Object[]{username}, ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public Member findByEmail(String email) {
		try {
			StringBuilder select = new StringBuilder()
				.append("SELECT * FROM ").append(TABLE_MEMBER)
				.append(" WHERE ").append(COL_EMAIL).append(" = ?");
			return getJdbcOps().queryForObject(select.toString(), new Object[]{email}, ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Member findByToken(String token) {
		try {
			StringBuilder select = new StringBuilder()
				.append("SELECT ").append(TABLE_MEMBER).append(".*")
				.append(" FROM ").append(TABLE_MEMBER).append(" INNER JOIN ")
				.append(ForgetPasswordRepository.TABLE_FORGETPASSWORD)
				.append(" ON ").append(USERNAME).append(" = ")
				.append(ForgetPasswordRepository.USERNAME).append(" WHERE ")
				.append(ForgetPasswordRepository.TOKEN).append(" = ? ");
			return getJdbcOps().queryForObject(select.toString(), new Object[]{token}, ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Member findFirstLogin(String username) {
		try {
			StringBuilder select = new StringBuilder()
				.append("SELECT * FROM ").append(TABLE_MEMBER)
				.append(" WHERE ").append(COL_USERNAME).append(" = ? ")
				.append(" AND ").append(COL_INITIALLOGIN).append(" = 1 ");
			return getJdbcOps().queryForObject(select.toString(), new Object[]{username}, ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public MemberAndRole findMemberAndRoleByUsername(String username) {
		try {
			StringBuilder select = new StringBuilder()
				.append("SELECT * FROM ").append(TABLE_MEMBER)
				.append(" JOIN ").append(RoleRepository.TABLE_ROLE)
				.append(" ON ").append(FKROLEID).append(" = ").append(RoleRepository.ROLEID)
				.append(" WHERE ").append(USERNAME).append(" = ? ");
			return getJdbcOps().queryForObject(select.toString(), new Object[]{username}, MEMBER_AND_ROLE_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
