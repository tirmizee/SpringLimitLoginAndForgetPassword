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

import com.tirmizee.backend.api.district.data.SearchDistrictDTO;
import com.tirmizee.core.domain.Districts;
import com.tirmizee.core.repository.DistrictsRepositoryImpl;

@Repository 
public class DistrictsDaoImpl extends DistrictsRepositoryImpl implements DistrictsDao {

	@Override
	public Page<Districts> findByTerm(SearchDistrictDTO search) {

		List<Object> params = new LinkedList<>();
		Integer page =  ObjectUtils.defaultIfNull(search.getPage(), 0),
				size =  ObjectUtils.defaultIfNull(search.getSize(), 20);
		Pageable pageable = new PageRequest(page, size);
		
		StringBuilder statement = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_DISTRICTS)
			.append(" WHERE ").append(COL_FK_PROVINCEID).append(" = ? ")
			.append(" AND ")
			.append(COL_DISTRICTNAMETH).append(" LIKE ? ");
		
		params.add(search.getProvinceId());
		params.add("%" + StringUtils.trimToEmpty(search.getTerm()) + "%");
		
		String statementPage =  getSqlGenerator().selectAll(getTable(), statement, pageable);
		List<Districts> content = getJdbcOps().query(statementPage, params.toArray(), ROW_MAPPER);
		Long total = count(statement.toString(), params.toArray());
		return new PageImpl<>(content, pageable, total);
	}

}
