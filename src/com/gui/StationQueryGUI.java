package com.gui;

import java.awt.Font;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.db.Session;
import com.entity.Station;
import com.entity.StationInfoModel;
import com.entity.OneStationInfo;

public class StationQueryGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public StationQueryGUI(StationInfoModel model) {
		OneStationInfo infoA=model.oneStationInfos.get("A");
		OneStationInfo infoB=model.oneStationInfos.get("B");
		OneStationInfo infoC=model.oneStationInfos.get("C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 900, 649);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblStation = new JLabel("Station");
		lblStation.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblStation.setBounds(90, 136, 146, 26);
		contentPane.add(lblStation);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblA.setBounds(367, 139, 81, 21);
		contentPane.add(lblA);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblB.setBounds(495, 139, 81, 21);
		contentPane.add(lblB);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblC.setBounds(634, 139, 81, 21);
		contentPane.add(lblC);
		
		JLabel lblAvailableScooters = new JLabel("Available Scooter(s)");
		lblAvailableScooters.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblAvailableScooters.setBounds(90, 188, 236, 49);
		contentPane.add(lblAvailableScooters);
		
		JLabel lblEmptyScooters = new JLabel("Empty Slot(s)");
		lblEmptyScooters.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblEmptyScooters.setBounds(90, 261, 203, 34);
		contentPane.add(lblEmptyScooters);
		
		JLabel avaA = new JLabel(""+infoA.avaScooter);
		avaA.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		avaA.setBounds(367, 200, 81, 21);
		contentPane.add(avaA);
		
		JLabel lblTotalNumber = new JLabel("Total Number");
		lblTotalNumber.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblTotalNumber.setBounds(90, 322, 185, 49);
		contentPane.add(lblTotalNumber);
		
		JLabel empA = new JLabel(""+infoA.empScooter);
		empA.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		empA.setBounds(367, 268, 81, 21);
		contentPane.add(empA);
		
		JLabel totA = new JLabel(""+infoA.totSlot);
		totA.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		totA.setBounds(367, 336, 81, 21);
		contentPane.add(totA);
		
		JLabel avaB = new JLabel(""+infoB.avaScooter);
		avaB.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		avaB.setBounds(495, 200, 81, 21);
		contentPane.add(avaB);
		
		JLabel empB = new JLabel(""+infoB.empScooter);
		empB.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		empB.setBounds(495, 268, 81, 21);
		contentPane.add(empB);
		
		JLabel totB = new JLabel(""+infoB.totSlot);
		totB.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		totB.setBounds(495, 336, 81, 21);
		contentPane.add(totB);
		
		JLabel avaC = new JLabel(""+infoC.avaScooter);
		avaC.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		avaC.setBounds(634, 200, 81, 21);
		contentPane.add(avaC);
		
		JLabel empC = new JLabel(""+infoC.empScooter);
		empC.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		empC.setBounds(634, 268, 81, 21);
		contentPane.add(empC);
		
		JLabel totC = new JLabel(""+infoC.totSlot);
		totC.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		totC.setBounds(634, 336, 81, 21);
		contentPane.add(totC);
		
		JLabel lblPleaseInputYour = new JLabel("Scooters in use: ");
		lblPleaseInputYour.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblPleaseInputYour.setBounds(47, 409, 218, 49);
		contentPane.add(lblPleaseInputYour);
		
		JLabel lblTotalAvailableScooters = new JLabel("Total available scooters: ");
		lblTotalAvailableScooters.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblTotalAvailableScooters.setBounds(47, 451, 279, 56);
		contentPane.add(lblTotalAvailableScooters);
		
		JLabel lblTotalScooters = new JLabel("Total Slots: ");
		lblTotalScooters.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lblTotalScooters.setBounds(47, 509, 185, 56);
		contentPane.add(lblTotalScooters);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(83, 112, 615, 12);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(83, 177, 615, 12);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(83, 241, 615, 12);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(83, 316, 615, 12);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		separator_4.setBounds(83, 112, 38, 269);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setOrientation(SwingConstants.VERTICAL);
		separator_5.setBounds(323, 112, 38, 269);
		contentPane.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		separator_6.setBounds(438, 112, 38, 269);
		contentPane.add(separator_6);
		
		JSeparator separator_7 = new JSeparator();
		separator_7.setOrientation(SwingConstants.VERTICAL);
		separator_7.setBounds(571, 112, 38, 269);
		contentPane.add(separator_7);
		
		JSeparator separator_8 = new JSeparator();
		separator_8.setOrientation(SwingConstants.VERTICAL);
		separator_8.setBounds(695, 112, 38, 269);
		contentPane.add(separator_8);
		
		JSeparator separator_9 = new JSeparator();
		separator_9.setBounds(83, 380, 615, 12);
		contentPane.add(separator_9);
		
		JLabel lblStationInformation = new JLabel("Station Information");
		lblStationInformation.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		lblStationInformation.setBounds(278, 32, 360, 65);
		contentPane.add(lblStationInformation);
		
		JLabel lbScooterInUse = new JLabel(""+model.scooterUsing);
		lbScooterInUse.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		lbScooterInUse.setBounds(258, 409, 81, 49);
		contentPane.add(lbScooterInUse);
		
		JLabel labelTotalAvail = new JLabel(""+model.scooterAvail);
		labelTotalAvail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		labelTotalAvail.setBounds(333, 458, 81, 49);
		contentPane.add(labelTotalAvail);

		JLabel labelTotalScooter = new JLabel(""+model.totSlot);
		labelTotalScooter.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 24));
		labelTotalScooter.setBounds(191, 513, 81, 49);
		contentPane.add(labelTotalScooter);
		
	}
}
