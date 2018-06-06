package com.tirmizee.backend.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tirmizee.core.domain.Permission;
import com.tirmizee.core.repository.MemberRepository;
import com.tirmizee.core.repository.PermissionRepositoryImpl;
import com.tirmizee.core.repository.RoleMapPermissionRepository;
import com.tirmizee.core.repository.RoleRepository;

@Repository("PermissionDao")
public class PermissionDaoImpl extends PermissionRepositoryImpl implements PermissionDao{

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

}
