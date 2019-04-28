package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagementSystemGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagementSystemGUI frame = new ManagementSystemGUI();
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
	public ManagementSystemGUI() {
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 792, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Management System");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		lblNewLabel.setBounds(213, 15, 277, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnUserUsage = new JButton("User Usage");
		btnUserUsage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UserUsageGUI().setVisible(true);
			}
		});
		btnUserUsage.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnUserUsage.setBounds(99, 138, 174, 55);
		contentPane.add(btnUserUsage);
		
		JButton btnStationState = new JButton("Station State");
		btnStationState.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnStationState.setBounds(441, 138, 174, 55);
		btnStationState.addActionListener((e)->{
			
			
		});
		contentPane.add(btnStationState);
	}
}
