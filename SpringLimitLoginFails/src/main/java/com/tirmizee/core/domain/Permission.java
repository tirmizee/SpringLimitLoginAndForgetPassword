package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

import java.lang.Long;
import java.sql.Timestamp;
import java.lang.String;

public class Permission implements Persistable<Long>{

	private static final long serialVersionUID = 1L;
	private transient boolean persisted;
	
	private Long perId;
	private String perCode;
	private String perName;
	private String perDesc;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	@Override
	public Long getId() {
		return perId;
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

	public Long getPerId() {
		return perId;
	}

	public void setPerId(Long perId) {
		this.perId = perId;
	}

	public String getPerCode() {
		return perCode;
	}

	public void setPerCode(String perCode) {
		this.perCode = perCode;
	}

	public String getPerName() {
		return perName;
	}

	public void setPerName(String perName) {
		this.perName = perName;
	}

	public String getPerDesc() {
		return perDesc;
	}

	public void setPerDesc(String perDesc) {
		this.perDesc = perDesc;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Permission withPersisted(boolean persisted) {
		this.persisted = persisted;
		return this;
	}
	
}
