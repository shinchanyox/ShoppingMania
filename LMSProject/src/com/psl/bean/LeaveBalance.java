package com.psl.bean;

public class LeaveBalance {

	int employeeID ;
	int ol ;
	int pl ;
	int lwp  ;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getOl() {
		return ol;
	}
	public void setOl(int ol) {
		this.ol = ol;
	}
	public int getPl() {
		return pl;
	}
	public void setPl(int pl) {
		this.pl = pl;
	}
	public int getLwp() {
		return lwp;
	}
	public void setLwp(int lwp) {
		this.lwp = lwp;
	}
	public LeaveBalance(int employeeID, int ol, int pl, int lwp) {
		super();
		this.employeeID = employeeID;
		this.ol = ol;
		this.pl = pl;
		this.lwp = lwp;
	}
	public LeaveBalance() {
		super();
	}
	@Override
	public String toString() {
		return "LeaveBalance [employeeID=" + employeeID + ", ol=" + ol
				+ ", pl=" + pl + ", lwp=" + lwp + "]";
	}
	
	
	
	
}
