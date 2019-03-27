package com.gui;

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.gui.panel.PersonalInformationPanel;
import com.gui.panel.RentPanel;
import com.gui.panel.StationInformationPanel;

public class StationGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StationGUI frame = new StationGUI();
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
	public StationGUI() throws IOException {
		setTitle("Station Bulletin Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel stationInformPanel = new StationInformationPanel();
		stationInformPanel.setBounds(0, 0, 964, 265);
		contentPane.add(stationInformPanel);
		stationInformPanel.setLayout(null);
		

		
		JPanel panelRent = new RentPanel();
		panelRent.setBounds(0, 452, 964, 154);
		contentPane.add(panelRent);
		panelRent.setLayout(null);
		
		
		
		JPanel panelPersonalInformation = new PersonalInformationPanel();
		panelPersonalInformation.setBounds(0, 265, 964, 188);
		contentPane.add(panelPersonalInformation);
		panelPersonalInformation.setLayout(null);
		
		
		
		
	}
}
