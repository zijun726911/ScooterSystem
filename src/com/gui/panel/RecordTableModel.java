package com.gui.panel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.db.Session;
import com.entity.Record;
import com.entity.User;
import com.gui.SingleUserRecordsGUI;

public class RecordTableModel extends AbstractTableModel   {
	Object[][] data=new Object[Session.users.size()][8];
	 String[] columnNames =  
	        { "Start\r\nTime", "Start\r\nPosition",
	        		"End\r\nTime", "End\r\nPosition", "duration (min)"};  
	
	public RecordTableModel(User user) {
		// TODO Auto-generated constructor stub
		ArrayList<Record> records=user.getRecords();
		for(int i=0;i<records.size();i++) {
			Record record=records.get(i);
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
	        data[i][0]=format.format(record.getStartTime());
			data[i][1]=record.startStation;
			data[i][2]=format.format(record.getEndTime());
			data[i][3]=record.endStation;
			data[i][4]=record.durMin;
			
			
		}
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
