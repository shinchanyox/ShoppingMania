package com.psl.bean;

import java.util.Date;

public class LeaveDetails {

	int employeeID ;
	Date startDate ;
	Date endDate ;
	String leaveType ;
	int numberOfDays ;
	public LeaveDetails(int employeeID, Date startDate, Date endDate,
			String leaveType, int numberOfDays) {
		super();
		this.employeeID = employeeID;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveType = leaveType;
		this.numberOfDays = numberOfDays;
	}
	public LeaveDetails() {
		super();
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public int getNumberOfDays() {
		return numberOfDays;
	}
	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}
	@Override
	public String toString() {
		return "LeaveDetails [employeeID=" + employeeID + ", startDate="
				+ startDate + ", endDate=" + endDate + ", leaveType="
				+ leaveType + ", numberOfDays=" + numberOfDays + "]";
	}
	
}
