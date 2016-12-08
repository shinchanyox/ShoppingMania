/**
 * 
 */
package com.bean;

/**
 * @author Administrator
 *
 */
public class Transaction {
	private User member;
	private Product item;
	private int quantity;
	private double total;

	public Transaction() {
	}

	/**
	 * @param item
	 * @param member
	 * @param quantity
	 * @param total
	 */
	
	
	public Transaction(Product item, User member, int quantity, double total) {
		super();
		this.item = item;
		this.member = member;
		this.quantity = quantity;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Transaction [member=" + member + ", item=" + item
				+ ", quantity=" + quantity + ", total=" + total + "]";
	}

	/**
	 * @return the member
	 */
	public User getMember() {
		return member;
	}

	/**
	 * @param member the member to set
	 */
	public void setMember(User member) {
		this.member = member;
	}

	/**
	 * @return the item
	 */
	public Product getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(Product item) {
		this.item = item;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(float total) {
		this.total = total;
	}

}