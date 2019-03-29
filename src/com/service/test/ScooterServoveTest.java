package com.service.test;

import java.awt.EventQueue;

import com.db.Db;
import com.entity.Station;
import com.entity.User;
import com.gui.StationGUI;

class ScooterServoveTest {
	
	
	
	public static void main(String[] args) {
		User u=new User();
		u.setId("123");
		u.setName("Bob");
		u.setEmail("bob@gmail.com");
		Db.getInstance().getUsers().add(u);
		EventQueue.invokeLater(()->{
				try {
					StationGUI frame = StationGUI.getInstance("A");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		});
	
	}

	

}
