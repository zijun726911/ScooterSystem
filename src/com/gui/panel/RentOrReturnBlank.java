package com.gui.panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.db.Db;
import com.db.Session;
import com.entity.Station;
import com.model.SlotState;


public class RentOrReturnBlank extends JPanel{
	
	public JLabel labeltimer;
	public JButton btnTakeOut ;
	
	
	public RentOrReturnBlank() {
		// TODO Auto-generated constructor stub
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 979, 17);
		this.add(separator_1);
		
		
	}
}
