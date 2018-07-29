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

import com.tirmizee.backend.api.subdistrict.data.SearchSubDistrictDTO;
import com.tirmizee.core.domain.SubDistricts;
import com.tirmizee.core.repository.SubDistrictsRepositoryImpl;

@Repository
public class SubDistrictsDaoImpl extends SubDistrictsRepositoryImpl implements SubDistrictsDao {

	@Override
	public Page<SubDistricts> findByTerm(SearchSubDistrictDTO search) {
		
		List<Object> params = new LinkedList<>();
		Integer page =  ObjectUtils.defaultIfNull(search.getPage(), 0),
				size =  ObjectUtils.defaultIfNull(search.getSize(), 20);
		Pageable pageable = new PageRequest(page, size);
		
		StringBuilder statement = new StringBuilder()
			.append(" SELECT * FROM ").append(TABLE_SUBDISTRICTS)
			.append(" WHERE ").append(COL_FK_DISTRICTID).append(" = ? ")
			.append(" AND ")
			.append(COL_SUBDISTRICTNAME).append(" LIKE ? ");
			
		params.add(search.getDistrictId());
		params.add("%" + StringUtils.trimToEmpty(search.getTerm()) + "%");
		
		String statementPage =  getSqlGenerator().selectAll(getTable(), statement, pageable);
		List<SubDistricts> content = getJdbcOps().query(statementPage, params.toArray(), ROW_MAPPER);
		Long total = count(statement.toString(), params.toArray());
	
		return new PageImpl<>(content, pageable, total);
	}
	
}
