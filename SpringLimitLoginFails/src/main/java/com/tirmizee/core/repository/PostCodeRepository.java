package com.tirmizee.core.repository;

import com.tirmizee.core.domain.PostCode;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface PostCodeRepository extends JdbcRepository<PostCode, Long> {
	
	public static final String TABLE_POSTCODES = "PostCodes";
	public static final String COL_POSTCODEID = "PostCodeId";
	public static final String COL_SUBDISTRICTCODE = "SubDistrictCode";
	public static final String COL_ZIPCODE = "ZipCode";

	public static final String POSTCODEID = "PostCodes.PostCodeId";
	public static final String SUBDISTRICTCODE = "PostCodes.SubDistrictCode";
	public static final String ZIPCODE = "PostCodes.ZipCode";

}
