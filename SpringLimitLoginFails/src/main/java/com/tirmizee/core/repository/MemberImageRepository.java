package com.tirmizee.core.repository;

import com.tirmizee.core.domain.MemberImage;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface MemberImageRepository extends JdbcRepository<MemberImage, Long> {
	
	public static final String TABLE_MEMBERIMAGE = "MemberImage";
	public static final String COL_ID = "ID";
	public static final String COL_IMG_NAME = "IMG_NAME";
	public static final String COL_IMG_ORIGINAL_NAME = "IMG_ORIGINAL_NAME";
	public static final String COL_IMG_TYPE = "IMG_TYPE";
	public static final String COL_CREATE_DATE = "CREATE_DATE";
	public static final String COL_UPDATE_DATE = "UPDATE_DATE";

	public static final String ID = "MemberImage.ID";
	public static final String IMG_NAME = "MemberImage.IMG_NAME";
	public static final String IMG_ORIGINAL_NAME = "MemberImage.IMG_ORIGINAL_NAME";
	public static final String IMG_TYPE = "MemberImage.IMG_TYPE";
	public static final String CREATE_DATE = "MemberImage.CREATE_DATE";
	public static final String UPDATE_DATE = "MemberImage.UPDATE_DATE";

}
