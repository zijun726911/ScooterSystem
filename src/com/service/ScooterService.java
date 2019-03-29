package com.service;

import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.db.Db;
import com.db.Session;
import com.entity.Slot;
import com.entity.SlotState;
import com.entity.Station;
import com.gui.utils.GUIUtil;

public class ScooterService {
	public static void rentOrReturn(String userId,Station station,JLabel timer) {
		Session.currentUser=Db.getInstance().getUserBy(userId);
		if(Session.currentUser==null) {
			//未注册
		}
		else if(Session.currentUser.isUsingScooter()){
			//该用户要还车
		}
		else {
			//该用户要借车
			 Session.chosenSlot=releaseASlot(station);
			 SingleSlotJPanel.getInstance(Session.chosenSlot);
			 Session.chosenSlot.release();
		
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
						JOptionPane.showMessageDialog(null,"Pick up successful", 
								"Pick up successful!",JOptionPane.PLAIN_MESSAGE);
				
						break;
					}
					if(backEndTimer<=0) {
						JOptionPane.showMessageDialog(null,"Fail to pick up the scooter", 
								"Fail to pick up the scooter!",JOptionPane.WARNING_MESSAGE);
						break;
					}
				}	
			});
		}
	}
			
	
	
	public static Slot releaseASlot(Station station) {
		ArrayList<Slot> slots=station.getSlots();
		for(Slot slot:slots) {//借车时，释放一个slot
			if(slot.getSlotState()==SlotState.LOCK_HAS_SCOOTER) {
				slot.release();
				return slot;
			}
		}
		
		return null;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
