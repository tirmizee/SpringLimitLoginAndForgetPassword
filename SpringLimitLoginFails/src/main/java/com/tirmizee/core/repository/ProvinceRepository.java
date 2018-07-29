package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Province;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface ProvinceRepository extends JdbcRepository<Province, Integer> {
	
	public static final String TABLE_PROVINCES = "Provinces";
	public static final String COL_PROVINCEID = "ProvinceId";
	public static final String COL_PROVINCECODE = "ProvinceCode";
	public static final String COL_PROVINCENAMETH = "ProvinceNameTH";
	public static final String COL_PROVINCENAMEEN = "ProvinceNameEN";

	public static final String PROVINCEID = "Provinces.ProvinceId";
	public static final String PROVINCECODE = "Provinces.ProvinceCode";
	public static final String PROVINCENAMETH = "Provinces.ProvinceNameTH";
	public static final String PROVINCENAMEEN = "Provinces.ProvinceNameEN";

}
