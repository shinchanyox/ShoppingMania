package com.psl.bean;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Contact {
	
	private int contactId ;
	private String firstname,lastName ;
	private String email ;
	private Date dob ;
	private List<Address> addresses = new ArrayList<Address>() ;
	private Set<String> mobileNumbers = new HashSet<String>() ;    
	//private Collection<String> mobileNumbers  ; for bag 
	public int getContactId() {
		return contactId;
	}
	
	
	
	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}



	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
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
	
	
	
	
	public Contact(String firstname, String lastName, String email, Date dob) {
		super();
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}



	public Contact(int contactId, String firstname, String lastName,
			String email, Date dob) {
		super();
		this.contactId = contactId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
	}



	public Contact(int contactId, String firstname, String lastName,
			String email, Date dob, List<Address> addresses,
			Set<String> mobileNumbers) {
		super();
		this.contactId = contactId;
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
		this.dob = dob;
		this.addresses = addresses;
		this.mobileNumbers = mobileNumbers;
	}



	public List<Address> getAddresses() {
		return addresses;
	}



	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}



	public Contact() {
		super();
	}
	
	
	
	

}
