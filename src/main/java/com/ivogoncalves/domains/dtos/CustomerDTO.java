package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.ivogoncalves.domains.enums.CustomerType;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String cpfOrCnpj;
	private Integer customerType;
	
	
	private List<AddressDTO> address = new ArrayList<>();
	
	private Set<String> phones = new HashSet<>();
	
	public CustomerDTO() {}

	public CustomerDTO(Long id, String name, String email, String cpfOrCnpj, CustomerType customerType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.cpfOrCnpj = cpfOrCnpj;
		this.customerType = customerType.getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpfOrCnpj() {
		return cpfOrCnpj;
	}

	public void setCpfOrCnpj(String cpfOrCnpj) {
		this.cpfOrCnpj = cpfOrCnpj;
	}

	public CustomerType getCustomerType() {
		return CustomerType.toEnum(customerType);
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType.getCode();
	}

	public List<AddressDTO> getAddress() {
		return address;
	}

	public void setAddress(List<AddressDTO> address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}
	
	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, cpfOrCnpj, customerType, email, id, name, phones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(cpfOrCnpj, other.cpfOrCnpj)
				&& Objects.equals(customerType, other.customerType) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(phones, other.phones);
	}
}
