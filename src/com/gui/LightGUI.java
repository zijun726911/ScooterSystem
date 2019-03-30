package com.gui;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;



public class LightGUI extends JLabel{
	
	public LightGUI() {
		super(new ImageIcon("img/lightOn.png"));
	}
	
	public void flashLight() {

		new FlashSwingWorker(this).execute();

	}
	private class FlashSwingWorker extends SwingWorker<Void, Void> {
		private JLabel lightImg;
		private boolean flicker;
		
		FlashSwingWorker(JLabel lightImg) {
			this.lightImg = lightImg;
			flicker=false;
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
