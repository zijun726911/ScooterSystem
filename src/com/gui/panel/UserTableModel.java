package com.gui.panel;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import com.db.Session;
import com.entity.User;
import com.gui.SingleUserRecordsGUI;

public class UserTableModel extends AbstractTableModel   {
	Object[][] data=new Object[Session.users.size()][8];
	 String[] columnNames =  
	        { "ID", "name", "E-mail", "last time usage", "today usage",
	        		"this week usage", "total usage" ,"show all records"};  
	
	public UserTableModel() {
		// TODO Auto-generated constructor stub
		ArrayList<User> users=Session.users;
		for(int i=0;i<users.size();i++) {
			User user=users.get(i);
			data[i][0]=user.getId();
			data[i][1]=user.getName();
			data[i][2]=user.getEmail();
			data[i][3]="NAN";
			data[i][4]="NAN";
			data[i][5]="NAN";
			data[i][6]="NAN";
			JButton button=new JButton();
			button.addActionListener((e)->{
				
				new SingleUserRecordsGUI(user);
				
			});
			data[i][7]=button;
			
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
