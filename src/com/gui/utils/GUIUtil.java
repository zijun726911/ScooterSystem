package com.gui.utils;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

public class GUIUtil {// 单例
	private static GUIUtil instance;

	private GUIUtil() {

	}

	public static GUIUtil getInstance() {
		// 第一次访问的时候，发现instance没有指向任何对象，这时实例化一个对象
		if (null == instance) {
			instance = new GUIUtil();
		}
		// 返回 instance指向的对象
		return instance;
	}

	public void countDown(JLabel lb, int number) {
		lb.setText("" + number);
		new CountDownSwingWorker(lb, number).execute();

	}
	
	
	public void flashLight(JLabel lightImg) {

		new FlashSwingWorker(lightImg).execute();

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

	private class FlashSwingWorker extends SwingWorker<Void, Void> {
		private JLabel lightImg;
		private boolean flicker;
		
		FlashSwingWorker(JLabel lightImg) {
			this.lightImg = lightImg;
			flicker=true;
		}

		@Override
		protected Void doInBackground() throws Exception {
			
			while(true) {
				Thread.sleep(500);
				
				publish();
			}

		}
		@Override
		protected void process(List<Void> chunks) {
			flicker=!flicker;
			lightImg.setVisible(flicker);

			
		}

	}

	
}
