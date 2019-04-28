package com.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.entity.User;
import com.gui.panel.RecordTableModel;

public class SingleUserRecordsGUI extends JFrame {

	private JPanel contentPane;


	

	/**
	 * Create the frame.
	 */
	public SingleUserRecordsGUI(User user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		new RecordTableModel(user);
	}

}
