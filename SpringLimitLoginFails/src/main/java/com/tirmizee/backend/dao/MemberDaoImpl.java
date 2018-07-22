package com.tirmizee.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.api.member.data.MemberDTO;
import com.tirmizee.backend.api.member.data.MemberProfile;
import com.tirmizee.backend.api.member.data.SearchMemberDTO;
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
	
	public static final RowMapper<MemberProfile> MEMBER_PROFILE_MAPPER = new RowMapper<MemberProfile>() {
		@Override
		public MemberProfile mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberProfile profile = new MemberProfile();
			profile.setUsername(rs.getString(COL_USERNAME));
			profile.setPassword(rs.getString(COL_PASSWORD));
			profile.setEmail(rs.getString(COL_EMAIL));
			profile.setFkRoleId(rs.getInt(COL_FKROLEID));
			profile.setEnabled(rs.getBoolean(COL_ENABLED));
			profile.setAccountNonLocked(rs.getBoolean(COL_ACCOUNTNONLOCKED));
			profile.setAccountNonExpired(rs.getBoolean(COL_ACCOUNTNONEXPIRED));
			profile.setCredentialsNonExpired(rs.getBoolean(COL_CREDENTIALSNONEXPIRED));
			profile.setCredentialsExpiredDate(rs.getTimestamp(COL_CREDENTIALSEXPIREDDATE));
			profile.setRoleName(rs.getString(RoleRepository.COL_ROLENAME));
			return profile;
		}
	}; 
	
	public static final RowMapper<MemberDTO> PAGE_MEMBER_MAPPER = new RowMapper<MemberDTO>() {
		@Override
		public MemberDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberDTO member = new MemberDTO();
			member.setUsername(rs.getString(COL_USERNAME));
			member.setEmail(rs.getString(COL_EMAIL));
			member.setFkRoleId(rs.getInt(COL_FKROLEID));
			member.setEnabled(rs.getBoolean(COL_ENABLED));
			member.setAccountNonLocked(rs.getBoolean(COL_ACCOUNTNONLOCKED));
			member.setAccountNonExpired(rs.getBoolean(COL_ACCOUNTNONEXPIRED));
			member.setCredentialsNonExpired(rs.getBoolean(COL_CREDENTIALSNONEXPIRED));
			member.setCredentialsExpiredDate(rs.getTimestamp(COL_CREDENTIALSEXPIREDDATE));
			member.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			member.setRoleName(rs.getString(RoleRepository.COL_ROLENAME));
			return member;
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

	@Override
	public Page<MemberDTO> findAllPage(SearchMemberDTO search, Pageable pageable) {
		List<Object> params = new LinkedList<>();
		List<MemberDTO> content = null;
		String selectPage = null;
		long total = 0;
		StringBuilder select = new StringBuilder()
			.append("SELECT ")
			.append(USERNAME).append(" , ")
			.append(EMAIL).append(" , ")
			.append(ENABLED).append(" , ")
			.append(ACCOUNTNONLOCKED).append(" , ")
			.append(ACCOUNTNONEXPIRED).append(" , ")
			.append(CREDENTIALSNONEXPIRED).append(" , ")
			.append(CREDENTIALSEXPIREDDATE).append(" , ")
			.append(CREATEDATE).append(" , ")
			.append(FKROLEID).append(" , ")
			.append(RoleRepository.ROLENAME)
			.append(" FROM ").append(TABLE_MEMBER)
			.append(" JOIN ").append(RoleRepository.TABLE_ROLE)
			.append(" ON ").append(FKROLEID).append(" = ").append(RoleRepository.ROLEID)
			.append(" WHERE ").append(USERNAME).append(" IS NOT NULL ");
		if (search.getUsername() != null) {
			select.append(" AND ").append(USERNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getUsername()) + "%");
		}
		if (search.getEmail() != null) {
			select.append(" AND ").append(EMAIL).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getEmail()) + "%");
		}
		if (search.getEnabled() != null) {
			select.append(" AND ").append(ENABLED).append(" = ? ");
			params.add(search.getEnabled());
			System.out.println(search.getEnabled());
		}
		if (search.getAccountNonLocked() != null) {
			select.append(" AND ").append(ACCOUNTNONLOCKED).append(" = ? ");
			params.add(search.getAccountNonLocked());
		}
		if (search.getAccountNonExpired() != null) {
			select.append(" AND ").append(ACCOUNTNONEXPIRED).append(" = ? ");
			params.add(search.getAccountNonExpired());
		}
		if (search.getCredentialsNonExpired() != null) {
			select.append(" AND ").append(CREDENTIALSNONEXPIRED).append(" = ? ");
			params.add(search.getCredentialsNonExpired());
		}
		if (search.getRoleId() != null) {
			select.append(" AND ").append(FKROLEID).append(" = ? ");
			params.add(search.getRoleId());
		}
		selectPage = getSqlGenerator().selectAll(getTable(), select, pageable);
		content = getJdbcOps().query(selectPage, params.toArray(), PAGE_MEMBER_MAPPER);
		total = count(select.toString(),params.toArray());
		return new PageImpl<>(content, pageable, total);
	}

	@Override
	public List<Member> findByFKRoleId(Integer Id) {
		StringBuilder select = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_MEMBER)
			.append(" WHERE ").append(COL_FKROLEID).append(" = ? ");
		return getJdbcOps().query(select.toString(), ROW_MAPPER,params(Id));
	}

	@Override
	public MemberProfile findProfileByUsername(String username) {
		try {
			StringBuilder select = new StringBuilder()
				.append(" SELECT * FROM ").append(TABLE_MEMBER)
				.append(" INNER JOIN ").append(RoleRepository.TABLE_ROLE)
				.append(" ON ").append(FKROLEID).append(" = ").append(RoleRepository.ROLEID)
				.append(" WHERE ").append(USERNAME).append(" = ?  ");
			return getJdbcOps().queryForObject(select.toString(), params(username), MEMBER_PROFILE_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
