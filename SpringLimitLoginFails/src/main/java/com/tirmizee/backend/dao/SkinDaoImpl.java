package com.tirmizee.backend.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.api.skin.data.SearchSkinDTO;
import com.tirmizee.core.domain.Skin;
import com.tirmizee.core.repository.SkinRepositoryImpl;

@Repository
public class SkinDaoImpl extends SkinRepositoryImpl implements SkinDao {

	@Override
	public Page<Skin> findByTerm(SearchSkinDTO search) {
		
		List<Object> params = new LinkedList<>();
		
		Integer page =  ObjectUtils.defaultIfNull(search.getPage(), 0),
				size =  ObjectUtils.defaultIfNull(search.getSize(), 20);
		Pageable pageable = new PageRequest(page, size);
		
		StringBuilder statement = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_SKIN)
			.append(" WHERE ").append(COL_SKINID).append(" IS NOT NULL ");
		
		if (search.getTerm() != null) {
			statement.append(" AND ").append(COL_SKINCLASS).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getTerm()) + "%");
		}
		
		String pageStatement = getSqlGenerator().selectAll(getTable(), statement, pageable);
		List<Skin> content = getJdbcOps().query(pageStatement, params.toArray(),ROW_MAPPER);
		Long total = count(statement.toString(), params.toArray());
		
		return new PageImpl<>(content, pageable, total);
	}

}
