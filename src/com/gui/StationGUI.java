package com.gui;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.db.Db;
import com.db.Session;
import com.entity.SlotState;
import com.entity.Station;
import com.entity.StationState;
import com.gui.panel.PersonalInformationPanel;
import com.gui.panel.RentOrReturnBlank;
import com.gui.panel.RentPanel;
import com.gui.panel.ReturnPanel;
import com.gui.panel.StationInfoPanel;
import com.service.ScooterService;

public class StationGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private PersonalInformationPanel pInfo;
	private RentPanel pRent;
	private RentOrReturnBlank pblank;
	private ReturnPanel pReturn;
	
	Station station;
	StationInfoPanel pStationInfo ;

	
	private static StationGUI instance;


	
	public static StationGUI getInstance(String stationName)  {
		
		if (null == instance) {
			try {
				instance = new StationGUI(stationName);
				instance.switchTo(StationState.BLANK);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return instance;
	}
	
	
	private StationGUI(String stationName) throws IOException {
		
		
		this.station=Db.getInstance().getStationByStationName(stationName);
		setTitle("Station Bulletin Board");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 662);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pStationInfo = new StationInfoPanel();
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
		
		
		
		
		pInfo = new PersonalInformationPanel();
		pInfo.setBounds(0, 265, 964, 188);
		contentPane.add(pInfo);
		pInfo.setLayout(null);
		pInfo.btnRentOrReturn.addActionListener((e)->{
			String userId=pInfo.jtfinputId.getText();
			
			ScooterService.rentOrReturn(userId, station, pRent.labeltimer);
		});
		
		
		pRent.btnTakeOut.addActionListener((e)->{
			Session.chosenSlot.setSlotState(SlotState.LOCK_EMPTY);;
		});
		
		
	}
	
	
	public void switchTo(StationState state) {
		switch (state) {
			case BLANK:
				pRent.setVisible(false);
				pReturn.setVisible(false);
				pblank.setVisible(true);
				break;
				
			case RENT:
				pRent.setVisible(true);
				pReturn.setVisible(false);
				pblank.setVisible(false);
				break;
				
			case RETURN:
				pRent.setVisible(false);
				pReturn.setVisible(true);
				pblank.setVisible(false);
				break;
		}
			
			
		
		
	}
}
