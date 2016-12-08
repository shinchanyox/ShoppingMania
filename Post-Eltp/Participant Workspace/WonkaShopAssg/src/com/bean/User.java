/**
 * 
 */
package com.bean;

/**
 * @author Administrator
 *
 */
public class User {
	private String name;
	private Long id;
	private Long cardNo ;
	private String password ;
	public void setName(String name) {
		this.name = name;
	}

	
	public User(String name, Long id, Long cardNo, String password) {
		super();
		this.name = name;
		this.id = id;
		this.cardNo = cardNo;
		this.password = password;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @param id
	 * @param name
	 */
	public User(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getCardNo() {
		return cardNo;
	}


	public void setCardNo(Long cardNo) {
		this.cardNo = cardNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User() {
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + "]";
	}
	
	
	
}