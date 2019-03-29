package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class FirstpageGUI extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstpageGUI frame = new FirstpageGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstpageGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 470);
		getContentPane().setLayout(null);  
		
		JButton btnStationA = new JButton("Station A");
		btnStationA.setBounds(32, 125, 123, 29);
		getContentPane().add(btnStationA);
		
		JButton btnStationB = new JButton("Station B");
		btnStationB.setBounds(202, 125, 123, 29);
		getContentPane().add(btnStationB);
		
		JButton btnStationC = new JButton("Station C");
		btnStationC.setBounds(372, 125, 123, 29);
		getContentPane().add(btnStationC);
		
		JButton btnManagementSystem = new JButton("Management System");
		btnManagementSystem.setBounds(159, 262, 199, 53);
		getContentPane().add(btnManagementSystem);
	}
}
