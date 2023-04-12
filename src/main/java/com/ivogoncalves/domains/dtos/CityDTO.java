package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;


public class CityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	
	//Association
	@JsonManagedReference
	private StateDTO state;

	public CityDTO() {}

	public CityDTO(Long id, String name, StateDTO state) {
		this.id = id;
		this.name = name;
		this.state = state;
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

	public StateDTO getState() {
		return state;
	}

	public void setState(StateDTO state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityDTO other = (CityDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(state, other.state);
	}

	
}
