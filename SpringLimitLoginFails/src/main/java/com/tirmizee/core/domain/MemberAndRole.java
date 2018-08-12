package com.tirmizee.core.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class MemberAndRole extends Member implements Serializable {

	private static final long serialVersionUID = -81449648940214884L;
	
	private Integer roleId;
	private String roleName;
	private String roleDesc;
	private String imgName;
	private String skinClass;
	private String skinImage;
	private Timestamp createDate;
	private Timestamp updateDate;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getSkinClass() {
		return skinClass;
	}
	public void setSkinClass(String skinClass) {
		this.skinClass = skinClass;
	}
	public String getImgName() {
		return imgName;
	}
	public void setImgName(String imgName) {
		this.imgName = imgName;
	}
	public String getSkinImage() {
		return skinImage;
	}
	public void setSkinImage(String skinImage) {
		this.skinImage = skinImage;
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
	
}
