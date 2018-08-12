package com.tirmizee.backend.api.skin.data;

import java.io.Serializable;

public class SearchSkinDTO implements Serializable {

	private static final long serialVersionUID = -4260807584088011316L;
	
	private String term;
	private Integer page;
	private Integer size;
	
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
