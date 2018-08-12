package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Skin;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface SkinRepository extends JdbcRepository<Skin, Integer> {
	
	public static final String TABLE_SKIN = "Skin";
	public static final String COL_SKINID = "SkinId";
	public static final String COL_SKINCLASS = "SkinClass";
	public static final String COL_SKINIMAGE = "SkinImage";

	public static final String SKINID = "Skin.SkinId";
	public static final String SKINCLASS = "Skin.SkinClass";
	public static final String SKINIMAGE = "Skin.SkinImage";

}
