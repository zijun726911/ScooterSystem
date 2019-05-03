package com.gui;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.db.Session;
import com.entity.User;
import com.gui.panel.PayFinePanel;
import com.gui.panel.PersonInfoPanel;
import com.gui.panel.StationInfoPanel;
import com.model.PayFineState;
import com.service.UserService;
import javax.swing.JSeparator;

public class PayFineGUI extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public PersonInfoPanel pPersonInfo;
	public PayFinePanel pPayFine;
	
	
	public StationInfoPanel pStationInfo ;
	
	private JButton btnYes;
	private JLabel lblNewLabel_1;
	private JButton btnNo;
	private PayFineState state;
	
	
	
	
	public PayFineGUI() throws IOException {
				
		
		setTitle("Fine Payment");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 829, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pPayFine = new PayFinePanel();
		pPayFine.setVisible(false);
		pPayFine.setBounds(0, 300, 807, 151);
		contentPane.add(pPayFine);
		pPayFine.setLayout(null);
		
		btnYes = new JButton("Yes");
		btnYes.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnYes.setBounds(238, 88, 105, 34);
		btnYes.addActionListener((e)->{
			Session.currentUser.setUnpaidFineFine(0);
			this.switchTo(PayFineState.HAVESWIPED);
			JOptionPane.showMessageDialog(null,"Pay Success!", 
					"Pay Success",JOptionPane.PLAIN_MESSAGE);
			this.switchTo(PayFineState.BLANK);
		});
		
		pPayFine.add(btnYes);
		
		lblNewLabel_1 = new JLabel("Would you like to pay \uFFE1100 fine immediately?");
		lblNewLabel_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(107, 26, 611, 34);
		pPayFine.add(lblNewLabel_1);
		
		btnNo = new JButton("No");
		btnNo.addActionListener((e)->{
			this.switchTo(PayFineState.BLANK);
		});
		
		btnNo.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		btnNo.setBounds(453, 88, 105, 34);
		pPayFine.add(btnNo);
		
		pPersonInfo = new PersonInfoPanel();
		pPersonInfo.setBounds(0, 110, 807, 188);
		contentPane.add(pPersonInfo);
		pPersonInfo.setLayout(null);
		pPersonInfo.setVisible(true);
		pPersonInfo.simulSwipCard.addActionListener((e)->{	
			String userId=pPersonInfo.jtfinputId.getText();
			if(state==PayFineState.BLANK) {
				new UserService().payFine(userId,PayFineGUI.this);
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 187, 807, 13);
		pPersonInfo.add(separator);
		
		JLabel lblNewLabel = new JLabel("Fine Payment");
		lblNewLabel.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 35));
		lblNewLabel.setBounds(285, 25, 249, 50);
		contentPane.add(lblNewLabel);
		
		
		this.switchTo(PayFineState.BLANK);
		
	}
	
	
	
	
	
	public void switchTo(PayFineState state) {
		this.state=state;
//		this.contentPane.updateUI();
		
		User currentUser=Session.currentUser;
		
		switch (state) {
		
		
			case BLANK:
				
				pPayFine.setVisible(false);
				pPersonInfo.lbId.setText("");
				pPersonInfo.lbName.setText("");
				pPersonInfo.lbEmail.setText("");
				pPersonInfo.lbFine.setText("");
				pPersonInfo.jtfinputId.setText("");
				break;
								
				
			case HAVESWIPED:
				
				
				
				pPersonInfo.lbId.setText(currentUser.getId());
				pPersonInfo.lbName.setText(currentUser.getName());
				pPersonInfo.lbEmail.setText(currentUser.getEmail());
				pPersonInfo.lbFine.setText("\uFFE1 "+currentUser.getUnpaidFineFine());
				pPersonInfo.jtfinputId.setText(currentUser.getId());
				break;
		
			
		}	
		
	}
}


