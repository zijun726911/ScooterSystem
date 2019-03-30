package com.db.test;

import com.db.Db;
import com.db.Session;

public class DbTest {
	public static void main(String[] args) {
		
		Db.readFromFile();
		
		System.out.println(Session.stations.size());
		System.out.println(Session.users.size());
//		for(Slot s:a.getSlots()) {
//			System.out.println(s.getSlotState());
//			
//		}
	}
}
