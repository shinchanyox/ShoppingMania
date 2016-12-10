package com.psl.bean;

public class Employee {
	
	int empID ;
	String name ;
	String designation ;
	String password ;
	public Employee(int empID, String name, String designation, String password) {
		super();
		this.empID = empID;
		this.name = name;
		this.designation = designation;
		this.password = password;
	}
	public Employee() {
		super();
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", name=" + name + ", designation="
				+ designation + ", password=" + password + "]";
	}
	
	
	
	

}
