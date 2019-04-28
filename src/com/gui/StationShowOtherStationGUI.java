package com.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class StationShowOtherStationGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StationShowOtherStationGUI frame = new StationShowOtherStationGUI();
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
	public StationShowOtherStationGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 502);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblUsingCondition = new JLabel("Using Condition");
		lblUsingCondition.setBounds(15, 15, 140, 28);
		contentPane.add(lblUsingCondition);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setBounds(49, 79, 81, 21);
		contentPane.add(lblStation);
		
		JLabel lblA = new JLabel("A");
		lblA.setBounds(277, 79, 81, 21);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setBounds(405, 79, 81, 21);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setBounds(544, 79, 81, 21);
		contentPane.add(lblC);
		
		JLabel lblAvailableScooters = new JLabel("Available Scooters");
		lblAvailableScooters.setBounds(15, 133, 178, 34);
		contentPane.add(lblAvailableScooters);
		
		JLabel lblEmptyScooters = new JLabel("Empty Scooters");
		lblEmptyScooters.setBounds(30, 201, 149, 34);
		contentPane.add(lblEmptyScooters);
		
		JLabel avaA = new JLabel("5");
		avaA.setBounds(277, 140, 81, 21);
		contentPane.add(avaA);
		
		JLabel lblTotalNumber = new JLabel("Total Number");
		lblTotalNumber.setBounds(40, 263, 144, 34);
		contentPane.add(lblTotalNumber);
		
		JLabel empA = new JLabel("3");
		empA.setBounds(277, 208, 81, 21);
		contentPane.add(empA);
		
		JLabel label_2 = new JLabel("8");
		label_2.setBounds(277, 270, 81, 21);
		contentPane.add(label_2);
		
		JLabel avaB = new JLabel("6");
		avaB.setBounds(405, 140, 81, 21);
		contentPane.add(avaB);
		
		JLabel empB = new JLabel("2");
		empB.setBounds(405, 208, 81, 21);
		contentPane.add(empB);
		
		JLabel label_5 = new JLabel("8");
		label_5.setBounds(405, 270, 81, 21);
		contentPane.add(label_5);
		
		JLabel avaC = new JLabel("3");
		avaC.setBounds(544, 140, 81, 21);
		contentPane.add(avaC);
		
		JLabel empC = new JLabel("5");
		empC.setBounds(544, 208, 81, 21);
		contentPane.add(empC);
		
		JLabel label_8 = new JLabel("8");
		label_8.setBounds(544, 270, 81, 21);
		contentPane.add(label_8);
		
		JLabel lblPleaseInputYour = new JLabel("Please input your QM number:");
		lblPleaseInputYour.setBounds(187, 327, 285, 21);
		contentPane.add(lblPleaseInputYour);
		
		JTextField inputID = new JTextField();
		inputID.setBounds(223, 375, 178, 28);
		contentPane.add(inputID);
		inputID.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(442, 374, 70, 28);
		contentPane.add(btnOk);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(15, 115, 597, 262);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(15, 191, 597, 44);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(15, 256, 604, 56);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(224, 58, 166, 239);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(346, 58, 166, 239);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(485, 58, 166, 239);
		contentPane.add(separator_5);
		
	}
}
