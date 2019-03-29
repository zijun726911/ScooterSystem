package com.gui.panel;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.entity.Slot;
import com.entity.SlotState;
import com.gui.LightGUI;

public class SingleSlotJPanel extends JPanel {
	public LightGUI lbLight;
	
	public JLabel lbScooter ;
	public JLabel lbslotNumber ;
	public Slot slot;
	
	public SingleSlotJPanel(Slot slot) {
		this.slot=slot;
		setLayout(null);
		lbLight = new LightGUI();
		
		lbLight.setBounds(36, 34, 32, 32);
		lbLight.setVisible(false);
		this.add(lbLight);
		
		
		lbslotNumber = new JLabel(slot.getId());
		lbslotNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lbslotNumber.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 20));
		lbslotNumber.setBounds(36, 0, 31, 32);
		
		this.add(lbslotNumber);
		
		lbScooter = new JLabel(new ImageIcon("img/scooter.png"));
		lbScooter.setVisible(false);
		lbScooter.setBounds(29, 85, 50, 48);
		this.add(lbScooter);
		
		switchTo(slot.getSlotState());
		
		
		
		
		
		
	}
	
	public void switchTo(SlotState state) {
		switch (state) {
			case LOCK_EMPTY:
				lbLight.setVisible(false);
				lbScooter.setVisible(false);
				break;
				
			case LOCK_HAS_SCOOTER:
				lbLight.setVisible(false);
				lbScooter.setVisible(true);
				break;
				
			case RELEASED_NOT_PICKUP:
				lbLight.flashLight();
				lbScooter.setVisible(true);

				break;
		}
		
	}
	
	public void paint(Graphics graphics) {
		
				super.paint(graphics);
		
				int initx=20;
				int inity=140;
				graphics.fillRect(initx, inity, 5, 10);
				graphics.fillRect(initx, inity+10, 65, 5);
				graphics.fillRect(initx+60, inity, 5, 10);
			}
	
	

}
