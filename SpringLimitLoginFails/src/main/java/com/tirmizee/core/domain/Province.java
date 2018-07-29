package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class Province implements Persistable<Integer>{

	private static final long serialVersionUID = -2293713217229626832L;
	
	private Integer provinceId;
	private String provinceCode;
	private String provinceNameTH;
	private String provinceNameEN;

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getProvinceNameTH() {
		return provinceNameTH;
	}

	public void setProvinceNameTH(String provinceNameTH) {
		this.provinceNameTH = provinceNameTH;
	}

	public String getProvinceNameEN() {
		return provinceNameEN;
	}

	public void setProvinceNameEN(String provinceNameEN) {
		this.provinceNameEN = provinceNameEN;
	}

	@Override
	public Integer getId() {
		return provinceId;
	}

	@Override
	public boolean isNew() {
		return provinceId == null;
	}

}
