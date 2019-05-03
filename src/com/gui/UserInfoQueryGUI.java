package com.gui;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.gui.panel.DelButtonEditor;
import com.gui.panel.DelButtonRender;
import com.gui.panel.ShowButtonEditor;
import com.gui.panel.ShowButtonRender;
import com.model.UserTableModel;
import com.service.UserService;

public class UserInfoQueryGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scroll;
	private JLabel lblNewLabel;
    

	/**
	 * Create the frame.
	 */
	public UserInfoQueryGUI() {
		super("Personal Usage");
		setTitle("User Information");
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
        scroll.setSize(923, 300);
        
        lblNewLabel = new JLabel("User Information");
        lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 30));
        lblNewLabel.setBounds(331, 28, 274, 50);
        contentPane.add(lblNewLabel);
        table.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 15));
        
        JButton btnSendEmail = new JButton("send weekly usage");
        btnSendEmail.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		UserService.writeEmails();
        	}
        });
        btnSendEmail.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 23));
        btnSendEmail.setBounds(87, 495, 256, 47);
        contentPane.add(btnSendEmail);
        this.table.getColumnModel().getColumn(2).setPreferredWidth(130);
        
        this.table.getColumnModel().getColumn(8).setCellEditor(new ShowButtonEditor());  
        this.table.getColumnModel().getColumn(8).setCellRenderer(new ShowButtonRender());  
        this.table.getColumnModel().getColumn(9).setCellEditor(new DelButtonEditor());  
        this.table.getColumnModel().getColumn(9).setCellRenderer(new DelButtonRender());
        
//        this.table.setRowSelectionAllowed(false);
	}
	
	
	 
}
