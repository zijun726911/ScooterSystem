package com.model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.db.Session;
import com.entity.Record;
import com.entity.User;
import com.service.UserService;
import com.utils.TimeUtil;

public class UserTableModel extends AbstractTableModel   {
	
	private int showBtnColIndex=8;
    private int delBtnColIndex=9;
    ArrayList<User> users;
		 	
	ArrayList<String[]> data;
			String[] columnNames =  
			        { "ID", "name", "E-mail", "last time duration", "today duration",
			        		"this week usage", "total usage","unpaid fine","show all records","delete user" };  
			
			public UserTableModel() {
				// TODO Auto-generated constructor stub
				users=Session.users;
				data=new ArrayList<String[]>();
				for(int i=0;i<users.size();i++) {
					User user=users.get(i);
					ArrayList<Record> records= user.getRecords();
					
					String id=user.getId();
					String name=user.getName();
					String email=user.getEmail();
					String lastDur;
					String dayDur;
					String weekDur;
					String totalDur;
					if(records.size()>0) {
						Record lastRecord=records.get(records.size()-1);
						 lastDur=TimeUtil.secToTime((int)lastRecord.durSec);
						 dayDur=TimeUtil.secToTime((int)UserService
								.getOneDayAccuTime(user,lastRecord.startTime ));
						 weekDur=TimeUtil.secToTime((int)UserService
								.getThisWeekAccuTime(user));
						 totalDur=TimeUtil.secToTime((int)UserService
								.getTotalAccuTime(user));
					}
					else {
						lastDur=TimeUtil.secToTime(0);
						dayDur=TimeUtil.secToTime(0);
						weekDur=TimeUtil.secToTime(0);
						totalDur=TimeUtil.secToTime(0);
					}
					String unpaid=""+user.getUnpaidFineFine();
					data.add(new String[]{id,name,email,lastDur,dayDur,weekDur,totalDur,unpaid,"",""});
					
				}
			}
			@Override  
		    public String getColumnName(int column)  
		    {  
		        return columnNames[column];  
		    }  
		      
		    /** 
		     * 重写方法，得到表格列数 
		     */  
		    @Override  
		    public int getColumnCount()  
		    {  
		        return columnNames.length;  
		    }  

		    /** 
		     * 得到表格行数 
		     */  
		    @Override  
		    public int getRowCount()  
		    {  
		        return data.size();  
		    }  

		    /** 
		     * 得到数据所对应对象 
		     */  
		    @Override  
		    public Object getValueAt(int rowIndex, int columnIndex)  
		    {  
		        return data.get(rowIndex)[columnIndex];  
		    }  

		    /** 
		     * 得到指定列的数据类型 
		     */  
		    @Override  
		    public Class<?> getColumnClass(int columnIndex)  
		    {  
		        return data.get(0)[columnIndex].getClass();  
		    }  

		    /** 
		     * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑 
		     */  
		    @Override  
		    public boolean isCellEditable(int rowIndex, int columnIndex)  
		    {  
		    	if (columnIndex == showBtnColIndex ||columnIndex == delBtnColIndex)  
                {  
                    return true;  
                }  
                else  
                {  
                    return false;  
                }   
		            
		        
		    }  
		      
		    /** 
		     * 如果数据单元为可编辑，则将编辑后的值替换原来的值 
		     */  
		    @Override  
		    public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
		    {  
		        
		        if(rowIndex<data.size()) {
		        	data.get(rowIndex)[columnIndex] = (String) aValue;  
		        }
		    	
		        /*通知监听器数据单元数据已经改变*/  
		       
		        fireTableCellUpdated(rowIndex, columnIndex);  
		    }
		    
		    
		    public void delete(int row) {
		    	data.remove(row);
		    	
		    	fireTableRowsDeleted(row, row);
		    	
		    }
		    
		    
		    
		  
		 }