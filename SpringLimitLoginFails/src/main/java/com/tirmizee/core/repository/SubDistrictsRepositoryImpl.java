package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.SubDistricts;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;

@Repository("SubDistrictsRepository")
public class SubDistrictsRepositoryImpl extends AbstractMssqlRepository<SubDistricts, Long> implements SubDistrictsRepository{

	protected static final RowMapper<SubDistricts> ROW_MAPPER = new RowMapper<SubDistricts>() {
		@Override
		public SubDistricts mapRow(ResultSet rs, int arg1) throws SQLException {
			SubDistricts subDistricts = new SubDistricts();
			subDistricts.setSubDistrictId(rs.getLong(COL_SUBDISTRICTID));
			subDistricts.setFk_DistrictId(rs.getInt(COL_FK_DISTRICTID));
			subDistricts.setSubDistrictCode(rs.getString(COL_SUBDISTRICTCODE));
			subDistricts.setSubDistrictName(rs.getString(COL_SUBDISTRICTNAME));
			return subDistricts;
		}
	};
	
	public SubDistrictsRepositoryImpl() {
		this(TABLE_SUBDISTRICTS);
	}

	public SubDistrictsRepositoryImpl(String tableName) {
		super(ROW_MAPPER, tableName, COL_SUBDISTRICTID);
	}

}
