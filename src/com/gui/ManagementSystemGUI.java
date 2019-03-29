package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUserManagemet = new JButton("User Managemet");
		btnUserManagemet.setBounds(129, 77, 157, 27);
		contentPane.add(btnUserManagemet);
		
		JButton btnSystemMonitor = new JButton("System Monitor");
		btnSystemMonitor.setBounds(129, 141, 157, 27);
		contentPane.add(btnSystemMonitor);
		
		JLabel lblManagementSystem = new JLabel("Management System");
		lblManagementSystem.setBounds(139, 37, 147, 18);
		contentPane.add(lblManagementSystem);
	}

}
