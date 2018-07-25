package com.tirmizee.core.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.MemberImage;
import com.tirmizee.core.jdbcrepository.AbstractMssqlRepository;
import com.tirmizee.core.jdbcrepository.RowUnmapper;

@Repository("MemberImageRepository")
public class MemberImageRepositoryImpl extends AbstractMssqlRepository<MemberImage, Long> implements MemberImageRepository {
	
	protected static final RowMapper<MemberImage> ROW_MAPPER = new RowMapper<MemberImage>() {
		@Override
		public MemberImage mapRow(ResultSet rs, int arg1) throws SQLException {
			MemberImage image = new MemberImage();
			image.setId(rs.getLong(COL_ID));
			image.setImgName(rs.getString(COL_IMG_NAME));
			image.setImgOriginalName(rs.getString(COL_IMG_ORIGINAL_NAME));
			image.setImgType(rs.getString(COL_IMG_TYPE));
			image.setCreateDate(rs.getTimestamp(COL_CREATE_DATE));
			image.setUpdateDate(rs.getTimestamp(COL_UPDATE_DATE));
			return image;
		}
	};
	
	protected static final RowUnmapper<MemberImage> ROW_UNMAPPER = new RowUnmapper<MemberImage>() {
		@Override
		public Map<String, Object> mapColumns(MemberImage param) {
			Map<String , Object> map = new LinkedHashMap<>();
			map.put(COL_ID , param.getId());
			map.put(COL_IMG_NAME , param.getImgName());
			map.put(COL_IMG_ORIGINAL_NAME, param.getImgOriginalName());
			map.put(COL_IMG_TYPE , param.getImgType());
			map.put(COL_CREATE_DATE , param.getCreateDate());
			map.put(COL_UPDATE_DATE , param.getUpdateDate());
			return map;
		}
	};

	public MemberImageRepositoryImpl() {
		this(TABLE_MEMBERIMAGE);
	}
	
	public MemberImageRepositoryImpl(String tableName) {
		super(ROW_MAPPER, ROW_UNMAPPER, tableName, COL_ID);
	}

}
