package com.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import com.db.Db;
import com.db.Session;
import com.entity.Record;
import com.entity.User;
import com.gui.PayFineGUI;
import com.gui.RegisterGUI;
import com.model.PayFineState;
import com.utils.ConsoleTable;
import com.utils.TimeUtil;

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
		new Db().writeToFile();
	}
	
	public void delete(int index) {
		Session.users.remove(index);
		new Db().writeToFile();
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
	//return today accumulation duration
	public static long getOneDayAccuTime(User user ,Date today) {		
		
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
			
//			System.out.println("onDayAccuSec:"+onDayAccuSec);
			if(onDayAccuSec>2*60*60) {
				user.setUnpaidFineFine(100);
			}
			
			
			return onDayAccuSec;
		
	}
	
	
	public static long getThisWeekAccuTime(User user) {		
		long oneWeekAccuSec=0;
		
		ArrayList<Record> records= (ArrayList<Record>)user
				.getRecords().clone();
		Date today=records.get(records.size()-1).endTime;
		
		for(int i=records.size()-1;i>=0;i--) {
			Record record=records.get(i);
			
			if(TimeUtil.isSameWeek(today,record.endTime )) {
				oneWeekAccuSec+=record.durSec;
				
			}
			else {
				
				break;
			}
			
		}

		return oneWeekAccuSec;
	}
	
	
	public static long getTotalAccuTime(User user) {
		long totalAccuSec=0;
		ArrayList<Record> records= user.getRecords();
//		Date today=records.get(records.size()-1).endTime;
		
		for(int i=0;i<records.size();i++) {
			Record record=records.get(i);
			
			
			totalAccuSec+=record.durSec;
				
		}

		return totalAccuSec;
	}
	
	public static void writeEmails() {
		String path="email usage\\";
		File dir=new File(path);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		for(User user:Session.users) {
			try {
				
					writeOneEmail(user,path);
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void writeOneEmail(User user,String path) throws IOException  {
		ArrayList<Record> records= user.getRecords();
		
		Date today=new Date();
		
		
		String fileName=""+user.getName()+"_week_"+TimeUtil.getWeek(today)+".txt";
		
		BufferedWriter bw=new BufferedWriter(
        		new FileWriter(path+fileName));
		StringBuilder text=new StringBuilder();
		bw.write("Dear  "+user.getName()+", information "
				+ "below is your last week scooter usage:\r\n\r\n");
		
		
		String[] columnNames =  
	        { "Start Time", "Start Position",
	        		"End Time", "End Position", "duration"}; 
		long oneWeekAccuSec=0;
		ArrayList<String[]> content=new ArrayList<String[]>();
		for(int i=records.size()-1;i>=0;i--) {
			Record record=records.get(i);
			
			if(TimeUtil.isSameWeek(today,record.endTime )) {
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String startTime=format.format(record.getStartTime());
		        String startSt=record.startStation;
		        String endTime="";
		        String endSt="";
		        String dur="";
				if(record.endStation!=null) {
					 endTime=format.format(record.getEndTime());
					 endSt=record.endStation;
					 dur=TimeUtil.secToTime((int)record.durSec);
				}
							
				content.add(new String[]{startTime,startSt,endTime,endSt,dur});
				oneWeekAccuSec+=record.durSec;	
			}else break;
		
		}
		
        new ConsoleTable(content,columnNames,columnNames.length,false).print(bw);
        bw.newLine();
        bw.write("Unpaid fine: ￡"+user.getUnpaidFineFine());bw.newLine();
        bw.write("This week total usage: "+TimeUtil.secToTime((int)oneWeekAccuSec));bw.newLine();
        bw.flush();
        bw.close();
        
	}
	
	
	public void periodicallySendEmail(){
		
		Session.userTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Start periodically sending Email to all users");
				writeEmails();
			}
		},
		0,7*24*60*60*1000);
	}
}
