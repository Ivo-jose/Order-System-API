package com.ivogoncalves.domains.dtos;

import java.util.Objects;

import com.ivogoncalves.domains.enums.PaymentStatus;


public class CardPaymentDTO extends PaymentDTO {

	private static final long serialVersionUID = 1L;
	

	private Integer numberInstallments;

	public CardPaymentDTO() {
		
	}

	public CardPaymentDTO(Long id, PaymentStatus paymentStatus, OrderDTO order, Integer numberInstallments) {
		super(id, paymentStatus, order);
		this.numberInstallments = numberInstallments;
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numberInstallments);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardPaymentDTO other = (CardPaymentDTO) obj;
		return Objects.equals(numberInstallments, other.numberInstallments);
	}
}
