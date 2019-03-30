package com.entity;

import java.util.Date;

public class Record {
	public Date startTime;
	public Date endTime;
	public String startStation;
	public String endStation;
	
	public long durHour;
	public long durMin;
	public long durSec;
	public long day;
	public long hour;
	public long min;
	public long sec;
	

	private void calculateDuration() {
		long dur=endTime.getTime()-startTime.getTime();
		
		
		 day = dur / (24 * 60 * 60 * 1000);
		 hour = (dur / (60 * 60 * 1000) - day * 24);
		 min = ((dur / (60 * 1000)) - day * 24 * 60 - hour * 60);
		 sec = (dur / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
		
		durHour= (dur / (1000 * 60 * 60));
		durMin= (dur / (1000 * 60 ));
		durSec=(dur / (1000 ));
		
	}
	
	
	
	public String getStartStation() {
		return startStation;
	}




	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}




	public String getEndStation() {
		return endStation;
	}




	public void setEndStation(String endStation) {
		this.endStation = endStation;
	}

	public Date getStartTime() {
		return startTime;
	}
	public void setStart() {
		this.startTime = new Date();
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEnd() {
		this.endTime = new Date();
		calculateDuration();
	}






	
}
