package com.entity;

import javax.swing.JLabel;

import com.gui.panel.SingleSlotJPanel;
import com.gui.utils.GUIUtil;

public class Slot {

	private String id;
	



	private SlotState slotState;

	
	public Slot() {
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
