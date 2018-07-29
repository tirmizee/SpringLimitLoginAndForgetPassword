package com.tirmizee.backend.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.PostCode;
import com.tirmizee.core.repository.PostCodeRepositoryImpl;

@Repository
public class PostCodeDaoImpl extends PostCodeRepositoryImpl implements PostCodeDao {

	@Override
	public PostCode findBySubdistrictCode(String code) {
		
		StringBuilder select = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_POSTCODES)
			.append(" WHERE ").append(SUBDISTRICTCODE).append(" = ? ");
		try {
			return getJdbcOps().queryForObject(select.toString(), params(code), ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		
	}

}
