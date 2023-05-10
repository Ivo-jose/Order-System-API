package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.DiscriminatorColumn;

@DiscriminatorColumn(name="payment")
public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date instant;
	@JsonManagedReference
	private CustomerDTO customer;
	@JsonManagedReference
	private AddressDTO address;
	@JsonManagedReference
	private ConcretPaymentDTO payment;
	
	
	public OrderDTO() {}


	public OrderDTO(Long id, Date instant, CustomerDTO customer, AddressDTO address, ConcretPaymentDTO payment) {
		this.id = id;
		this.instant = instant;
		this.customer = customer;
		this.address = address;
		this.payment = payment;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getInstant() {
		return instant;
	}


	public void setInstant(Date instant) {
		this.instant = instant;
	}


	public CustomerDTO getCustomer() {
		return customer;
	}


	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

	public AddressDTO getAddress() {
		return address;
	}
	
	public void setAddress(AddressDTO address) {
		this.address = address;
	}

	public ConcretPaymentDTO getPayment() {
		return payment;
	}
	
	public void setPayment(ConcretPaymentDTO payment) {
		this.payment = payment;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, customer, id, instant);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(customer, other.customer)
				&& Objects.equals(id, other.id) && Objects.equals(instant, other.instant);
	}
}
