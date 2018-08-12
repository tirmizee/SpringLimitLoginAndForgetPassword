package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Skin;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("SkinRepository")
public class SkinRepositoryImpl extends AbstractMssqlRepository<Skin, Integer> implements SkinRepository {

	public static final RowMapper<Skin> ROW_MAPPER = new RowMapper<Skin>() {
		@Override
		public Skin mapRow(ResultSet rs, int arg1) throws SQLException {
			Skin skin = new Skin();
			skin.setSkinId(rs.getInt(COL_SKINID));
			skin.setSkinClass(rs.getString(COL_SKINCLASS));
			skin.setSkinImage(rs.getString(COL_SKINIMAGE));
			return skin;
		}
	};
	public static final RowUnmapper<Skin> ROW_UNMAPPER = new RowUnmapper<Skin>() {
		@Override
		public Map<String, Object> mapColumns(Skin param) {
			Map<String, Object> map = new LinkedHashMap<>(); 
			map.put(COL_SKINID , param.getSkinId());
			map.put(COL_SKINCLASS , param.getSkinClass());
			map.put(COL_SKINIMAGE , param.getSkinImage());
			return map;
		}
	};
	
	public SkinRepositoryImpl() {
		this(TABLE_SKIN);
	}

	public SkinRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_SKINID);
	}

}
