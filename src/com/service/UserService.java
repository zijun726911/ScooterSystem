package com.service;

import com.db.Session;
import com.entity.User;

public class UserService {
	public void register(String id,String name,String email) {
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setUsingScooter(false);
		u.setUnpaidFineFine(0);
		Session.users.add(u);
		
	}
}
