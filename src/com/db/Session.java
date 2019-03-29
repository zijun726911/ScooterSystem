package com.db;

import com.entity.Slot;
import com.entity.Station;
import com.entity.User;

public class Session {
	public static Station currentStation;
	public static User currentUser;
	public static Slot chosenSlot;
	
	static {
		currentStation=null;
		currentUser=null;
		chosenSlot=null;
	}

}
