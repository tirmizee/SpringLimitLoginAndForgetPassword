package com.tirmizee.core.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.tirmizee.backend.dao.MemberDao;
import com.tirmizee.backend.dao.PermissionDao;
import com.tirmizee.core.domain.MemberAndRole;
import com.tirmizee.core.domain.Permission;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	private MemberDao memberDao;
	private PermissionDao permissionDao;
	
	public UserDetailsServiceImpl(MemberDao memberDao, PermissionDao permissionDao) {
		this.memberDao = memberDao;
		this.permissionDao = permissionDao;
	}

	@Override
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		
		final MemberAndRole member  = memberDao.findMemberProfileByUsername(username);
		if (member == null ) {
			throw new UsernameNotFoundException(username);
		}

		List<Permission> permissions = permissionDao.findByUsername(username);

		return new UserProfile.Builder()
				.username(username)
				.password(member.getPassword())
				.roleName(member.getRoleName())
				.fkMemberImgId(member.getFkMemberImgId())
				.skinClass(member.getSkinClass())
				.skinImage(member.getSkinImage())
				.authorities(grantAuthorities(permissions))
				.enabled(member.getEnabled())
				.accountNonExpired(member.getAccountNonExpired())
				.accountNonLocked(member.getAccountNonLocked())
				.credentialsNonExpired(member.getCredentialsNonExpired())
				.initialLogin(member.getInitialLogin())
				.credentialsExpiredDate(member.getCredentialsExpiredDate())
				.build();
	}
	
	private Set<GrantedAuthority> grantAuthorities(Collection<? extends Permission> permissions){
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        permissions.forEach(o -> authorities.add(new SimpleGrantedAuthority(o.getPerCode())));
	    return authorities;
	}
	
}
