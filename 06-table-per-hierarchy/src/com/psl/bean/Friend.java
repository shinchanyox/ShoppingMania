package com.psl.bean;

import java.sql.Date;

public class Friend extends Contact {
	
	private String petName  ;

	public Friend(String firstname, String lastName, String email, Date dob,
			Address address, String petName) {
		super(firstname, lastName, email, dob, address);
		this.petName = petName;
	}

	public Friend(String firstname, String lastName, String email, Date dob,
			Address address) {
		super(firstname, lastName, email, dob, address);
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	public Friend(){}
	
	

}
