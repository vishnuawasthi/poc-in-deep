package com.app.datatypes;

public class OrderContainer {

	private Long id;

	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "OrderContainer [id=" + id + ", order=" + order + "]";
	}

	
}
