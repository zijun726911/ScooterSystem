package com.gui;

import java.awt.Rectangle;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.db.Session;
import com.entity.SlotState;
import com.entity.Station;
import com.entity.StationState;
import com.entity.User;
import com.gui.panel.PersonInfoPanel;
import com.gui.panel.RentOrReturnBlank;
import com.gui.panel.RentPanel;
import com.gui.panel.ReturnPanel;
import com.gui.panel.StationInfoPanel;
import com.service.ScooterService;

public class StationGUI extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public PersonInfoPanel pPersonInfo;
	public RentPanel pRent;
	public RentOrReturnBlank pblank;
	public ReturnPanel pReturn;
	public Station station;
	
	public StationInfoPanel pStationInfo ;
	public StationState state;

	
	
	
	
	public StationGUI(String stationName) throws IOException {
		
		
		this.state=StationState.BLANK;
		station=Session.getStationByStationName(stationName);
		this.setBounds(0, 0, 964, 265);
		
		
		setTitle("Station Bulletin Board");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 986, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pStationInfo = new StationInfoPanel(station);
		pStationInfo.setBounds(0, 0, 964, 265);
		contentPane.add(pStationInfo);
		pStationInfo.setLayout(null);
		

		pblank= new RentOrReturnBlank();
		pblank.setVisible(false);
		pblank.setBounds(0, 452, 964, 154);
		contentPane.add(pblank);
		pblank.setLayout(null);
		
		pRent = new RentPanel();
		pRent.setVisible(false);
		pRent.setBounds(0, 452, 964, 154);
		contentPane.add(pRent);
		pRent.setLayout(null);
		
		pReturn = new ReturnPanel();
		pReturn.setVisible(false);
		pReturn.setBounds(0, 452, 964, 154);
		contentPane.add(pReturn);
		pReturn.setLayout(null);
		
		
		pPersonInfo = new PersonInfoPanel();
		pPersonInfo.setBounds(0, 265, 964, 188);
		contentPane.add(pPersonInfo);
		pPersonInfo.setLayout(null);
		pPersonInfo.simulSwipCard.addActionListener((e)->{
			String userId=pPersonInfo.jtfinputId.getText();
			if(state==StationState.BLANK) {
				new ScooterService()
				.rentOrReturn(userId, station,StationGUI.this);
			}
			
			
			
		});
		
		
		pRent.btnTakeOut.addActionListener((e)->{
			Session.chosenSlot.setSlotState(SlotState.LOCK_EMPTY);
		});
		
		pReturn.btnTakeOut.addActionListener((e)->{
			Session.chosenSlot.setSlotState(SlotState.LOCK_HAS_SCOOTER);
		});
		
		this.switchTo(StationState.BLANK);
		
	}
	
	
	public void switchTo(StationState state) {
		this.state=state;
		contentPane.remove(pStationInfo);
		pStationInfo = new StationInfoPanel(station);
		pStationInfo.setBounds(0, 0, 964, 265);
		contentPane.add(pStationInfo);
		pStationInfo.setLayout(null);
		this.contentPane.updateUI();
		
		User currentUser=Session.currentUser;
		
		switch (state) {
			case BLANK:
				pRent.setVisible(false);
				pReturn.setVisible(false);
				pblank.setVisible(true);
				pPersonInfo.lbId.setText("");
				pPersonInfo.lbName.setText("");
				pPersonInfo.lbEmail.setText("");
				pPersonInfo.jtfinputId.setText("");
				pPersonInfo.lbFine.setText("");
				pPersonInfo.jtfinputId.setText("");
				break;
				
			case RENT:
				pRent.setVisible(true);
				pReturn.setVisible(false);
				pblank.setVisible(false);
				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
				
			case RETURN:
				pRent.setVisible(false);
				pReturn.setVisible(true);
				pblank.setVisible(false);
				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
				
			case UNPAID:
				pRent.setVisible(false);
				pReturn.setVisible(false);
				pblank.setVisible(true);
				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
		}
			
			
		
		
	}
	
	
	
}
