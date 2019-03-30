package com.gui.panel;

import java.awt.Font;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.entity.Slot;
import com.entity.SlotState;
import com.entity.Station;

public class StationInfoPanel extends JPanel {
	Station station;
	
	public SingleSlotJPanel singleSlotJPanel1;
	public SingleSlotJPanel singleSlotJPanel2;
	public SingleSlotJPanel singleSlotJPanel3;
	public SingleSlotJPanel singleSlotJPanel4;
	public SingleSlotJPanel singleSlotJPanel5;
	public SingleSlotJPanel singleSlotJPanel6;
	public SingleSlotJPanel singleSlotJPanel7;
	public SingleSlotJPanel singleSlotJPanel8;

	
	
	
	public StationInfoPanel(Station station) {
		this.station=station;
		
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
		
		int availablenum=0;
		for(Slot s:station.getSlots()) {
			if(s.getSlotState()!=SlotState.LOCK_EMPTY) {
				availablenum++;
			}
		}
		JLabel label_1 = new JLabel(availablenum+"/"+station.getSlots().size());
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		label_1.setBounds(724, 30, 81, 39);
		this.add(label_1);
		
		Iterator<Slot> nextSlot=station.getSlots().iterator();
		
		singleSlotJPanel1 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel1.setBounds(32, 87, 100, 173);
		this.add(singleSlotJPanel1);
		
		singleSlotJPanel2 = new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel2.setBounds(147, 87, 100, 173);
		this.add(singleSlotJPanel2);
		
		singleSlotJPanel3 = new SingleSlotJPanel (nextSlot.next());
		singleSlotJPanel3.setBounds(262, 87, 100, 173);
		this.add(singleSlotJPanel3);
		
		singleSlotJPanel4 =new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel4.setBounds(377, 87, 100, 173);
		this.add(singleSlotJPanel4);
		
		 singleSlotJPanel5 =new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel5.setBounds(492, 87, 100, 173);
		this.add(singleSlotJPanel5);
		
		singleSlotJPanel6 =new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel6.setBounds(607, 87, 100, 173);
		this.add(singleSlotJPanel6);
		
		singleSlotJPanel7 =new  SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel7.setBounds(722, 87, 100, 173);
		this.add(singleSlotJPanel7);
		
		singleSlotJPanel8 =new SingleSlotJPanel(nextSlot.next());
		singleSlotJPanel8.setBounds(833, 87, 100, 173);
		this.add(singleSlotJPanel8);
	}
}
