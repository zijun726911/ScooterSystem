package com.service;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.db.Session;
import com.entity.Record;
import com.entity.Slot;
import com.entity.SlotState;
import com.entity.Station;
import com.entity.StationState;
import com.gui.StationGUI;

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
						
						Record record=Session.currentUser.getRecords()
								.get(Session.currentUser.getRecords().size()-1);
						record.setEndStation(station.getName());
						record.setEnd();
//						System.out.println(Session.users
//								.get(0).getRecords().get(0).durSec);
						
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
			if(Session.currentUser.getUnpaidFineFine()>0) {
				//有未缴罚款无法借车
				stationGUI.switchTo(StationState.UNPAID);
				JOptionPane.showMessageDialog(null,"you have unpaid fine, please pay the fine before borrow the scooter!", 
						"Having unpaid fine",JOptionPane.WARNING_MESSAGE);
				new Thread(()->{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					stationGUI.switchTo(StationState.BLANK);
				
				}).start();
				return; 
				
			}
			
			//可以借车
			 Session.chosenSlot=findNonEmptySlot(station);
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
						
						
						Record record=new Record();
						record.setStart();// start rent record
						record.setStartStation(station.getName());
						Session.currentUser.getRecords().add(record);
						
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
