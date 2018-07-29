package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.PostCode;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;

@Repository("PostCodeRepository")
public class PostCodeRepositoryImpl extends AbstractMssqlRepository<PostCode, Long> implements PostCodeRepository {

	public static final RowMapper<PostCode> ROW_MAPPER = new RowMapper<PostCode>() {
		@Override
		public PostCode mapRow(ResultSet rs, int arg1) throws SQLException {
			PostCode postCode = new PostCode();
			postCode.setPostCodeId(rs.getLong(COL_POSTCODEID));
			postCode.setSubDistrictCode(rs.getString(COL_SUBDISTRICTCODE));
			postCode.setZipCode(rs.getString(COL_ZIPCODE));
			return postCode;
		}
	};

	public PostCodeRepositoryImpl() {
		this(TABLE_POSTCODES);
	}
	
	public PostCodeRepositoryImpl(String tableName) {
		super(ROW_MAPPER, tableName, COL_POSTCODEID);
	}

}
