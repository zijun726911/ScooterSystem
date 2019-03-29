package com.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class CheckLoginGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckLoginGUI frame = new CheckLoginGUI();
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
	public CheckLoginGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYouInformationIs = new JLabel("You information is not legal!");
		lblYouInformationIs.setBounds(90, 47, 252, 18);
		contentPane.add(lblYouInformationIs);
		
		JLabel lblPleaseInputThem = new JLabel("Please input them again!");
		lblPleaseInputThem.setBounds(90, 93, 252, 18);
		contentPane.add(lblPleaseInputThem);
		
		JButton btnGoBackTo = new JButton("Go Back to Register");
		btnGoBackTo.setBounds(90, 156, 195, 27);
		contentPane.add(btnGoBackTo);
	}

}
