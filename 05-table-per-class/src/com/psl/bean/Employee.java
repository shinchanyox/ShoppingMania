package com.psl.bean;

import java.sql.Date;

public class Employee extends Contact {
	private String employeeCode,designation  ;

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	

	public Employee(String firstname, String lastName, String email, Date dob
			,Address address,String employeeCode, String designation) {
		super(firstname, lastName, email, dob,address);
		this.employeeCode = employeeCode;
		this.designation = designation;
	}

	public Employee(String firstname, String lastName, String email, Date dob) {
		super(firstname, lastName, email, dob);
	}

	
	

}
