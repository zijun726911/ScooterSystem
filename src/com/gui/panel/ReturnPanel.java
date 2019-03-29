package com.gui.panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import com.db.Db;
import com.db.Session;
import com.entity.SlotState;
import com.entity.Station;
import com.gui.utils.GUIUtil;

public class ReturnPanel extends JPanel{
	
	public JLabel labeltimer;
	public JButton btnTakeOut ;
	
	
	public ReturnPanel() {
		// TODO Auto-generated constructor stub
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 979, 17);
		this.add(separator_1);
		
		JLabel lblTheLockOf = new JLabel("The lock of slot");
		lblTheLockOf.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		lblTheLockOf.setBounds(79, 15, 150, 49);
		this.add(lblTheLockOf);
		
		btnTakeOut = new JButton("TAKE OUT");
		btnTakeOut.setFont(new Font("΢���ź�", Font.PLAIN, 25));
		btnTakeOut.setBounds(355, 79, 190, 43);
		
		this.add(btnTakeOut);
		
		JLabel lblHasBeenReleased = new JLabel("has been released, please take the scooter out within");
		lblHasBeenReleased.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		lblHasBeenReleased.setBounds(255, 15, 513, 49);
		this.add(lblHasBeenReleased);
		
		JLabel lblSeconds = new JLabel("seconds");
		lblSeconds.setFont(new Font("΢���ź�", Font.PLAIN, 20));
		lblSeconds.setBounds(799, 15, 87, 49);
		this.add(lblSeconds);
		
		labeltimer = new JLabel("60");
		
		labeltimer.setFont(new Font("΢���ź�", Font.BOLD, 20));
		labeltimer.setBounds(769, 15, 43, 49);
		this.add(labeltimer);
		
		JLabel labelSlotNumber = new JLabel("4");
		labelSlotNumber.setFont(new Font("΢���ź�", Font.BOLD, 20));
		labelSlotNumber.setBounds(232, 15, 30, 49);
		this.add(labelSlotNumber);
	}
}
