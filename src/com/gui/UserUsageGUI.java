package com.gui;



import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;

import com.db.Session;
import com.entity.User;
import com.gui.panel.MyButtonEditor;
import com.gui.panel.MyButtonRender;

public class UserUsageGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JLabel lblNewLabel;
    private int btColIndex=7;
	

	/**
	 * Create the frame.
	 */
	public UserUsageGUI() {
		super("Personal Usage");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1007, 647);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
        table = new JTable(new UserTableModel());
        table.setFillsViewportHeight(true);
        table.setColumnSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        scroll = new JScrollPane(table);  
        scroll.setLocation(27, 128);
        
        contentPane.add(scroll);
        scroll.setSize(923, 407);
        
        lblNewLabel = new JLabel("User Usage");
        lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
        lblNewLabel.setBounds(374, 15, 211, 50);
        contentPane.add(lblNewLabel);
        table.setFont(new Font("微软雅黑", Font.PLAIN, 15));
        this.table.getColumnModel().getColumn(2).setPreferredWidth(200);
        this.table.getColumnModel()
        .getColumn(btColIndex)
        .setCellEditor(new MyButtonEditor());  
        
        this.table.getColumnModel()
        .getColumn(btColIndex)
        .setCellRenderer(new MyButtonRender());  
        
        this.table.setRowSelectionAllowed(false);
	}
	
	
	 class UserTableModel extends AbstractTableModel   {
		 	
			Object[][] data=new Object[Session.users.size()][8];
			String[] columnNames =  
			        { "ID", "name", "E-mail", "last time usage", "today usage",
			        		"this week usage", "total usage","show all records" };  
			
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
					data[i][7]="";
					
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

		    /** 
		     * 指定设置数据单元是否可编辑.这里设置"姓名","学号"不可编辑 
		     */  
		    @Override  
		    public boolean isCellEditable(int rowIndex, int columnIndex)  
		    {  
		    	if (columnIndex == btColIndex)  
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
		        data[rowIndex][columnIndex] = aValue;  
		        /*通知监听器数据单元数据已经改变*/  
		        fireTableCellUpdated(rowIndex, columnIndex);  
		    }
		 }

}
