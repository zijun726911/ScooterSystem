package com.entity;

import java.io.Serializable;

import com.db.Db;
import com.model.SlotState;

public class Slot implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	



	private SlotState slotState;

	
	public Slot(String id) {
		this.id=id;
		// TODO Auto-generated constructor stub
	}

	
	



	public SlotState getSlotState() {
		return slotState;
	}



	public void setSlotState(SlotState slotState) {
		this.slotState = slotState;
		
	}




	
	public String getId() {
		return id;
	}






	public void setId(String id) {
		this.id = id;
	}
}
