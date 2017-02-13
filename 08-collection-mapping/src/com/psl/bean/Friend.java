package com.psl.bean;

import java.sql.Date;

public class Friend extends Contact {
	
	private String petName  ;

	public Friend(String firstname, String lastName, String email, Date dob,
			 String petName) {
		super(firstname, lastName, email, dob);
		this.petName = petName;
	}

	public Friend(String firstname, String lastName, String email, Date dob
			) {
		super(firstname, lastName, email, dob);
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
	
	

}
