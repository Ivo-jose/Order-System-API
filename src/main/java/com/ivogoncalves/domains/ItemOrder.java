package com.ivogoncalves.domains;

import java.io.Serializable;
import java.util.Objects;


public class ItemOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private ItemOrderPk id = new ItemOrderPk();
	
	private Double discount;
	private Integer quantity;
	private Double price;
	
	public ItemOrder() {}
	
	public ItemOrder(Double discount, Integer quantity, Double price) {
		this.discount = discount;
		this.quantity = quantity;
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discount, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrder other = (ItemOrder) obj;
		return Objects.equals(discount, other.discount) && Objects.equals(price, other.price)
				&& Objects.equals(quantity, other.quantity);
	}
}
