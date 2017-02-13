package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class Qualification {
	
	private int qualificationID ;
	private String name ;
	private Set<Profile> profiles = new HashSet<Profile>() ;
	public int getQualificationID() {
		return qualificationID;
	}
	public void setQualificationID(int qualificationID) {
		this.qualificationID = qualificationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Profile> getProfiles() {
		return profiles;
	}
	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	public Qualification(int qualificationID, String name, Set<Profile> profiles) {
		super();
		this.qualificationID = qualificationID;
		this.name = name;
		this.profiles = profiles;
	}
	public Qualification() {
		super();
	}
	
	
}
