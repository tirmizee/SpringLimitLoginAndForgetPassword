package com.tirmizee.backend.api.subdistrict.data;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class SearchSubDistrictDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private Integer districtId;
	private String term;
	private Integer page;
	private Integer size;

	public Integer getDistrictId() {
		return districtId;
	}
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
}
