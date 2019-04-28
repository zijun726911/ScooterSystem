package com.gui.panel;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.entity.User;
import com.gui.SingleUserRecordsGUI;

public class MyButtonEditor extends DefaultCellEditor  
{  
  
    /** 
     * serialVersionUID 
     */  
    private static final long serialVersionUID = -6546334664166791132L;  
  
    private JPanel panel;  
  
    private JButton button;
    
  
    public MyButtonEditor()  
    {  
        // DefautlCellEditor�д˹���������Ҫ����һ�������������ʹ�õ���ֱ��newһ�����ɡ�   
        super(new JTextField()); 
       
  
        // ���õ�����μ���༭��   
        this.setClickCountToStart(1);  
  
        this.initButton();  
  
     
  
        
    }  
  
    private void initButton()  
    {  
        this.button = new JButton("show");  
  
        // ���ð�ť�Ĵ�С��λ�á�   
//        this.button.setBounds(0, 0, 50, 15);  
  
        // Ϊ��ť����¼�������ֻ�����ActionListner�¼���Mouse�¼���Ч��   
        this.button.addActionListener(new ActionListener()  
        {  
            public void actionPerformed(ActionEvent e)  
            {  
                // ����ȡ���༭���¼����������tableModel��setValue������   
                MyButtonEditor.this.fireEditingCanceled();  

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
    	new SingleUserRecordsGUI(row).setVisible(true);;
        this.button.setText(value == null ? "" : "show");  
        
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