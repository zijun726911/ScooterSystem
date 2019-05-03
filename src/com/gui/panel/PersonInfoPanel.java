package com.gui.panel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.db.Session;

public class PersonInfoPanel extends JPanel {
	public JButton simulSwipCard;
	public JTextField jtfinputId;
	public JLabel lbId;
	public JLabel lbName;
	public JLabel lbEmail;
	public JLabel lbFine;

	
	


	public PersonInfoPanel() {
		// TODO Auto-generated constructor stub
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		lblPersonalInformation.setBounds(15, 0, 223, 46);
		this.add(lblPersonalInformation);
		
		JLabel lblInputYouId = new JLabel("Input you id:");
		lblInputYouId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblInputYouId.setBounds(15, 44, 140, 46);
		this.add(lblInputYouId);
		
		jtfinputId = new JTextField();
		jtfinputId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		jtfinputId.setBounds(152, 47, 176, 40);
		jtfinputId.setColumns(10);
		this.add(jtfinputId);
		
		simulSwipCard = new JButton("<html>simulate to swipe<br /> your card</html>");
		simulSwipCard.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		simulSwipCard.setBounds(121, 105, 189, 70);
		
		this.add(simulSwipCard);
		
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
		
		lbId = new JLabel();
		lbId.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lbId.setBounds(594, 0, 140, 46);
		this.add(lbId);
		
		lbName = new JLabel();
		lbName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lbName.setBounds(594, 30, 140, 46);
		this.add(lbName);
		
		lbEmail = new JLabel();
		lbEmail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lbEmail.setBounds(594, 69, 207, 46);
		this.add(lbEmail);
		
		JLabel lblUnpaidFine = new JLabel("Unpaid fine:");
		lblUnpaidFine.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblUnpaidFine.setBounds(463, 115, 119, 46);
		this.add(lblUnpaidFine);
		

		
		lbFine = new JLabel();
		lbFine.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lbFine.setBounds(594, 115, 65, 46);
		this.add(lbFine);
	}
}
