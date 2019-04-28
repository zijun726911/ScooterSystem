package com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainGUI extends JFrame {
	public JButton btnStationA;
	public JButton btnStationB;
	public JButton btnStationC;
	public JButton btnManagementSystem;
	private JPanel contentPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public MainGUI() throws IOException {
		setTitle("Scooter System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 868, 626);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		btnStationA = new JButton("Station A");
		btnStationA.addActionListener((e)->{
			try {
				new StationGUI("A").setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnStationA.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		btnStationA.setBounds(94, 128, 165, 61);
		
		contentPane.add(btnStationA);
		
		btnStationB = new JButton("Station B");
		btnStationB.addActionListener((e)->{
			try {
				new StationGUI("B").setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnStationB.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		btnStationB.setBounds(334, 128, 165, 61);
		contentPane.add(btnStationB);
		
		btnStationC = new JButton("Station C");
		btnStationC.addActionListener((e)->{
			try {
				new StationGUI("C").setVisible(true);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		btnStationC.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		btnStationC.setBounds(590, 128, 165, 61);
		contentPane.add(btnStationC);
		
		btnManagementSystem = new JButton("Management System");
		btnManagementSystem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		btnManagementSystem.setBounds(224, 318, 381, 63);
		btnManagementSystem.addActionListener((e)->{
			new ManagementSystemGUI().setVisible(true);
		});
		contentPane.add(btnManagementSystem);
	}
	
	
	
	
	
	
}
