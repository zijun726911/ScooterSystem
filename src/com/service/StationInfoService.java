package com.service;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Iterator;

import com.db.Session;
import com.entity.Record;
import com.entity.Slot;
import com.entity.Station;
import com.entity.User;
import com.gui.StationQueryGUI;
import com.model.OneStationInfo;
import com.model.SlotState;
import com.model.StationInfoModel;

public class StationInfoService {
	
	
	
/**
 *  calculate station information, include total empty slots, the number of scooter in use.
 * 
 * */
	public StationQueryGUI calcuStationInfo(Rectangle bounds) {
		
		StationInfoModel stationInfoModel=new StationInfoModel();
		
		
		for(Station station:Session.stations) {
			String name=station.getName();
			OneStationInfo oneStationInfo=new OneStationInfo();
			for(Slot slot:station.getSlots()) {
				if(slot.getSlotState()==SlotState.LOCK_HAS_SCOOTER) {
					oneStationInfo.avaScooter++;
				}
				else if(slot.getSlotState()==SlotState.LOCK_EMPTY) {
					oneStationInfo.empScooter++;
				}
			}
			oneStationInfo.totSlot=station.getSlots().size();
			stationInfoModel.oneStationInfos.put(name, oneStationInfo);
		}
		Iterator keyIt=stationInfoModel.oneStationInfos.keySet().iterator();

		int scooterAvail=0;
		int totSlot=0;
		int scooterUsing=0;
		while(keyIt.hasNext()) {
			String key=(String)keyIt.next();
			scooterAvail+=stationInfoModel.oneStationInfos.get(key).avaScooter;
			totSlot+=stationInfoModel.oneStationInfos.get(key).totSlot;
		}
		
		for(User user: Session.users) {
			for (Record record:user.getRecords()) {
				if(record.endStation==null) {
					scooterUsing++;
				}
			}
		}
		
		stationInfoModel.scooterAvail=scooterAvail;
		stationInfoModel.scooterUsing=scooterUsing;
		stationInfoModel.totSlot=totSlot;
		
		Rectangle fistBounds=new Rectangle(100, 100, 786, 650);
		StationQueryGUI gui=null;
		if(bounds==null) {
			 gui=new StationQueryGUI(stationInfoModel,fistBounds);
			 
		}else{
			gui=new StationQueryGUI(stationInfoModel,bounds);
		}
		
		
		gui.setVisible(true);
		return gui;
	}
}


