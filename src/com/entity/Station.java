package com.entity;

import java.io.Serializable;
import java.util.ArrayList;

import com.db.Db;
/**
 * Station entity, one scooter station contain many scooters 
 *
 * 
 * 
 */
public class Station implements Serializable{
	private static final long serialVersionUID = 1L;
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
