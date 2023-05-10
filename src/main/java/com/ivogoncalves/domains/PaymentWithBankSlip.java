package com.ivogoncalves.domains;

import java.util.Date;
import java.util.Objects;

import com.ivogoncalves.domains.enums.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "PaymentWithBankSlip")
public class PaymentWithBankSlip extends Payment {

	private static final long serialVersionUID = 1L;

	@Column
	private Date dueDate;
	@Column
	private Date payday;
	
	public PaymentWithBankSlip() {
		super();
	}

	public PaymentWithBankSlip(Long id, PaymentStatus paymentStatus, Order order, Date dueDate, Date payday) {
		super(id, paymentStatus, order);
		this.dueDate = dueDate;
		this.payday = payday;
		
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPayday() {
		return payday;
	}

	public void setPayday(Date payday) {
		this.payday = payday;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dueDate, payday);
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
		PaymentWithBankSlip other = (PaymentWithBankSlip) obj;
		return Objects.equals(dueDate, other.dueDate) && Objects.equals(payday, other.payday);
	}
}
