package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class Districts implements Persistable<Integer> {

	private static final long serialVersionUID = -5559893375370195126L;
	
	private Integer districtId;
	private Integer fk_ProvinceId;
	private String districtCode;
	private String districtNameTH;
	private String districtNameEN;
	
	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public Integer getFk_ProvinceId() {
		return fk_ProvinceId;
	}
	public void setFk_ProvinceId(Integer fk_ProvinceId) {
		this.fk_ProvinceId = fk_ProvinceId;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getDistrictNameTH() {
		return districtNameTH;
	}
	public void setDistrictNameTH(String districtNameTH) {
		this.districtNameTH = districtNameTH;
	}
	public String getDistrictNameEN() {
		return districtNameEN;
	}
	public void setDistrictNameEN(String districtNameEN) {
		this.districtNameEN = districtNameEN;
	}
	@Override
	public Integer getId() {
		return districtId;
	}
	@Override
	public boolean isNew() {
		return districtId == null;
	}

}
