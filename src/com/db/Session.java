package com.db;

import java.util.ArrayList;
import java.util.Timer;

import com.entity.Slot;
import com.entity.Station;
import com.entity.User;

public class Session {
	public static Station currentStation;
	public static User currentUser;
	public static Slot chosenSlot;
	public static ArrayList<User> users;
	public static ArrayList<Station> stations;
	public static Timer userTimer;
	
	static {
		currentStation=null;
		currentUser=null;
		chosenSlot=null;
		users=new  ArrayList<User>();
		stations=new  ArrayList<Station>();
		userTimer=new Timer();
		
		
	}
	
	
	
	public static Station getStationByStationName(String name) {
		for(Station station: stations) {
			if(station.getName().equals(name)) {
				return station;
			}
		}
		return null;
	}
	
	
	
	
	public static User getUserById(String id) {
		
		for(User user: users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	



}
