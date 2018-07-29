package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Districts;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;

@Repository("DistrictsRepository")
public class DistrictsRepositoryImpl extends AbstractMssqlRepository<Districts, Integer> implements DistrictsRepository {

	protected static final RowMapper<Districts> ROW_MAPPER = new RowMapper<Districts>() {
		@Override
		public Districts mapRow(ResultSet rs, int arg1) throws SQLException {
			Districts districts = new Districts();
			districts.setDistrictId(rs.getInt(COL_DISTRICTID));
			districts.setFk_ProvinceId(rs.getInt(COL_FK_PROVINCEID));
			districts.setDistrictCode(rs.getString(COL_DISTRICTCODE));
			districts.setDistrictNameTH(rs.getString(COL_DISTRICTNAMETH));
			districts.setDistrictNameEN(rs.getString(COL_DISTRICTNAMEEN));
			return districts;
		}
	};
	
	public DistrictsRepositoryImpl() {
		this(TABLE_DISTRICTS);
	}

	public DistrictsRepositoryImpl(String tableName) {
		super(ROW_MAPPER, tableName, COL_DISTRICTID);
	}

}
