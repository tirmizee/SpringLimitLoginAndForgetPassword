package com.tirmizee.backend.api.member.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class MemberEnabledDTO implements Serializable {

	private static final long serialVersionUID = 276025765558503776L;
	
	@NotNull
	private String username;
	
	@NotNull
	private Boolean enabled;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
}
