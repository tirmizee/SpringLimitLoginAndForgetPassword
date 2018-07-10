package com.tirmizee.backend.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tirmizee.backend.api.permission.data.PermissionDTO;
import com.tirmizee.backend.api.permission.data.SearchPermissionDTO;
import com.tirmizee.core.domain.Permission;
import com.tirmizee.core.repository.MemberRepository;
import com.tirmizee.core.repository.PermissionRepositoryImpl;
import com.tirmizee.core.repository.RoleMapPermissionRepository;
import com.tirmizee.core.repository.RoleRepository;

@Repository("PermissionDao")
public class PermissionDaoImpl extends PermissionRepositoryImpl implements PermissionDao{

	public static final RowMapper<PermissionDTO> PERMISSION_OF_ROLE_MAPPER = new RowMapper<PermissionDTO>() {
		@Override
		public PermissionDTO mapRow(ResultSet rs, int arg1) throws SQLException {
			PermissionDTO permissionDTO = new PermissionDTO();
			permissionDTO.setPerId(rs.getLong(COL_PERID));
			permissionDTO.setPerCode(rs.getString(COL_PERCODE));
			permissionDTO.setPerName(rs.getString(COL_PERNAME));
			permissionDTO.setPerDesc(rs.getString(COL_PERDESC));
			permissionDTO.setCreateDate(rs.getTimestamp(COL_CREATEDATE));
			permissionDTO.setStatus(rs.getString("Status"));
			return permissionDTO;
		}
	};

	@Override
	public List<Permission> findByUsername(String username) {
		StringBuilder select = new StringBuilder()
			.append("select ").append(TABLE_PERMISSION).append(".* from ").append(TABLE_PERMISSION)
			.append(" inner join ").append(RoleMapPermissionRepository.TABLE_ROLE_MAP_PERMISSION)
			.append(" on ").append(PERID)
				.append(" = ")
				.append(RoleMapPermissionRepository.FKPERID)
			.append(" inner join ").append(RoleRepository.TABLE_ROLE)
			.append(" on ").append(RoleRepository.ROLEID)
				.append(" = ")
				.append(RoleMapPermissionRepository.FKROLEID)
			.append(" inner join ").append(MemberRepository.TABLE_MEMBER)
			.append(" on ").append(RoleRepository.ROLEID)
				.append(" = ")
				.append(MemberRepository.FKROLEID)
			.append(" where ").append(MemberRepository.USERNAME)
			.append(" = ? ");
		return getJdbcOps().query(select.toString(), new Object[]{username},ROW_MAPPER);
	}

	@Override
	public Page<Permission> findByCriteria(SearchPermissionDTO search, Pageable pageable) {
		List<Object> params = new LinkedList<>();
		List<Permission> content = null;
		String selectPage = null;
		long total = 0;
		StringBuilder select = new StringBuilder()
			.append("SELECT * FROM ").append(TABLE_PERMISSION)
			.append(" WHERE ").append(COL_PERID).append(" IS NOT NULL ");
		if (search.getPerCode() != null) {
			select.append(" AND ").append(COL_PERCODE).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getPerCode()) + "%");
		}
		if (search.getPerName() != null) {
			select.append(" AND ").append(COL_PERNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getPerName()) + "%");
		}
		selectPage = getSqlGenerator().selectAll(getTable(), select, pageable);
		content = getJdbcOps().query(selectPage, params.toArray(), ROW_MAPPER);
		total = count(select.toString(),params.toArray());
		return new PageImpl<>(content, pageable, total);
	}

	@Override
	public Page<PermissionDTO> findPermissionOfRole(SearchPermissionDTO search, Pageable pageable) {
		List<Object> params = new LinkedList<>();
		List<PermissionDTO> content = null;
		String selectPage = null;
		long total = 0;
		StringBuilder select = new StringBuilder()
			.append(" SELECT ").append(ALL).append(",")
			.append(" CASE WHEN t.perId IS NULL THEN 'I' ELSE 'A' END AS Status")
			.append(" FROM ").append(TABLE_PERMISSION)
			.append(" LEFT JOIN ( SELECT ").append(ALL)
			.append(" FROM ").append(TABLE_PERMISSION)
			.append(" JOIN ").append(RoleMapPermissionRepository.TABLE_ROLE_MAP_PERMISSION)
			.append(" ON ").append(PERID).append(" = ").append(RoleMapPermissionRepository.FKPERID)
			.append(" JOIN ").append(RoleRepository.TABLE_ROLE)
			.append(" ON ").append(RoleMapPermissionRepository.COL_FKROLEID).append(" = ").append(RoleRepository.ROLEID)
			.append(" WHERE ").append(RoleRepository.ROLEID).append(" = ? ")
			.append(" ) t ON t.perCode = ").append(PERCODE)
			.append(" WHERE ").append(PERID).append(" IS NOT NULL ");
		params.add(search.getRoleId());
		if (search.getPerCode() != null) {
			select.append(" AND ").append(PERCODE).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getPerCode()) + "%");
		}
		if (search.getPerName() != null) {
			select.append(" AND ").append(PERNAME).append(" LIKE ? ");
			params.add("%" + StringUtils.trimToEmpty(search.getPerName()) + "%");
		}
		selectPage = getSqlGenerator().selectAll(getTable(), select, pageable);
		content = getJdbcOps().query(selectPage, params.toArray(), PERMISSION_OF_ROLE_MAPPER);
		total = count(select.toString(),params.toArray());
		return new PageImpl<>(content, pageable, total);
	}

}
