package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class Profile {
	
	private int profileID ;
	private String school,college  ;
	private Contact contact  ;
	private Set<Qualification> quali = new HashSet<Qualification>() ;
	public int getProfileID() {
		return profileID;
	}
	public void setProfileID(int profileID) {
		this.profileID = profileID;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public Profile(int profileID, String school, String college, Contact contact) {
		super();
		this.profileID = profileID;
		this.school = school;
		this.college = college;
		this.contact = contact;
	}
	public Profile() {
		super();
	}
	public Profile(String school, String college) {
		super();
		this.school = school;
		this.college = college;
	}
	public Set<Qualification> getQuali() {
		return quali;
	}
	public void setQuali(Set<Qualification> quali) {
		this.quali = quali;
	}
	
	public void addQuali(Qualification quali)
	{
		getQuali().add(quali) ;
		quali.getProfiles().add(this);
	}
	
	

}
