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
	public static void rentOrReturn(String userId,Station station,StationGUI from) {
		
		
		
		Session.currentUser=Session.getUserById(userId);
		if(Session.currentUser==null) {
			//未注册
		}
		else if(Session.currentUser.isUsingScooter()){
			//该用户要还车
		}
		else {
			//该用户要借车
			 Session.chosenSlot=findAAvailableSlot(station);
			 Session.chosenSlot.setSlotState(SlotState.RELEASED_NOT_PICKUP);
			 
			

			
			
			 StationGUI stationGUI=GUIUtil.reconstructStation(from);
			 
			 
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
						
						GUIUtil.reconstructStation(from).switchTo(StationState.BLANK);
						
						JOptionPane.showMessageDialog(null,"Pick up successful!", 
								"Pick up successful",JOptionPane.PLAIN_MESSAGE);
						
						
				
						break;
					}
					if(backEndTimer<=0) {
						JOptionPane.showMessageDialog(null,"Fail to pick up the scooter!", 
								"Fail to pick up the scooter",JOptionPane.WARNING_MESSAGE);
						break;
					}
				}	
			}).start();
		}
	}
			
	
	
	public static Slot findAAvailableSlot(Station station) {
		ArrayList<Slot> slots=station.getSlots();
		for(Slot slot:slots) {//借车时，释放一个slot
			if(slot.getSlotState()==SlotState.LOCK_HAS_SCOOTER) {
				return slot;
			}
		}
		
		return null;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
