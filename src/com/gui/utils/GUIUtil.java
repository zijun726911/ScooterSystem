package com.gui.utils;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

public class GUIUtil {// 单例
	private static GUIUtil instance;

	private GUIUtil() {

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
		// 后台任务在此方法中实现
		protected Void doInBackground() throws Exception {
		
			for (int i = number; i >= 0; i--) {
				Thread.sleep(1000);
				publish(i);// 将当前进度信息加入chunks中
			}
			return null;

		}

		@Override
		// 每次更新进度条的信息
		protected void process(List<Integer> chunks) {
			lb.setText("" + chunks.get(chunks.size() - 1));
			// contentPane.updateUI();
		}
	}

	

	
}
