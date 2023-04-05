package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.ivogoncalves.domains.Category;


public class CategoryDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	@JsonManagedReference
	private List<ProductDTO> products = new ArrayList<>();
	
	public CategoryDTO() {
	}

	public CategoryDTO(Category obj) {
		this.id = obj.getId();
		this.name = obj.getName();
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

	
	public List<ProductDTO> getProducts() {
		return products;
	}
	
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CategoryDTO other = (CategoryDTO) obj;
		return Objects.equals(id, other.id);
	}
}
