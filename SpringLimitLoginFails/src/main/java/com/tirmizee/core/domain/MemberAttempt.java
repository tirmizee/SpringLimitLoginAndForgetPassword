package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

import java.lang.Long;
import java.sql.Timestamp;
import java.lang.String;
import java.lang.Integer;

public class MemberAttempt implements Persistable<Long>{

	private static final long serialVersionUID = 1L;
	private transient boolean persisted;
	
	private Long id;
	private String username;
	private Integer attempts;
	private Timestamp lastModified;
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return !persisted;
	}
	
	public boolean isPersisted() {
		return persisted;
	}

	public void setPersisted(boolean persisted) {
		this.persisted = persisted;
	}

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

	public void setId(Long id) {
		this.id = id;
	}

	public MemberAttempt withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}
	
}
