package com.gui.panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PersonalInformationPanel extends JPanel {
	public PersonalInformationPanel() {
		// TODO Auto-generated constructor stub
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		lblPersonalInformation.setBounds(15, 0, 223, 46);
		this.add(lblPersonalInformation);
		
		JLabel lblInputYouId = new JLabel("Input you id:");
		lblInputYouId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblInputYouId.setBounds(15, 44, 140, 46);
		this.add(lblInputYouId);
		
		JTextField jtfinputId = new JTextField();
		jtfinputId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		jtfinputId.setBounds(152, 47, 176, 40);
		jtfinputId.setColumns(10);
		this.add(jtfinputId);
		
		JButton btnNewButton = new JButton("<html>simulate to swipe<br /> your card</html>");
		btnNewButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		btnNewButton.setBounds(121, 105, 189, 70);
		this.add(btnNewButton);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblId.setBounds(544, 0, 38, 46);
		this.add(lblId);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblName.setBounds(508, 30, 74, 46);
		this.add(lblName);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(423, 0, 38, 188);
		this.add(separator);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 0, 964, 10);
		this.add(separator_2);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblEmail.setBounds(508, 69, 74, 46);
		this.add(lblEmail);
		
		JLabel label = new JLabel("2016123456");
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label.setBounds(594, 0, 140, 46);
		this.add(label);
		
		JLabel lblBob = new JLabel("Bob");
		lblBob.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblBob.setBounds(594, 30, 140, 46);
		this.add(lblBob);
		
		JLabel lblBobgmailcom = new JLabel("bob@gmail.com");
		lblBobgmailcom.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblBobgmailcom.setBounds(594, 69, 207, 46);
		this.add(lblBobgmailcom);
		
		JLabel lblUnpaidFine = new JLabel("unpaid fine:");
		lblUnpaidFine.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblUnpaidFine.setBounds(463, 115, 119, 46);
		this.add(lblUnpaidFine);
		
		JLabel jlUnpaidFine = new JLabel("0");
		jlUnpaidFine.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		jlUnpaidFine.setBounds(617, 115, 38, 46);
		this.add(jlUnpaidFine);
		
		JLabel label_2 = new JLabel("\uFFE1");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_2.setBounds(594, 115, 38, 46);
		this.add(label_2);
	}
}
