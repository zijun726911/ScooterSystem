package com.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.service.UserService;



public class RegisterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername;
	private JTextField tfEmail;
	private JTextField tfId;

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
		setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		setTitle("Enrolment");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		lblNewLabel.setBounds(75, 138, 158, 53);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("E-mail:");
		lblPassword.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		lblPassword.setBounds(75, 189, 146, 53);
		contentPane.add(lblPassword);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 33));
		lblRegister.setBounds(205, 15, 231, 53);
		contentPane.add(lblRegister);
		
		tfUsername = new JTextField();
		tfUsername.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		tfUsername.setBounds(233, 151, 245, 35);
		contentPane.add(tfUsername);
		tfUsername.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		tfEmail.setColumns(10);
		tfEmail.setBounds(233, 202, 245, 35);
		contentPane.add(tfEmail);
		
		JButton btnResister = new JButton("register");
		btnResister.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		btnResister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
	
				
				String id=tfId.getText();
				
				String name=tfUsername.getText();
				String email=tfEmail.getText();
				new UserService().register(id,name,email,RegisterGUI.this) ;
				
			}
		});
		btnResister.setBounds(129, 303, 146, 53);
		contentPane.add(btnResister);
		
		JButton btnCancel = new JButton("cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisterGUI.this.setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		btnCancel.setBounds(334, 303, 132, 53);
		contentPane.add(btnCancel);
		
		JLabel lblAccountId = new JLabel("QM ID:");
		lblAccountId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 28));
		lblAccountId.setBounds(75, 83, 158, 53);
		contentPane.add(lblAccountId);
		
		tfId = new JTextField();
		tfId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		tfId.setColumns(10);
		tfId.setBounds(233, 96, 245, 35);
		contentPane.add(tfId);
	}
}
