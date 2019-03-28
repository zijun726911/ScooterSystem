package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class alertSeventhGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alertSeventhGUI frame = new alertSeventhGUI();
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
	public alertSeventhGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fail to Take Out the Scooter :(");
		lblNewLabel.setBounds(69, 51, 279, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Back to main page in");
		lblNewLabel_1.setBounds(53, 147, 180, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("seconds");
		lblNewLabel_2.setBounds(309, 147, 63, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		GUIUtil.getInstance().countDown(lblNewLabel_3, 5);
		lblNewLabel_3.setBounds(263, 208, 14, 21);
		lblNewLabel_3.setBounds(263, 147, 27, 21);
		contentPane.add(lblNewLabel_3);
	}

}
