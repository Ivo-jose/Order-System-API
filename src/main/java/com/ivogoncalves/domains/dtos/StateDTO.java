package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;


public class StateDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	//Association
	@JsonBackReference
	private List<CityDTO> cities = new ArrayList<>();
	
	public StateDTO() {}

	public StateDTO(Long id, String name) {
		this.id = id;
		this.name = name;
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
	
	public List<CityDTO> getCities() {
		return cities;
	}
	
	public void setCities(List<CityDTO> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StateDTO other = (StateDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
}
