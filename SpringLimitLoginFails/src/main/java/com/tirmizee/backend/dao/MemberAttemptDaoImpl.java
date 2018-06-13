package com.tirmizee.backend.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.MemberAttempt;
import com.tirmizee.core.repository.MemberAttemptRepositoryImpl;


@Repository("MemberAttemptDao")
public class MemberAttemptDaoImpl extends MemberAttemptRepositoryImpl implements MemberAttemptDao{

	@Override
	public MemberAttempt findByUsername(String username) {
		try {
			StringBuilder select = new StringBuilder()
				.append(" select * from ").append(TABLE_MEMBERATTEMPT)
				.append(" where ").append(COL_USERNAME).append(" = ? ");
			return getJdbcOps().queryForObject(select.toString(),new Object[]{username},ROW_MAPPER);
		}catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
