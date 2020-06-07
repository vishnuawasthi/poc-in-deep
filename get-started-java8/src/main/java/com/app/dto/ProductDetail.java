package com.app.dto;

public class ProductDetail {

	private Long id;

	private String description;

	private Float price;

	private String type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public ProductDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ProductDetail(Long id, String description, Float price, String type) {
		super();
		this.id = id;
		this.description = description;
		this.price = price;
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", description=" + description + ", price=" + price + ", type=" + type + "]";
	}

	
}
