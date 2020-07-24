package com.seniorsteps.app.models.enums;

public enum LookupType {

	GENDER("GENDER"),
	CATEGORY("CATEGORY");
	
	private String type;
	
	private LookupType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
	
	
	
}
