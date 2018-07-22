package com.tirmizee.backend.api.attemp.data;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.core.repository.MemberAttemptRepository;

public class MemberAttemptDTO implements Serializable {

	private static final long serialVersionUID = -6298293929117994008L;
	
	@SortColumn(value = MemberAttemptRepository.COL_USERNAME)
	private String username;
	
	@SortColumn(value = MemberAttemptRepository.COL_ATTEMPTS)
	private Integer attempts;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@SortColumn(value = MemberAttemptRepository.COL_LASTMODIFIED)
	private Timestamp lastModified;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAttempts() {
		return attempts;
	}
	public void setAttempts(Integer attempts) {
		this.attempts = attempts;
	}
	public Timestamp getLastModified() {
		return lastModified;
	}
	public void setLastModified(Timestamp lastModified) {
		this.lastModified = lastModified;
	}
	
}
