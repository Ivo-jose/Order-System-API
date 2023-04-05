package com.ivogoncalves.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.ivogoncalves.domains.dtos.ProductDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(nullable = false, length = 200)
	private String name;
	@Column(nullable = false)
	private Double preco;
	
	@ManyToMany
	@JoinTable(name = "product_category", joinColumns = {@JoinColumn(name = "product_id")},
				inverseJoinColumns = {@JoinColumn(name = "category_id")}
	)
	List<Category> categories = new ArrayList<>();

	public Product() {}

	public Product(Long id, String name, Double preco) {
		super();
		this.id = id;
		this.name = name;
		this.preco = preco;
	}

	public Product(ProductDTO objDTO) {
		this.id = objDTO.getId();
		this.name = objDTO.getName();
		this.preco = objDTO.getPreco();
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

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
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
		Product other = (Product) obj;
		return Objects.equals(id, other.id);
	}
}	
