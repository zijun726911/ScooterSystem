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
		lblslotNumber.setFont(new Font("微软雅黑", Font.BOLD, 20));
		lblslotNumber.setBounds(36, 0, 31, 32);
		this.add(lblslotNumber);
		
		JLabel lbScooter = new JLabel(new ImageIcon("img/scooter.png"));
		lbScooter.setBounds(29, 85, 50, 48);
		this.add(lbScooter);
		
		
		
	}
	
	public void paint(Graphics graphics) {
		// 1.调用父类完成初始化任务
				super.paint(graphics);
		// 简单的画一个圆圈 使用该方法drawOval 参数为 x 坐标 y 坐标 宽度 高度 单位都是像素
		// x 坐标和 y 坐标 为距离我们GUI界面左上角的位置的像素
				int initx=20;
				int inity=140;
				graphics.fillRect(initx, inity, 5, 10);
				graphics.fillRect(initx, inity+10, 65, 5);
				graphics.fillRect(initx+60, inity, 5, 10);
			}
}
