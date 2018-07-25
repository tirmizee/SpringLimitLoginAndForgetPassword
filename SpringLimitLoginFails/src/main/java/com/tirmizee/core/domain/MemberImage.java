package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class MemberImage implements Persistable<Long> {

	private static final long serialVersionUID = -6757428423310564240L;
	
	private Long id;
	private String imgName;
	private String imgOriginalName;
	private String imgType;
	private java.sql.Timestamp createDate;
	private java.sql.Timestamp updateDate;
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean isNew() {
		return id == null;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getImgOriginalName() {
		return imgOriginalName;
	}
	public void setImgOriginalName(String imgOriginalName) {
		this.imgOriginalName = imgOriginalName;
	}
	public String getImgType() {
		return imgType;
	}
	public void setImgType(String imgType) {
		this.imgType = imgType;
	}
	public java.sql.Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}
	public java.sql.Timestamp getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(java.sql.Timestamp updateDate) {
		this.updateDate = updateDate;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
