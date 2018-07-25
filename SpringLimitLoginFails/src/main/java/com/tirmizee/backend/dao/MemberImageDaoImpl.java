package com.tirmizee.backend.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.MemberImage;
import com.tirmizee.core.repository.MemberImageRepositoryImpl;
import com.tirmizee.core.repository.MemberRepository;

@Repository("MemberImageDao")
public class MemberImageDaoImpl extends MemberImageRepositoryImpl implements MemberImageDao {

	@Override
	public MemberImage findByUsername(String username) {
		try {
			StringBuilder select = new StringBuilder()
				.append(" SELECT ").append(TABLE_MEMBERIMAGE).append(".*")
				.append(" FROM ").append(TABLE_MEMBERIMAGE)
				.append(" INNER JOIN ").append(MemberRepository.TABLE_MEMBER)
				.append(" ON ").append(ID).append(" = ").append(MemberRepository.FKIMGID)
				.append(" WHERE ").append(MemberRepository.USERNAME).append(" = ? ");
			return getJdbcOps().queryForObject(select.toString(), params(username), ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
