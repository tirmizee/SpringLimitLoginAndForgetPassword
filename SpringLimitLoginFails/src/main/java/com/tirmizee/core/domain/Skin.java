package com.tirmizee.core.domain;

import org.springframework.data.domain.Persistable;

public class Skin implements Persistable<Integer>{

	private static final long serialVersionUID = -6636923693290097448L;
	
	private Integer skinId;
	private String skinClass;
	private String skinImage;

	@Override
	public Integer getId() {
		return skinId;
	}

	@Override
	public boolean isNew() {
		return skinId == null;
	}

	public Integer getSkinId() {
		return skinId;
	}

	public void setSkinId(Integer skinId) {
		this.skinId = skinId;
	}

	public String getSkinClass() {
		return skinClass;
	}

	public void setSkinClass(String skinClass) {
		this.skinClass = skinClass;
	}

	public String getSkinImage() {
		return skinImage;
	}

	public void setSkinImage(String skinImage) {
		this.skinImage = skinImage;
	}
	
}
