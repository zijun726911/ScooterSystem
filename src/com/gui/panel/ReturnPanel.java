package com.gui.panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;


public class ReturnPanel extends JPanel{
	
	public JLabel labeltimer;
	public JButton btnTakeOut ;
	public JLabel labelSlotNumber ;
	
	
	public ReturnPanel() {
		// TODO Auto-generated constructor stub
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 979, 17);
		this.add(separator_1);
		
		JLabel lblTheLockOf = new JLabel("The lock of slot");
		lblTheLockOf.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblTheLockOf.setBounds(79, 15, 150, 49);
		this.add(lblTheLockOf);
		
		btnTakeOut = new JButton("RETURN");
		btnTakeOut.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		btnTakeOut.setBounds(355, 79, 190, 43);
		
		this.add(btnTakeOut);
		
		JLabel lblHasBeenReleased = new JLabel("has been released, please return the scooter within");
		lblHasBeenReleased.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblHasBeenReleased.setBounds(255, 15, 513, 49);
		this.add(lblHasBeenReleased);
		
		JLabel lblSeconds = new JLabel("seconds");
		lblSeconds.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblSeconds.setBounds(799, 15, 87, 49);
		this.add(lblSeconds);
		
		labeltimer = new JLabel("60");
		
		labeltimer.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		labeltimer.setBounds(767, 15, 40, 49);
		this.add(labeltimer);
		
		labelSlotNumber = new JLabel();
		labelSlotNumber.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		labelSlotNumber.setBounds(232, 15, 30, 49);
		this.add(labelSlotNumber);
	}
}
