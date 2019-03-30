package com.service.test;

import java.awt.EventQueue;

import com.db.Db;
import com.entity.Station;
import com.entity.User;
import com.gui.StationGUI;

class ScooterServoveTest {
	
	
	
	public static void main(String[] args) {
		Db.readFromFile();
		
		EventQueue.invokeLater(()->{
				try {
					StationGUI frame =new StationGUI("A");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
		});
	
	}

	

}
