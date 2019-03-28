package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class alertNinthGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alertNinthGUI frame = new alertNinthGUI();
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
	public alertNinthGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Return the Scooter Successfully ;-)");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 18));
		lblNewLabel.setBounds(53, 51, 315, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Go to next page in");
		lblNewLabel_1.setBounds(72, 147, 162, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("seconds");
		lblNewLabel_2.setBounds(282, 147, 63, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GUIUtil.getInstance().countDown(lblNewLabel_3, 5);
		lblNewLabel_3.setBounds(263, 208, 14, 21);
		lblNewLabel_3.setBounds(249, 147, 24, 21);
		contentPane.add(lblNewLabel_3);
	}
}
