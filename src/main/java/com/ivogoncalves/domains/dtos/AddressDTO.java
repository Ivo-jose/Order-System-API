package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class AddressDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String street;
	private String number;
	private String complement;
	private String neighborhood;
	private String cep;

	//Association
	@JsonBackReference
	private CustomerDTO customer;
	private CityDTO city;
	
	public AddressDTO() {}

	public AddressDTO(Long id, String street, String number, String complement, String neighborhood, String cep,
			CustomerDTO customer, CityDTO city) {
		this.id = id;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.cep = cep;
		this.customer = customer;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	
	public CityDTO getCity() {
		return city;
	}
	
	public void setCity(CityDTO city) {
		this.city = city;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, city, complement, customer, id, neighborhood, number, street);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(city, other.city)
				&& Objects.equals(complement, other.complement) && Objects.equals(customer, other.customer)
				&& Objects.equals(id, other.id) && Objects.equals(neighborhood, other.neighborhood)
				&& Objects.equals(number, other.number) && Objects.equals(street, other.street);
	}
}
