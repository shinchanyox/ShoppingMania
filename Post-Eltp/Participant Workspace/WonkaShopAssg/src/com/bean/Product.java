/**
 * 
 */
package com.bean;

/**
 * @author Administrator
 *
 */
public class Product {
	private int itemCode;
	private String name;
	private float price;
	private int  extra ;
	/**
	 * @param name
	 * @param itemCode
	 * @param price
	 */
	
	public Product(int itemCode, String name, float price) {
		super();
		this.name = name;
		this.itemCode = itemCode;
		this.price = price;
	}
	
	
	public Product(int itemCode, String name, float price, int extra) {
		super();
		this.itemCode = itemCode;
		this.name = name;
		this.price = price;
		this.extra = extra;
	}



	
	/**
	 * @return the itemCode
	 */
	public int getItemCode() {
		return itemCode;
	}
	@Override
	public String toString() {
		return "Product [itemCode=" + itemCode + ", name=" + name + ", price="
				+ price + ", extra=" + extra + "]";
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}


	public int getExtra() {
		return extra;
	}


	public void setExtra(int extra) {
		this.extra = extra;
	}


	public void setItemCode(int itemCode) {
		this.itemCode = itemCode;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
