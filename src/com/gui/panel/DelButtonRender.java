package com.gui.panel;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DelButtonRender implements TableCellRenderer
{
   

    private JButton button;

    public DelButtonRender()
    {
        this.initButton();

       

        // ��Ӱ�ť��
//        this.panel.add(this.button);
    }

    private void initButton()
    {
        this.button = new JButton("delete");


    }

   
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
            int column)
    {
        // ֻΪ��ť��ֵ���ɡ�Ҳ������������������汳���ȡ�
    
        this.button.setText(value == null ? "" : "delete");
        
        return this.button;
    }

}
