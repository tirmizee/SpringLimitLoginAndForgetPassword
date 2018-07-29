package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tirmizee.core.domain.Province;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;

public class ProvinceRepositoryImpl extends AbstractMssqlRepository<Province, Integer> implements ProvinceRepository {

	protected static final RowMapper<Province> ROW_MAPPER = new RowMapper<Province>() {
		@Override
		public Province mapRow(ResultSet rs, int arg1) throws SQLException {
			Province province = new Province();
			province.setProvinceId(rs.getInt(COL_PROVINCEID));
			province.setProvinceCode(rs.getString(COL_PROVINCECODE));
			province.setProvinceNameTH(rs.getString(COL_PROVINCENAMETH));
			province.setProvinceNameEN(rs.getString(COL_PROVINCENAMEEN));
			return province;
		}
	};

	public ProvinceRepositoryImpl() {
		this(TABLE_PROVINCES);
	}
	
	public ProvinceRepositoryImpl(String tableName) {
		super(ROW_MAPPER, tableName, COL_PROVINCEID);
	}

}
