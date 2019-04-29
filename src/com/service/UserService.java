package com.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.db.Session;
import com.entity.PayFineState;
import com.entity.Record;
import com.entity.User;
import com.gui.PayFineGUI;
import com.gui.RegisterGUI;

public class UserService {
	public void register(String id,String name,String email,RegisterGUI registerGUI ) {
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setUsingScooter(false);
		u.setUnpaidFineFine(0);
		Session.users.add(u);
		JOptionPane.showMessageDialog(null,"Registeration successful!", 
				"Registeration successful",JOptionPane.WARNING_MESSAGE);
		registerGUI.setVisible(false);
	}
	
	
	
	public void payFine(String id,PayFineGUI payFineGUI) {
		if(id.trim().equals("")) {
			return;
		}
		
		Session.currentUser=Session.getUserById(id);
		if(Session.currentUser==null) {//未注册
			JOptionPane.showMessageDialog(null,"Please register Scooter system first!", 
					"Not yet register",JOptionPane.WARNING_MESSAGE);
		 
			payFineGUI.switchTo(PayFineState.BLANK);
			return;
		}
		
		payFineGUI.switchTo(PayFineState.HAVESWIPED);
		
		if(Session.currentUser.getUnpaidFineFine()<=0) {//不欠罚金
			JOptionPane.showMessageDialog(null,"You don't have unpaid fine", 
					"No unpaid fine ",JOptionPane.WARNING_MESSAGE);
			payFineGUI.switchTo(PayFineState.BLANK);
		}else {//欠罚金
			payFineGUI.pPayFine.setVisible(true);
		}
		
		
	}
	
	
	//计算本次使用结束后会不会累计超时
	public static void checkTodayAccumOvertime(User user ,Date today) {		
		
		ArrayList<Record> records= (ArrayList<Record>)user.getRecords().clone();
		
			long onDayAccuSec=0;
			SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
			int i=records.size()-1;
			while(fmt.format(today)//find today record
					.equals(fmt.format(records.get(i).getEndTime()))){
						
				onDayAccuSec+=records.get(i).durSec;
				i--;
				if(i<0) break;
			}	
			
			System.out.println("onDayAccuSec:"+onDayAccuSec);
			if(onDayAccuSec>2*60*60) {
				user.setUnpaidFineFine(100);
			}
		
	}
}
