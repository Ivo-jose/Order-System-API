package com.ivogoncalves.domains.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.ivogoncalves.domains.Product;


public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Double preco;
	
	@JsonBackReference
	List<CategoryDTO> categories = new ArrayList<>();

	public ProductDTO() {}

	public ProductDTO(Long id, String name, Double preco) {
		this.id = id;
		this.name = name;
		this.preco = preco;
	}
	
	public ProductDTO(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.preco = product.getPreco();
		this.categories = product.getCategories().stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
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

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
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
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(id, other.id);
	}
}
