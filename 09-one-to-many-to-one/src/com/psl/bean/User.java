package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	
	private int userID ;
	private String userName ;
	private Set<Contact> contacts=new HashSet<Contact>()  ;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}
	public User(String userName) {
		super();
		this.userName = userName;
	}
	public User() {
		super();
	}
	
	public void addContact(Contact contact)
	{
		getContacts().add(contact) ;
		contact.setOwner(this) ;
	}
	
	
	
	

}
