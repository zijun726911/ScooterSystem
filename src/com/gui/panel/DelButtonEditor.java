package com.gui.panel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import com.model.UserTableModel;
import com.service.UserService;

public class DelButtonEditor extends DefaultCellEditor  
{  
  

  
	private int row;
    private JButton button;
    
  
    public DelButtonEditor()  
    {  
        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�   
        super(new JTextField()); 
       
  
        // ���õ�����μ���༭��   
        this.setClickCountToStart(1);  
  
        this.initButton();  
  
     
  
        
    }  
  
    private void initButton()  
    {  
        this.button = new JButton("delete");  
  
        // ���ð�ť�Ĵ�С��λ�á�   
//        this.button.setBounds(0, 0, 50, 15);  
  
        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��   
        this.button.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                // ����ȡ���༭���¼����������tableModel��setValue������   
            	
            	DelButtonEditor.this.fireEditingCanceled();  

                // �������������������   
                // ���Խ�table���룬ͨ��getSelectedRow,getSelectColumn������ȡ����ǰѡ����к��м����������ȡ�   
            }  
        });  
  
    }  
  
   
  
  
    /** 
     * ������д����ı༭����������һ��JPanel���󼴿ɣ�Ҳ����ֱ�ӷ���һ��Button���󣬵��������������������Ԫ�� 
     */  
    @Override  
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column)  
    {  
        // ֻΪ��ť��ֵ���ɡ�Ҳ���������������� 
//    	System.out.println("row: "+row);
    	
    	
    	int option=JOptionPane.showConfirmDialog(null,"Do you want to delete this user?", 
				"Delete User",JOptionPane.YES_NO_OPTION);
        if(option==JOptionPane.OK_OPTION) {
        	
        	
        	((UserTableModel)table.getModel()).delete(row);
        	new UserService().delete(row);
//			table.validate();
//			table.updateUI();
        	
        }
        ((AbstractTableModel)table.getModel()).fireTableDataChanged();
        this.button.setText(value == null ? "" : "delete");
        return this.button;  
    }  
  
    /** 
     * ��д�༭��Ԫ��ʱ��ȡ��ֵ���������д��������ܻ�Ϊ��ť���ô����ֵ�� 
     */  
    @Override  
    public Object getCellEditorValue()  
    {  
    	
    	return this.button.getText();  
    }  
  
} 