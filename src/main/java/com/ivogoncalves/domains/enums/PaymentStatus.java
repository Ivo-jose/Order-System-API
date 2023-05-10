package com.ivogoncalves.domains.enums;

public enum PaymentStatus {

	PENDING(0,"PENDING"),   PAID(1, "PAID"),  CANCELED(2, "CANCELED");
	
	private Integer code;
	private String description;
	
	
	private PaymentStatus(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static PaymentStatus toEnum(Integer code) {
		if(code == null) return null;
		for(PaymentStatus x : PaymentStatus.values()) {
			if(x.getCode().equals(code)) {
				return x;
			}
		}
		throw new IllegalArgumentException("Invalid payment status");
	}
}
