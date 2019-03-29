package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegisterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterGUI frame = new RegisterGUI();
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
	public RegisterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegisterAUser = new JLabel("Register A User");
		lblRegisterAUser.setBounds(14, 13, 195, 24);
		contentPane.add(lblRegisterAUser);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setBounds(24, 62, 86, 18);
		contentPane.add(lblFullName);
		
		textField = new JTextField();
		textField.setBounds(123, 59, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQmNumber = new JLabel("QM Number:");
		lblQmNumber.setBounds(24, 103, 86, 18);
		contentPane.add(lblQmNumber);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(24, 144, 86, 18);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(123, 100, 86, 24);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(123, 141, 86, 24);
		contentPane.add(textField_2);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(158, 198, 113, 27);
		contentPane.add(btnConfirm);
	}

}
