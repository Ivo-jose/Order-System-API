package com.ivogoncalves.domains;

import java.util.Objects;

import com.ivogoncalves.domains.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "CardPayment")
public class CardPayment extends Payment {

	private static final long serialVersionUID = 1L;
	
	@Column
	private Integer numberInstallments;

	public CardPayment() {
		
	}

	public CardPayment(Long id, PaymentStatus paymentStatus, Order order, Integer numberInstallments) {
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
		CardPayment other = (CardPayment) obj;
		return Objects.equals(numberInstallments, other.numberInstallments);
	}
}
