package com.gui.panel;

import java.awt.Font;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entity.Slot;
import com.entity.Station;

public class StationInfoPanel extends JPanel {
	Station station;
	public StationInfoPanel(Station station) {
		this.station=station;
		Iterator<Slot> nextSlot=station.getSlots().iterator();
		// TODO Auto-generated constructor stub
		JLabel lblNewLabel = new JLabel("Station");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		lblNewLabel.setBounds(377, 0, 116, 54);
		this.add(lblNewLabel);
		
		JLabel labelStationName = new JLabel(station.getName());
		labelStationName.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
		labelStationName.setBounds(504, 6, 49, 45);
		this.add(labelStationName);
		
		JLabel lblAvailable = new JLabel("Available:");
		lblAvailable.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		lblAvailable.setBounds(621, 27, 100, 45);
		this.add(lblAvailable);
		
		JLabel label_1 = new JLabel("8/8");
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_1.setBounds(724, 30, 81, 39);
		this.add(label_1);
		
		JPanel panelSlotInfo1 = new SingleSlotJPanel(nextSlot.next());
		panelSlotInfo1.setBounds(32, 87, 100, 173);
		this.add(panelSlotInfo1);
		
		SingleSlotJPanel singleSlotJPanel2 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel2.setBounds(147, 87, 100, 173);
		this.add(singleSlotJPanel2);
		
		SingleSlotJPanel singleSlotJPanel3 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel3.setBounds(262, 87, 100, 173);
		this.add(singleSlotJPanel3);
		
		SingleSlotJPanel singleSlotJPanel4 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel4.setBounds(377, 87, 100, 173);
		this.add(singleSlotJPanel4);
		
		SingleSlotJPanel singleSlotJPanel5 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel5.setBounds(492, 87, 100, 173);
		this.add(singleSlotJPanel5);
		
		SingleSlotJPanel singleSlotJPanel6 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel6.setBounds(607, 87, 100, 173);
		this.add(singleSlotJPanel6);
		
		SingleSlotJPanel singleSlotJPanel7 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel7.setBounds(722, 87, 100, 173);
		this.add(singleSlotJPanel7);
		
		SingleSlotJPanel singleSlotJPanel8 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel8.setBounds(833, 87, 100, 173);
		this.add(singleSlotJPanel8);
	}
}
