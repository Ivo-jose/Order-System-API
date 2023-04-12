package com.ivogoncalves.domains.enums;

public enum CustomerType {

	NATURAL_PERSON(0, "ROLE_NATURAL_PERSON"), LEGAL_PERSON(1, "ROLE_LEGAL_PERSON");
	
	private Integer code;
	private String description;
	
	private CustomerType(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	
	public String getDescription() {
		return description;
	}
	
	public static CustomerType toEnum(Integer code) {
		if(code == null) {
			return null;
		}
		for(CustomerType x :  CustomerType.values()) {
			if(code.equals(x.getCode())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid customer type!");
	}
}
