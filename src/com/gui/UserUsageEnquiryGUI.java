package com.gui;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Component;  
import java.awt.FlowLayout;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
import java.util.EventObject;  
  
import javax.swing.DefaultCellEditor;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JOptionPane;  
import javax.swing.JPanel;  
import javax.swing.JTable;  
import javax.swing.JTextField;  
import javax.swing.UIManager;  
import javax.swing.table.DefaultTableModel;  
import javax.swing.table.TableCellRenderer;  
public class UserUsageEnquiryGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JScrollPane scroll;
	Object[][] cells;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUsageEnquiryGUI frame = new UserUsageEnquiryGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserUsageEnquiryGUI() {
		setTitle("User Usage Enquiry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton lblSerchById = new JButton("serch by ID");
		panel.add(lblSerchById);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		String[] columnNames =  
	        { "ID", "name","E-mail","this time usage(minutes)", "today usage(minutes)", "this week usage(minutes)","total usage(minutes)", "show detail" };
		Object[][] cells = { { "", "Bob", "12345@qq.com", "5","30","350" ,"800","check out"},{ "", "Bob", "12345@qq.com", "5","30","350" ,"800","check out"} };
		table = new JTable(cells,columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.getColumn("show detail").setCellRenderer(new ButtonRenderer());
		table.getColumn("show detail").setCellEditor(new ButtonEditor(new JTextField()));
	    panel_1.setLayout(new BorderLayout(0, 0));
	    scroll = new JScrollPane(table);  
        scroll.setSize(300, 200);
        panel_1.add(scroll);
	}

}
class ButtonEditor extends DefaultCellEditor {  
	  
    protected JButton button;  
    private String label;  
    private boolean isPushed;  
    Object[][] cells = { { "", "Bob", "12345@qq.com", "5","30","350" ,"800","check out"},{ "", "Bob", "12345@qq.com", "5","30","350" ,"800","check out"} };
  
    public ButtonEditor(JTextField checkBox) {  
        super(checkBox);  
        this.setClickCountToStart(1);  
        button = new JButton();  
        button.setOpaque(true);  
        button.addActionListener(new ActionListener() {  
  
            public void actionPerformed(ActionEvent e) {  
                fireEditingStopped();  
            }  
        });  
  
    }  
  
    public Component getTableCellEditorComponent(final JTable table, Object value,  
            boolean isSelected,int row, int column) {  
        if (isSelected) {  
            button.setForeground(table.getSelectionForeground());  
            button.setBackground(table.getSelectionBackground());  
        } else {  
            button.setForeground(table.getForeground());  
            button.setBackground(table.getBackground());  
        }  
        label = (value == null) ? "" : value.toString();  
        button.setText(label);  
        button.addActionListener(new ActionListener() {  
  
            @Override  
            public void actionPerformed(ActionEvent e) {  
                System.out.println(table.getSelectedRow()) ;  
                System.out.println(table.getSelectedColumn()) ;  
                System.out.println(cells[table.getSelectedRow()][table.getSelectedColumn()-6]) ; 
            }  
        });  
        isPushed = true;  
        return button;  
    }  
  
    public Object getCellEditorValue() {  
        if (isPushed) {  
            //   
            //   
           // JOptionPane.showMessageDialog(button, label + ": Ouch!");  
            // System.out.println(label + ": Ouch!");  
        }  
        isPushed = false;  
        return new String(label);  
    }  
  
    public boolean stopCellEditing() {  
        isPushed = false;  
        return super.stopCellEditing();  
    }  
  
    @Override  
    public boolean shouldSelectCell(EventObject anEvent) {  
        System.out.println(1);  
        return super.shouldSelectCell(anEvent);  
    }  
      
      

}  
  
class ButtonRenderer extends JButton implements TableCellRenderer {  
  
    public ButtonRenderer() {  
        setOpaque(true);  
    }  
  
    public Component getTableCellRendererComponent(JTable table, Object value,  
            boolean isSelected, boolean hasFocus, int row, int column) {  
        if (isSelected) {  
            setForeground(table.getSelectionForeground());  
            setBackground(table.getSelectionBackground());  
        } else {  
            setForeground(table.getForeground());  
            setBackground(UIManager.getColor("UIManager"));  
        }  
        setText((value == null) ? "" : value.toString());  
        return this;  
    }  
}  
