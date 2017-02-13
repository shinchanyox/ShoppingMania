package com.psl;

import javax.persistence.Entity;

@Entity
public class Test {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
