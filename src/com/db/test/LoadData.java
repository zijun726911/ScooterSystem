package com.db.test;

import com.db.Db;
import com.entity.Slot;
import com.entity.SlotState;
import com.entity.Station;

public class LoadData {
	public static void main(String[] args) {
		Db db=Db.getInstance();
		Slot slot=new Slot();
		slot.setSlotState(SlotState.LOCK_HAS_SCOOTER);
		Station stationA=new Station("A");
		Station stationB=new Station("B");
		Station stationC=new Station("C");
		db.stations.add(stationA);
		db.stations.add(stationB);
		db.stations.add(stationC);
	}
	
	
}
