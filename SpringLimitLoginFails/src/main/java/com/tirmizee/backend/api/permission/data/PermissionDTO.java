package com.tirmizee.backend.api.permission.data;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tirmizee.core.annotaion.SortColumn;
import com.tirmizee.core.repository.PermissionRepository;

public class PermissionDTO implements Serializable{

	private static final long serialVersionUID = 3605349811438873514L;
	
	private Long perId;
	
	@SortColumn(value = PermissionRepository.COL_PERCODE)
	private String perCode;
	
	@SortColumn(value = PermissionRepository.COL_PERNAME)
	private String perName;
	
	@SortColumn(value = PermissionRepository.COL_PERDESC)
	private String perDesc;
	
	@SortColumn("Status")
	private String status;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	@SortColumn(value = PermissionRepository.COL_CREATEDATE)
	private Timestamp createDate;
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
