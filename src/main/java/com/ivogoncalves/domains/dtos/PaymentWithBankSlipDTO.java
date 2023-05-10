package com.ivogoncalves.domains.dtos;

import java.util.Date;
import java.util.Objects;

import com.ivogoncalves.domains.enums.PaymentStatus;

public class PaymentWithBankSlipDTO extends PaymentDTO {

	private static final long serialVersionUID = 1L;

	private Date dueDate;
	private Date payday;
	
	public PaymentWithBankSlipDTO() {
		super();
	}

	public PaymentWithBankSlipDTO(Long id, PaymentStatus paymentStatus, OrderDTO order, Date dueDate, Date payday) {
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
		PaymentWithBankSlipDTO other = (PaymentWithBankSlipDTO) obj;
		return Objects.equals(dueDate, other.dueDate) && Objects.equals(payday, other.payday);
	}
}
