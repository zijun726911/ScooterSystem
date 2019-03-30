package com.gui.utils;

import java.awt.Rectangle;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

import com.entity.StationState;
import com.gui.StationGUI;

public class GUIUtil {// ����
	private static GUIUtil instance;

	private GUIUtil() {

	}
	
	public static StationGUI reconstructStation(StationGUI from) {
	
		 StationGUI newStation=null;
		 try {
			 newStation=new StationGUI(from.station.getName(),from.getBounds());
			 newStation.setVisible(true);
			 newStation.switchTo(StationState.RENT);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 from.dispose();
		 
		 return newStation;
		 
	}
	
	
	public static GUIUtil getInstance() {
		
		if (null == instance) {
			instance = new GUIUtil();
		}
		
		return instance;
	}
	
	 public static void  jump(JFrame from, JFrame  to) {
		 from.setVisible(false);
		 from.dispose();
		 to.setVisible(true);
		 
	}

	public void countDown(JLabel lb, int number) {
		lb.setText("" + number);
		new CountDownSwingWorker(lb, number).execute();

	}
	
	


	private class CountDownSwingWorker extends SwingWorker<Void, Integer> {
		private JLabel lb;
		private int number;

		CountDownSwingWorker(JLabel lb, int number) {
			this.lb = lb;
			this.number = number;
		}

		@Override
		// ��̨�����ڴ˷�����ʵ��
		protected Void doInBackground() throws Exception {
		
			for (int i = number; i >= 0; i--) {
				Thread.sleep(1000);
				publish(i);// ����ǰ������Ϣ����chunks��
			}
			return null;

		}

		@Override
		// ÿ�θ��½���������Ϣ
		protected void process(List<Integer> chunks) {
			lb.setText("" + chunks.get(chunks.size() - 1));
			// contentPane.updateUI();
		}
	}

	

	
}
