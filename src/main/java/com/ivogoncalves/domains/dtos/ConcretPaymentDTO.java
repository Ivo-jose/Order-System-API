package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ivogoncalves.domains.enums.PaymentStatus;


public class ConcretPaymentDTO extends PaymentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	protected Long id;
	protected Integer paymentStatus;
	@JsonBackReference
	protected OrderDTO order;

	public ConcretPaymentDTO() {}

	public ConcretPaymentDTO(Long id, PaymentStatus paymentStatus, OrderDTO order) {
		this.id = id;
		this.paymentStatus = paymentStatus.getCode();
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(id, order, paymentStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConcretPaymentDTO other = (ConcretPaymentDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(order, other.order)
				&& Objects.equals(paymentStatus, other.paymentStatus);
	} 
}
