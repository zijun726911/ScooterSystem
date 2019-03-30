package com.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private boolean usingScooter;
	private String id;
	private String name;
	private String email;
	private double unpaidFineFine;
	


	public void setUsingScooter(boolean usingScooter) {
		this.usingScooter = usingScooter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public double getUnpaidFineFine() {
		return unpaidFineFine;
	}

	public void setUnpaidFineFine(double unpaidFineFine) {
		this.unpaidFineFine = unpaidFineFine;
	}

	public boolean isUsingScooter() {
		return usingScooter;
	}
	
	
	
}
