package com.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.entity.Slot;
import com.entity.Station;
import com.entity.User;

public class Db implements Serializable {
	public static Db instance;
	public ArrayList<User> users;
	public ArrayList<Station> stations;

	

	public static void setInstance(Db instance) {
		Db.instance = instance;
	}

	private Db() {
		users=new ArrayList<User>();
	}
	
	public static Db getInstance() {
		
		if (null == instance) {
			instance = new Db();
		}
		
		return instance;
	}
	
	public  Station getStationByStationName(String name) {
		for(Station station: stations) {
			if(station.getName().equals(name)) {
				return station;
			}
		}
		return null;
	}
	
	public ArrayList<Slot> loadSlotsByStationName(String name){
		
		
		return null;
	}
	
	
	
	public User getUserBy(String id) {
	
		for(User user: users) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
	
	public ArrayList<User> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	
	
	public  Db readFromFile() {
		File file = new File("dbfile");
		Db dbRead = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

	        dbRead = (Db) ois.readObject();
	 
	        ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return dbRead;
        
	}
	
	
	public void writeToFile() {
		// TODO Auto-generated method stub
		File dbfile = new File("dbfile");
        ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(dbfile));
			oos.writeObject(this);
	        oos.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        
	}
}


