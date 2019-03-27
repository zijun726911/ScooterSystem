package com.gui.panel;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.gui.utils.GUIUtil;

public class SingleSlotJPanel extends JPanel {
	public SingleSlotJPanel(String slotNumber) {
		setLayout(null);
		JLabel lbLightImg = new JLabel(new ImageIcon("img/lightOn.png"));
		
		lbLightImg.setBounds(36, 34, 32, 32);
		this.add(lbLightImg);
		//lbLightImg
		GUIUtil.getInstance().flashLight(lbLightImg);
		
		JLabel lblslotNumber = new JLabel(slotNumber);
		lblslotNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblslotNumber.setFont(new Font("΢���ź�", Font.BOLD, 20));
		lblslotNumber.setBounds(36, 0, 31, 32);
		this.add(lblslotNumber);
		
		JLabel lbScooter = new JLabel(new ImageIcon("img/scooter.png"));
		lbScooter.setBounds(29, 85, 50, 48);
		this.add(lbScooter);
		
		
		
	}
	
	public void paint(Graphics graphics) {
		// 1.���ø�����ɳ�ʼ������
				super.paint(graphics);
		// �򵥵Ļ�һ��ԲȦ ʹ�ø÷���drawOval ����Ϊ x ���� y ���� ��� �߶� ��λ��������
		// x ����� y ���� Ϊ��������GUI�������Ͻǵ�λ�õ�����
				int initx=20;
				int inity=140;
				graphics.fillRect(initx, inity, 5, 10);
				graphics.fillRect(initx, inity+10, 65, 5);
				graphics.fillRect(initx+60, inity, 5, 10);
			}
}
