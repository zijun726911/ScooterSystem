package com.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.entity.Record;
import com.entity.Station;
import com.entity.User;

public class Db implements Serializable {
	public ArrayList<User> users;
	public ArrayList<Station> stations;
	
	
	
	public static void readFromFile() {
		
		File file = new File("dbfile");
		Db dbRead = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

	        dbRead = (Db) ois.readObject();
	 
	        ois.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		Session.stations=dbRead.stations;
		Session.users=dbRead.users;
		 
	}
	
	public  void writeToFile() {
		
		this.stations=Session.stations;
		this.users=Session.users;
		
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


