package com.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.db.Db;
import com.db.Session;
import com.entity.Record;
import com.entity.User;
import com.gui.RegisterGUI;
import com.service.UserService;

class UserServiceTest {

	@BeforeEach 
	public void testRegister() {
		Db.readFromFile();
		try {
			User user=Session.getUserById("563");		
			new UserService().deleteUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		String id="563";
		String name="Jerry";
		String email="jerry@gmail.com";
		
		User user=new UserService().register(id, name, email, new RegisterGUI());
		
		assertEquals(user.getId(), id);
		assertEquals(user.getName(), name);
		assertEquals(user.getEmail(), email);
	
	}
	
	@Test
	public void testCalAccuTime() {
		User user=Session.getUserById("563");
		
		Record record1=null;
		Record record2=null;
		try {
			record1=new Record ();
			record1.startStation="A";
			record1.setStart();
			Thread.sleep(2000);
			record1.endStation="B";
			record1.setEnd();
			
			record2=new Record ();
			record2.startStation="A";
			record2.setStart();
			Thread.sleep(1000);
			record1.endStation="B";
			record2.setEnd();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		user.getRecords().add(record1);
		user.getRecords().add(record2);
		long accuTime=UserService.getTotalAccuTime(user);
		assertEquals(accuTime, 3);
	}
	
	
	
	@AfterEach
	public void testDelete() {
		
		User user=Session.getUserById("563");
		
		new UserService().deleteUser(user);
	}

}
