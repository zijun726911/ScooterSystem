package com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.service.StationInfoService;

public class ManagementSystemGUI extends JFrame {

	private JPanel contentPane;

	
	

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
		lblNewLabel.setBounds(245, 15, 277, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnUserUsage = new JButton("User Information");
		btnUserUsage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new UserInfoQueryGUI().setVisible(true);
			}
		});
		btnUserUsage.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnUserUsage.setBounds(99, 138, 212, 55);
		contentPane.add(btnUserUsage);
		
		JButton btnStationState = new JButton("Station Information");
		btnStationState.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnStationState.setBounds(441, 138, 245, 55);
		btnStationState.addActionListener((e)->{
			new StationInfoService().calcuStationInfo();;
			
		});
		contentPane.add(btnStationState);
		
		JButton btnPayFine = new JButton("Fine Payment");
		btnPayFine.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnPayFine.setBounds(99, 284, 212, 55);
		btnPayFine.addActionListener((e)->{
			try {
				new PayFineGUI().setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		contentPane.add(btnPayFine);
		
		JButton btnRegister = new JButton("User Register");
		
		btnRegister.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 22));
		btnRegister.setBounds(441, 284, 245, 55);
		btnRegister.addActionListener((e)->{
			new RegisterGUI().setVisible(true);;
		});
		
		contentPane.add(btnRegister);
	}
}
