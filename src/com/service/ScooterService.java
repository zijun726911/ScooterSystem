package com.service;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.db.Session;
import com.entity.Slot;
import com.entity.SlotState;
import com.entity.Station;
import com.entity.StationState;
import com.gui.StationGUI;
import com.gui.utils.GUIUtil;

public class ScooterService {
	public void rentOrReturn(String userId,Station station,StationGUI stationGUI) {
		
		
		
		Session.currentUser=Session.getUserById(userId);
		if(Session.currentUser==null) {
			//未注册
		}
		else if(Session.currentUser.isUsingScooter()){
			//该用户要还车
			Session.chosenSlot=findEmptySlot(station);
			Session.chosenSlot.setSlotState(SlotState.RELEASED_EMPTY);
			stationGUI.switchTo(StationState.RETURN);
			
			JLabel timer=stationGUI.pReturn.labeltimer;
			stationGUI.pReturn.labelSlotNumber.setText(Session.chosenSlot.getId());

			 new Thread(()->{//backEndTimer
				int backEndTimer=60;
				while(true){
					try {
						timer.setText(""+backEndTimer);
						
						backEndTimer--;
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(Session.chosenSlot.getSlotState()==SlotState.LOCK_HAS_SCOOTER) {
						Session.currentUser.setUsingScooter(false);
						stationGUI.switchTo(StationState.BLANK);						
						JOptionPane.showMessageDialog(null,"Return successful!", 
								"Return successful",JOptionPane.PLAIN_MESSAGE);
						
						break;
					}
					if(backEndTimer<=0) {
						JOptionPane.showMessageDialog(null,"Fail to return the scooter!", 
								"Fail to return the scooter",JOptionPane.WARNING_MESSAGE);
						stationGUI.switchTo(StationState.BLANK);
						break;
					}
				}	
			}).start();
			
		}
		else {
			//该用户要借车
			 Session.chosenSlot=findNonEmptySlot(station);
			 System.out.println(Session.chosenSlot);
			 Session.chosenSlot.setSlotState(SlotState.RELEASED_NOT_PICKUP);
			 stationGUI.switchTo(StationState.RENT);
			 JLabel timer=stationGUI.pRent.labeltimer;
			 stationGUI.pRent.labelSlotNumber.setText(Session.chosenSlot.getId());

			 new Thread(()->{//backEndTimer
				int backEndTimer=60;
				while(true){
					try {
						timer.setText(""+backEndTimer);
						
						backEndTimer--;
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if(Session.chosenSlot.getSlotState()==SlotState.LOCK_EMPTY) {
						Session.currentUser.setUsingScooter(true);
						stationGUI.switchTo(StationState.BLANK);						
						JOptionPane.showMessageDialog(null,"Pick up successful!", 
								"Pick up successful",JOptionPane.PLAIN_MESSAGE);
						
						break;
					}
					if(backEndTimer<=0) {
						JOptionPane.showMessageDialog(null,"Fail to pick up the scooter!", 
								"Fail to pick up the scooter",JOptionPane.WARNING_MESSAGE);
						stationGUI.switchTo(StationState.BLANK);
						break;
					}
				}	
			}).start();
		}
	}
			
	
	
	public  Slot findNonEmptySlot(Station station) {
		ArrayList<Slot> slots=station.getSlots();
		for(Slot slot:slots) {//借车时，释放一个slot
			if(slot.getSlotState()==SlotState.LOCK_HAS_SCOOTER) {
				return slot;
			}
		}
		
		return null;	
	}
	
	
	public  Slot findEmptySlot(Station station) {
		ArrayList<Slot> slots=station.getSlots();
		for(Slot slot:slots) {//借车时，释放一个slot
			if(slot.getSlotState()==SlotState.LOCK_EMPTY) {
				return slot;
			}
		}
		
		return null;	
	}
	
	
	
	
	

	
	
}
