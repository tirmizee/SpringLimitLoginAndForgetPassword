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

import com.tirmizee.backend.api.attemp.data.MemberAttemptDTO;
import com.tirmizee.backend.api.attemp.data.SearchAttempDTO;
import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.repository.MemberAttemptRepositoryImpl;


@Repository("MemberAttemptDao")
public class MemberAttemptDaoImpl extends MemberAttemptRepositoryImpl implements MemberAttemptDao{

	public static final RowMapper<MemberAttemptDTO> PAGE_ATTEMP_MAPPER = new RowMapper<MemberAttemptDTO>() {
		@Override
		public MemberAttemptDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberAttemptDTO attemptDTO = new MemberAttemptDTO();
			attemptDTO.setUsername(rs.getString(COL_USERNAME));
			attemptDTO.setAttempts(rs.getInt(COL_ATTEMPTS));
			attemptDTO.setLastModified(rs.getTimestamp(COL_LASTMODIFIED));
			return attemptDTO;
		}
	};

	@Override
	public MemberAttempt findByUsername(String username) {
		try {
			StringBuilder select = new StringBuilder()
				.append(" select * from ").append(TABLE_MEMBERATTEMPT)
				.append(" where ").append(COL_USERNAME).append(" = ? ");
			return getJdbcOps().queryForObject(select.toString(), new Object[]{username}, ROW_MAPPER);
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Page<MemberAttemptDTO> findByCriteria(SearchAttempDTO search, Pageable pageable) {
		List<Object> params = new LinkedList<>();
		List<MemberAttemptDTO> content = null;
		String selectPage = null;
		Long total = null;
		StringBuilder select = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_MEMBERATTEMPT)
			.append(" WHERE ").append(COL_ID).append(" IS NOT NULL");
		if (search.getUsername() != null) {
			select.append(" AND ").append(COL_USERNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getUsername()) + "%");
		}
		if (search.getAttempts() != null) {
			select.append(" AND ").append(COL_ATTEMPTS).append(" = ? ");
			params.add(search.getAttempts());
		}
		total = count(select.toString(), params.toArray());
		selectPage = getSqlGenerator().selectAll(getTable(), select, pageable);
		content = getJdbcOps().query(selectPage, params.toArray(), PAGE_ATTEMP_MAPPER);
		return new PageImpl<>(content, pageable, total);
	}

}
