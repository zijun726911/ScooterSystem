package com.db.test;

import com.db.Db;
import com.db.Session;
import com.entity.Slot;
import com.entity.SlotState;
import com.entity.Station;
import com.entity.User;

public class LoadData {
	public static void main(String[] args) {
		
		
		User u=new User();
		u.setId("123");
		u.setName("Bob");
		u.setEmail("bob@gmail.com");
		u.setUsingScooter(false);
		u.setUnpaidFineFine(0);
		Session.users.add(u);
		
		User u1=new User();
		u1.setId("456");
		u1.setName("Alice");
		u1.setEmail("alice@gmail.com");
		u1.setUsingScooter(false);
		u1.setUnpaidFineFine(0);
		Session.users.add(u1);
		
		User u2=new User();
		u2.setId("789");
		u2.setName("Tom");
		u2.setEmail("tom@gmail.com");
		u2.setUsingScooter(false);
		u2.setUnpaidFineFine(100);
		Session.users.add(u2);
	
		
		Station stationA=new Station("A");
		Station stationB=new Station("B");
		Station stationC=new Station("C");
		for(int i=0;i<8;i++) {
			Slot slot=new Slot(""+(i+1));
			slot.setSlotState(SlotState.LOCK_HAS_SCOOTER);
			Slot slotEmpy1=new Slot(""+(i+1));
			slotEmpy1.setSlotState(SlotState.LOCK_EMPTY);
			Slot slotEmpy2=new Slot(""+(i+1));
			slotEmpy2.setSlotState(SlotState.LOCK_EMPTY);
			stationA.getSlots().add(slot);
			stationB.getSlots().add(slotEmpy1);
			stationC.getSlots().add(slotEmpy2);
			
		}
		
		stationB.getSlots().get(0).setSlotState(SlotState.LOCK_HAS_SCOOTER);
		stationB.getSlots().get(1).setSlotState(SlotState.LOCK_HAS_SCOOTER);
		stationB.getSlots().get(2).setSlotState(SlotState.LOCK_HAS_SCOOTER);
		
		
		
		Session.stations.add(stationA);
		Session.stations.add(stationB);
		Session.stations.add(stationC);
		
	
		new Db().writeToFile();
		
	}
	
	
}
