package com.gui.panel;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class MyButtonRender implements TableCellRenderer
{
    private JPanel panel;

    private JButton button;

    public MyButtonRender()
    {
        this.initButton();

       

        // 添加按钮。
//        this.panel.add(this.button);
    }

    private void initButton()
    {
        this.button = new JButton("show");

        // 设置按钮的大小及位置。
//        this.button.setBounds(0, 0, 50, 15);

        // 在渲染器里边添加按钮的事件是不会触发的
        // this.button.addActionListener(new ActionListener()
        // {
        //
        // public void actionPerformed(ActionEvent e)
        // {
        // // TODO Auto-generated method stub
        // }
        // });

    }

   
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row,
            int column)
    {
        // 只为按钮赋值即可。也可以作其它操作，如绘背景等。
    
        this.button.setText(value == null ? "" : "show");
        
        return this.button;
    }

}
