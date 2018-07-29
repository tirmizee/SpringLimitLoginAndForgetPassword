package com.tirmizee.core.repository;

import com.tirmizee.core.domain.SubDistricts;
import com.tirmizee.core.jdbcrepository.JdbcRepository;

public interface SubDistrictsRepository extends JdbcRepository<SubDistricts, Long>{
	
	public static final String TABLE_SUBDISTRICTS = "SubDistricts";
	public static final String COL_SUBDISTRICTID = "SubDistrictId";
	public static final String COL_FK_DISTRICTID = "Fk_DistrictId";
	public static final String COL_SUBDISTRICTCODE = "SubDistrictCode";
	public static final String COL_SUBDISTRICTNAME = "SubDistrictName";

	public static final String SUBDISTRICTID = "SubDistricts.SubDistrictId";
	public static final String FK_DISTRICTID = "SubDistricts.Fk_DistrictId";
	public static final String SUBDISTRICTCODE = "SubDistricts.SubDistrictCode";
	public static final String SUBDISTRICTNAME = "SubDistricts.SubDistrictName";

}
