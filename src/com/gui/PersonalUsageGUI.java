package com.gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

public class PersonalUsageGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalUsageGUI frame = new PersonalUsageGUI();
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
	public PersonalUsageGUI() {
		super("Personal Usage");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		String[] columnNames =  
	        { "ID", "name", "this time usage(minutes)", "today usage(minutes)", "this week usage(minutes)", "fine" };  
		Object[][] cells = { { "", "", "", "","",""} };
		panel.setLayout(new BorderLayout(0, 0));
		table = new JTable(cells,columnNames);
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scroll = new JScrollPane(table);  
        scroll.setSize(300, 200);
		panel.add(scroll);
	}

}
