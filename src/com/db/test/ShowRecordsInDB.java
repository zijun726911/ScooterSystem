package com.db.test;

import java.util.List;

import com.db.Db;
import com.db.Session;
import com.entity.Record;
import com.entity.User;

public class ShowRecordsInDB {
	public static void main(String[] args) {
		Db.readFromFile();
		
		User u=Session.getUserById("123");
		List<Record> records=u.getRecords();
		records.forEach(record->{System.out.println(record);});
	}
}
