package com.bean;

import java.util.List;

public class Product {

	String title;	
	List<String> brands;
	
	
	
	public Product(String title, List<String> brands) {
		super();
		this.title = title;
		this.brands = brands;
	}
	@Override
	public String toString() {
		return "Product [title=" + title + ", brands=" + brands + "]";
	}
	
	
	public Product(String title) {
		super();
		this.title = title;
	}
	public Product() { /* does nothing */ }
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getBrands() {
		return brands;
	}
	public void setBrands(List<String> brands) {
		this.brands = brands;
	}
	
	
}
