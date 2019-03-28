package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;

import java.util.Timer;
import java.util.TimerTask;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;


public class alertForthGUI extends JFrame {
	private final JLabel lblYourScooterIs = new JLabel("Your Scooter Is Over Time :(");
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alertForthGUI frame = new alertForthGUI();
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
	public alertForthGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		lblYourScooterIs.setBounds(69, 49, 261, 21);
		lblYourScooterIs.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblYourScooterIs);
		
		JLabel lblNewLabel = new JLabel("Please Pay the Fine");
		lblNewLabel.setBounds(114, 85, 171, 21);
		getContentPane().add(lblNewLabel);
		
		//在PAY上添加了一个swing action
		int delay=1000;
		int count=5;
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setBounds(237, 146, 93, 29);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Back to main page in");
		lblNewLabel_1.setBounds(53, 208, 185, 21);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("seconds");
		lblNewLabel_2.setBounds(298, 208, 81, 21);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel();
		GUIUtil.getInstance().countDown(lblNewLabel_3, 5);
		lblNewLabel_3.setBounds(263, 208, 14, 21);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("PAY");
		btnNewButton.setBounds(80, 146, 93, 29);
		getContentPane().add(btnNewButton);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
