package com.db;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import com.entity.Station;
import com.entity.User;

public class Db implements Serializable {
	public ArrayList<User> users;
	public ArrayList<Station> stations;
	
	
	
	
	public static void readFromFile() {
		String path=null;
		String pathPrefix=null;
		try {
			path=Class.forName("Main").getResource("Main.class").getPath();
			int nameStratIndex=path.indexOf("Main.class");
			pathPrefix=path.substring(0, nameStratIndex);
			
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} 
		
		File file = new File("dbfile.dat");
//		System.out.println("filePath:"+file.getPath());
//		System.out.println("file exists:"+file.exists());
		Db dbRead = null;
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

	        dbRead = (Db) ois.readObject();
	 
	        ois.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		Session.stations=dbRead.stations;
		Session.users=dbRead.users;
		 
	}
	
	public  void writeToFile() {
		
		this.stations=Session.stations;
		this.users=Session.users;
		
		String path=null;
		try {
			path=Class.forName("Main").getResource("Main.class").getFile();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} 
		File file = new File("dbfile.dat");
        ObjectOutputStream oos;
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(this);
	        oos.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}


