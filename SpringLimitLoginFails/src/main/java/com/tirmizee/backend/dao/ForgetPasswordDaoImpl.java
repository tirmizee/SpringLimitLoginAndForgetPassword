package com.tirmizee.backend.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.ForgetPassword;
import com.tirmizee.core.repository.ForgetPasswordRepositoryImpl;

@Repository("ForgetPasswordDao")
public class ForgetPasswordDaoImpl extends ForgetPasswordRepositoryImpl implements ForgetPasswordDao{

	@Override
	public ForgetPassword findByToken(String token) {
		StringBuilder select = new StringBuilder()
			.append("SELECT * FROM ").append(TABLE_FORGETPASSWORD)
			.append(" WHERE ").append(COL_TOKEN)
			.append(" = ? ");
		try {
			return getJdbcOps().queryForObject(select.toString(), new Object[]{token} ,ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

	@Override
	public ForgetPassword findByUsername(String username) {
		StringBuilder select = new StringBuilder()
				.append("SELECT * FROM ").append(TABLE_FORGETPASSWORD)
				.append(" WHERE ").append(COL_USERNAME)
				.append(" = ? ");
		try {
			return getJdbcOps().queryForObject(select.toString(), new Object[]{username} ,ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
