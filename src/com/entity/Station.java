package com.entity;

import java.io.Serializable;
import java.util.ArrayList;

import com.db.Db;

public class Station implements Serializable{
	
	private String name;
	private ArrayList<Slot> slots;
	
	public Station(String name) {
		this.name=name;
		slots=new ArrayList<Slot>();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Slot> getSlots() {
		return slots;
	}
	public void setSlots(ArrayList<Slot> slots) {
		this.slots = slots;
	}

	
}
