package com.tirmizee.backend.dao;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.api.role.data.SearchRoleDTO;
import com.tirmizee.core.domain.Role;
import com.tirmizee.core.repository.RoleRepositoryImpl;

@Repository("RoleDao")
public class RoleDaoImpl extends RoleRepositoryImpl implements RoleDao {

	@Override
	public Page<Role> findByCriteria(SearchRoleDTO searchCriteria, Pageable pageable) {
		List<Object> params = new LinkedList<>();
		List<Role> content = null;
		String selectPage = null;
		long total = 0;
		StringBuilder select = new StringBuilder()
			.append("SELECT * FROM ").append(TABLE_ROLE)
			.append(" WHERE ").append(COL_ROLEID).append(" IS NOT NULL ");
		if (searchCriteria.getRoleName() != null) {
			select.append(" AND ").append(COL_ROLENAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(searchCriteria.getRoleName()) + "%");
		}
		if (searchCriteria.getRoleDesc() != null) {
			select.append(" AND ").append(COL_ROLEDESC).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(searchCriteria.getRoleDesc()) + "%");
		}
		selectPage = getSqlGenerator().selectAll(getTable(), select, pageable);
		content = getJdbcOps().query(selectPage, params.toArray(), ROW_MAPPER);
		total = count(select.toString(),params.toArray());
		return new PageImpl<>(content, pageable, total);
	}

	@Override
	public Role findByRoleName(String roleName) {
		try {
			StringBuilder select = new StringBuilder()
				.append(" select * from ").append(TABLE_ROLE)
				.append(" where ").append(COL_ROLENAME).append(" = ? ");
				return getJdbcOps().queryForObject(select.toString(), new Object[]{roleName}, ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Role findByRoleNameAndNotExistsRoleId(String roleName, Integer roleId) {
		try {
			StringBuilder select = new StringBuilder()
				.append(" select * from ").append(TABLE_ROLE)
				.append(" where ").append(COL_ROLENAME).append(" = ? And ")
				.append(COL_ROLEID).append(" != ?");
				return getJdbcOps().queryForObject(select.toString(),params(roleName,roleId), ROW_MAPPER);
		} catch (EmptyResultDataAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
