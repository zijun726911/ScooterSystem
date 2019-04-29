package com.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.db.Session;
import com.entity.SlotState;
import com.entity.StationState;
import com.entity.User;
import com.gui.panel.PayFinePanel;
import com.gui.panel.PersonInfoPanel;
import com.gui.panel.ReturnPanel;
import com.gui.panel.StationInfoPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class PayFineGUI extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public PersonInfoPanel pPersonInfo;
	public PayFinePanel pPayFine;
	
	
	public StationInfoPanel pStationInfo ;
	public StationState state;

	
	
	
	
	public PayFineGUI(String stationName) throws IOException {
		
		
		
		
		
		
		
		setTitle("Station Bulletin Board");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 831, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pPayFine = new PayFinePanel();
		pPayFine.setVisible(false);
		pPayFine.setBounds(0, 296, 813, 181);
		contentPane.add(pPayFine);
		pPayFine.setLayout(null);
		
		
		pPersonInfo = new PersonInfoPanel();
		pPersonInfo.setBounds(0, 110, 813, 188);
		contentPane.add(pPersonInfo);
		pPersonInfo.setLayout(null);
		pPersonInfo.simulSwipCard.addActionListener((e)->{
			
			
			
		});
		
		JLabel lblNewLabel = new JLabel("Fine Payment");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 35));
		lblNewLabel.setBounds(283, 15, 249, 50);
		contentPane.add(lblNewLabel);
		
//		
		
		this.switchTo(StationState.BLANK);
		
	}
	
	
	public void switchTo(StationState state) {
		this.state=state;
		this.contentPane.updateUI();
		
		User currentUser=Session.currentUser;
		
		switch (state) {
			case BLANK:
//				pRent.setVisible(false);
//				pReturn.setVisible(false);
//				pblank.setVisible(true);
				pPersonInfo.lbId.setText("");
				pPersonInfo.lbName.setText("");
				pPersonInfo.lbEmail.setText("");
				pPersonInfo.jtfinputId.setText("");
				pPersonInfo.lbFine.setText("");
				pPersonInfo.jtfinputId.setText("");
				break;
				
			case RENT:
//				pRent.setVisible(true);
//				pReturn.setVisible(false);
//				pblank.setVisible(false);
				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
				
			case RETURN:
//				pRent.setVisible(false);
//				pReturn.setVisible(true);
//				pblank.setVisible(false);
//				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
				
			case UNPAID:
//				pRent.setVisible(false);
//				pReturn.setVisible(false);
//				pblank.setVisible(true);
				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
		}
			
			
		
		
	}
}
