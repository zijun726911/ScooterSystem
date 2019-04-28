package com.db.test;

import java.awt.EventQueue;
import java.io.IOException;

import com.db.Db;
import com.gui.MainGUI;

class Main {
	
	
	
	public static void main(String[] args) throws IOException {
		Db.readFromFile();
		MainGUI frame =new MainGUI();
		frame.setVisible(true);
		
	
	}

	

}
