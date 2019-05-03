package com.gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import com.db.Session;
import com.entity.Record;
import com.entity.User;
import com.utils.TimeUtil;

import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;

public class SingleUserRecordsGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JLabel label;
	private JLabel label_1;
	private JLabel lbID;
	private JLabel label_3;
	private JLabel lbName;
	User user;
	

	/**
	 * Create the frame.
	 */
	public SingleUserRecordsGUI(int row) {
		super("Personal Usage");
		user=Session.users.get(row);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		this.setAlwaysOnTop(true);
		setBounds(100, 100, 1007, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
       
        table = new JTable(new RecordTableModel(user));
        table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        scroll = new JScrollPane(table);  
        scroll.setLocation(27, 128);
        
        contentPane.add(scroll);
        scroll.setSize(923, 407);
        
        label = new JLabel("Scooter Usage Record");
        label.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        label.setBounds(301, 0, 343, 59);
        contentPane.add(label);
        
        label_1 = new JLabel("user id:");
        label_1.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        label_1.setBounds(153, 56, 126, 43);
        contentPane.add(label_1);
        
        lbID = new JLabel(user.getId());
        lbID.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lbID.setBounds(250, 56, 100, 43);
        contentPane.add(lbID);
        
        label_3 = new JLabel("user name:");
        label_3.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        label_3.setBounds(536, 56, 126, 43);
        contentPane.add(label_3);
        
        lbName = new JLabel(user.getName());
        lbName.setFont(new Font("微软雅黑", Font.PLAIN, 20));
        lbName.setBounds(659, 42, 126, 71);
        contentPane.add(lbName);
	}
	
	
	public class RecordTableModel extends AbstractTableModel   {
		Object[][] data=new Object[user.getRecords().size()][8];
		 String[] columnNames =  
		        { "Start Time", "Start Position",
		        		"End Time", "End Position", "duration"};  
		
		public RecordTableModel(User user) {
			// TODO Auto-generated constructor stub
			ArrayList<Record> records=user.getRecords();
			for(int i=0;i<records.size();i++) {
				Record record=records.get(records.size()-1-i);
		        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		        data[i][0]=format.format(record.getStartTime());
				data[i][1]=record.startStation;
				if(record.endStation!=null) {
					data[i][2]=format.format(record.getEndTime());
					data[i][3]=record.endStation;
					data[i][4]=TimeUtil.secToTime((int)record.durSec);
				}
				else {
					data[i][2]="";
					data[i][3]="";
					data[i][4]="";
				}
				
				
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
	        return data.length;  
	    }  

	    /** 
	     * 得到数据所对应对象 
	     */  
	    @Override  
	    public Object getValueAt(int rowIndex, int columnIndex)  
	    {  
	        return data[rowIndex][columnIndex];  
	    }  

	    /** 
	     * 得到指定列的数据类型 
	     */  
	    @Override  
	    public Class<?> getColumnClass(int columnIndex)  
	    {  
	        return data[0][columnIndex].getClass();  
	    }  

	   
	    @Override  
	    public boolean isCellEditable(int rowIndex, int columnIndex)  
	    {  
	        
	            return false;  
	         
	    }  
	      
	    /** 
	     * 如果数据单元为可编辑，则将编辑后的值替换原来的值 
	     */  
	    @Override  
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex)  
	    {  
	        data[rowIndex][columnIndex] = aValue;  
	        /*通知监听器数据单元数据已经改变*/  
	        fireTableCellUpdated(rowIndex, columnIndex);  
	    }  

	}  

}
