package com.psl.bean;

import java.sql.Date;

public class Contact {
	
	private int contactId ;
	private String firstname,lastName ;
	private String email ;
	private Date dob ;
	private Address address ;
	public int getContactId() {
		return contactId;
	}
	
	
	public Contact(String firstname, String lastName, String email, Date dob) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}


	public void setContactId(int contactId) {
		this.contactId = contactId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	public Contact(String firstname, String lastName, String email, Date dob,
			Address address) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.address = address;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Contact() {
		super();
	}
	
	
	
	

}
