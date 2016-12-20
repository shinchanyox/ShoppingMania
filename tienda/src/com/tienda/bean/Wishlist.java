package com.tienda.bean;

import java.util.Set;

public class Wishlist {
	
	private int wishlistid ;
	private User wishedBy ;
	private Set<Product> list;
	public int getWishlistid() {
		return wishlistid;
	}
	public void setWishlistid(int wishlistid) {
		this.wishlistid = wishlistid;
	}
	public User getWishedBy() {
		return wishedBy;
	}
	public void setWishedBy(User wishedBy) {
		this.wishedBy = wishedBy;
	}
	public Set<Product> getList() {
		return list;
	}
	public void setList(Set<Product> list) {
		this.list = list;
	}
	public Wishlist(int wishlistid, User wishedBy, Set<Product> list) {
		super();
		this.wishlistid = wishlistid;
		this.wishedBy = wishedBy;
		this.list = list;
	}
	public Wishlist() {
		super();
	}
	
	

}
