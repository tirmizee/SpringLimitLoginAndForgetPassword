package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class SubDistricts implements Persistable<Long>{
	
	private static final long serialVersionUID = 1L;

	private Long subDistrictId;
	private Integer fk_DistrictId;
	private String subDistrictCode;
	private String subDistrictName;

	@Override
	public Long getId() {
		return subDistrictId;
	}

	@Override
	public boolean isNew() {
		return subDistrictId == null;
	}

	public Long getSubDistrictId() {
		return subDistrictId;
	}

	public void setSubDistrictId(Long subDistrictId) {
		this.subDistrictId = subDistrictId;
	}

	public Integer getFk_DistrictId() {
		return fk_DistrictId;
	}

	public void setFk_DistrictId(Integer fk_DistrictId) {
		this.fk_DistrictId = fk_DistrictId;
	}

	public String getSubDistrictCode() {
		return subDistrictCode;
	}

	public void setSubDistrictCode(String subDistrictCode) {
		this.subDistrictCode = subDistrictCode;
	}

	public String getSubDistrictName() {
		return subDistrictName;
	}

	public void setSubDistrictName(String subDistrictName) {
		this.subDistrictName = subDistrictName;
	}
	
}
