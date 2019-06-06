package com.model;

import java.util.HashMap;

/**
 * 
 * Data model of user table that is used in "User Information" GUI
 * 
 * 
 */
public class StationInfoModel {
	public HashMap<String,OneStationInfo> oneStationInfos=new HashMap<String,OneStationInfo>();
	public int scooterAvail=0;
	public int totSlot=0;
	public int scooterUsing=0;
}
