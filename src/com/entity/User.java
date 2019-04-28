package com.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.db.Session;

public class User implements Serializable{
	
	private boolean usingScooter;
	private String id;
	private String name;
	private String email;
	private int unpaidFine;
	private ArrayList<Record> records;
	private ScooterTimerTask usingTimeout; 
	
	
	public void checkOvertime() {
//		judge single overtiome
		for(Record r:records) {
			if(r.durMin>30) {
				unpaidFine=100;
				return;
			}
			
		}
		
		
		//judge accumulated overtime
		
		ArrayList<Record> recordsClone= (ArrayList<Record>)records.clone();
		for(int i=0;i< recordsClone.size();i++) {
			long onDayAccusec=recordsClone.get(i).durSec;
			for(int j=i+1;j< recordsClone.size();j++) {
				SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
				if( fmt.format(recordsClone.get(i).getEndTime())//two record in the same time
						.equals(fmt.format(recordsClone.get(j).getEndTime()))){
					onDayAccusec+=recordsClone.get(j).durSec;
					recordsClone.remove(j);
				}	
			}
			
			if(onDayAccusec>2*60*60) {
				unpaidFine=100;
				return;
			}
		}
	}
	
	
	public void startTimer() {
		Timer timer = Session.userTimer;
        timer.schedule(usingTimeout, 30*60*1000);//execute timeout after 30min 
        
	}
	
	public void stopTimer() {
		usingTimeout.cancel();
		usingTimeout=new ScooterTimerTask();
	}
	
	class ScooterTimerTask extends TimerTask implements Serializable {   
        
	    @Override   
	    public void run() {   
	         User.this.unpaidFine=100;
	         
	   
	    }   
	}   
	
	
	public User() {
		records=new ArrayList<Record>();
		usingTimeout=new ScooterTimerTask();
	}
	public ArrayList<Record> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<Record> records) {
		this.records = records;
	}

	public void setUsingScooter(boolean usingScooter) {
		this.usingScooter = usingScooter;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public int getUnpaidFineFine() {
		return unpaidFine;
	}

	public void setUnpaidFineFine(int unpaidFineFine) {
		this.unpaidFine = unpaidFineFine;
	}

	public boolean isUsingScooter() {
		return usingScooter;
	}
	
	
	
}
