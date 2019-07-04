package com.service;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.db.Session;
import com.entity.Record;
import com.entity.Slot;
import com.entity.Station;
import com.gui.StationGUI;
import com.model.SlotState;
import com.model.StationState;

public class ScooterService {
	
	/**
	 * rent and return the  scooter, this process contain the whole process of
	 * @param userId user ID
	 * @param station the station where rent or return behavior happen.
	 * 
	 */
	public void rentOrReturn(String userId,Station station,StationGUI stationGUI) {
			
		if(userId.trim().equals("")) {
			
			return;
		}
		
		
		Session.chosenSlot=findANonEmptySlot(station);
		
		
		
		Session.currentUser=Session.getUserById(userId);
		if(Session.currentUser==null) {//non-register user id
			JOptionPane.showMessageDialog(null,"Please register Scooter system first!", 
					"Not yet register",JOptionPane.WARNING_MESSAGE);
		 
			stationGUI.switchTo(StationState.BLANK);
			return;
		}
		else if(Session.currentUser.isUsingScooter()){//this user is using a scooter currently,
													  //he or she want to return the scooter now.
			
			if(isAllSlotFull(station)) {
				JOptionPane.showMessageDialog(null,"All slots  are full, please return to other station!", 
						"Slots Full",JOptionPane.WARNING_MESSAGE);
				
				stationGUI.switchTo(StationState.BLANK);
				return;
			}
			
			//return the scooter normally
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
						Session.currentUser.stopTimer();
						stationGUI.switchTo(StationState.BLANK);
						
						Record record=Session.currentUser.getRecords()
								.get(Session.currentUser.getRecords().size()-1);
						record.setEndStation(station.getName());
						record.setEnd();
						long onDayAccuSec=UserService.getOneDayAccuTime(Session.currentUser,record.endTime);
						if(onDayAccuSec>2*60*60) {//判断累计超时
							Session.currentUser.setUnpaidFineFine(100);
							Session.currentUser.dayAvailable.avilable=false;
							Session.currentUser.dayAvailable.date=new Date();
						}
						
						JOptionPane.showMessageDialog(null,"Return successful!", 
								"Return successful",JOptionPane.PLAIN_MESSAGE);
						
						break;
					}
					if(backEndTimer<=0) {
						JOptionPane.showMessageDialog(null,"Fail to return the scooter!", 
								"Fail to return the scooter",JOptionPane.WARNING_MESSAGE);
						Session.chosenSlot.setSlotState(SlotState.LOCK_EMPTY);
						stationGUI.switchTo(StationState.BLANK);
						break;
						
					}
				}	
			}).start();
			
		}
		else {//该用户要借车
			
			if(Session.chosenSlot==null) {//all slot empty,can't rent scooter
				JOptionPane.showMessageDialog(null,"There are no available scooters in this station, please rent from other station!", 
						"No scooters available",JOptionPane.WARNING_MESSAGE);
			 
				stationGUI.switchTo(StationState.BLANK);
				return;
			}
			
			
			if(Session.currentUser.getUnpaidFineFine()>0) {
				//有未缴罚款无法借车
				stationGUI.switchTo(StationState.UNPAID);
				JOptionPane.showMessageDialog(null,"you have unpaid fine, please pay the fine before borrow the scooter!", 
						"Having unpaid fine",JOptionPane.WARNING_MESSAGE);
				stationGUI.switchTo(StationState.BLANK);
				return; 
				
			}
			
			if(!Session.currentUser.dayAvailable.avilable) {
				//有未缴罚款无法借车  你今日的累计用量已经超过限制，请明天再来用车！
				stationGUI.switchTo(StationState.UNPAID);
				JOptionPane.showMessageDialog(null,"Your accumulative usage today has exceeded the limit, please use the scooter tomorrow!", 
						"Having unpaid fine",JOptionPane.WARNING_MESSAGE);
				stationGUI.switchTo(StationState.BLANK);
				return; 
				
			}
			
			//该用户可以借车
			 
				 Session.chosenSlot.setSlotState(SlotState.RELEASED_NOT_PICKUP);
				 stationGUI.switchTo(StationState.RENT);
				 
				 JLabel timer=stationGUI.pRent.labeltimer;
				 stationGUI.pRent.labelSlotNumber.setText(Session.chosenSlot.getId());

				 new Thread(()->{//backEndTimer
					int backEndTimer=5;
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
							record.setStart();// start a rent record
							record.setStartStation(station.getName());
							Session.currentUser.getRecords().add(record);
							Session.currentUser.startTimer();
							
							JOptionPane.showMessageDialog(null,"Pick up successful!", 
									"Pick up successful",JOptionPane.PLAIN_MESSAGE);
							

							
							break;
						}
						if(backEndTimer<=0) {
							
							Session.chosenSlot.setSlotState(SlotState.LOCK_HAS_SCOOTER);
							stationGUI.switchTo(StationState.BLANK);
							JOptionPane.showMessageDialog(null,"Fail to pick up the scooter!", 
									"Fail to pick up the scooter",JOptionPane.WARNING_MESSAGE);
							break;
						}
					}	
				}).start();

			 
			
		}
	
		
	}
	 /**
	  * 
	  * 
	  * @return  return boolean, indicating if the station is full 
	  * 
	  */
	public boolean isAllSlotFull(Station station){
		ArrayList<Slot> slots=station.getSlots();
		for(Slot slot:slots) {
			if(slot.getSlotState()==SlotState.LOCK_EMPTY) {
				return false;
			}
		}
		
		return true;	
		
	}
	
	
	
	public  Slot findANonEmptySlot(Station station) {
		ArrayList<Slot> slots=station.getSlots();
		for(Slot slot:slots) {//借车时，释放一个slot
			if(slot.getSlotState()==SlotState.LOCK_HAS_SCOOTER) {
				return slot;
			}
		}
		
		return null;	
	}
	
	//
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
