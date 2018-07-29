package com.tirmizee.core.repository;

import com.tirmizee.core.domain.Districts;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface DistrictsRepository extends JdbcRepository<Districts, Integer> {
	
	public static final String TABLE_DISTRICTS = "Districts";
	public static final String COL_DISTRICTID = "DistrictId";
	public static final String COL_FK_PROVINCEID = "Fk_ProvinceId";
	public static final String COL_DISTRICTCODE = "DistrictCode";
	public static final String COL_DISTRICTNAMETH = "DistrictNameTH";
	public static final String COL_DISTRICTNAMEEN = "DistrictNameEN";

	public static final String DISTRICTID = "Districts.DistrictId";
	public static final String FK_PROVINCEID = "Districts.Fk_ProvinceId";
	public static final String DISTRICTCODE = "Districts.DistrictCode";
	public static final String DISTRICTNAMETH = "Districts.DistrictNameTH";
	public static final String DISTRICTNAMEEN = "Districts.DistrictNameEN";

}
