package com.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



import javax.swing.border.EmptyBorder;

import com.gui.utils.GUIUtil;

public class FailReturnGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FailReturnGUI frame = new FailReturnGUI();
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
	public FailReturnGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFailToReturn = new JLabel("Fail to Return the Scooter! ");
		lblFailToReturn.setBounds(113, 35, 230, 18);
		contentPane.add(lblFailToReturn);
		
		JLabel lblBackToMain = new JLabel("Back to main page in");
		lblBackToMain.setBounds(81, 114, 174, 31);
		contentPane.add(lblBackToMain);
		
		JLabel lblSeconds = new JLabel("seconds! ");
		lblSeconds.setBounds(290, 120, 72, 18);
		contentPane.add(lblSeconds);
		
		JLabel label = new JLabel("5");
		GUIUtil.getInstance().countDown(label, 5);

		label.setBounds(259, 120, 31, 18);
		contentPane.add(label);
	}

}
