package com.bean;

import java.util.List;

public class Category {

	String fileName;
	String name;
	List<Product> products;
	
	public Category() { /* does nothing */ }
	
	
	
	@Override
	public String toString() {
		return "Category [fileName=" + fileName + ", name=" + name
				+ ", products=" + products + "]";
	}



	public Category(String fileName, String name, List<Product> products) {
		super();
		this.fileName = fileName;
		this.name = name;
		this.products = products;
	}



	public Category(String fileName, String name) {
		super();
		this.fileName = fileName;
		this.name = name;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
