package com.psl.bean;

import java.sql.Date;

public class Relative extends Contact {
	
	private String relation  ;

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Relative(String firstname, String lastName, String email, Date dob,
			 String relation) {
		super(firstname, lastName, email, dob);
		this.relation = relation;
	}

	public Relative(String firstname, String lastName, String email, Date dob) {
		super(firstname, lastName, email, dob);
	}
	

}
