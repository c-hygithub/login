package com.itcast.service;

import com.itcast.dao.DaoImp;
import com.itcast.entity.User;

public class ServiceImp implements Service {

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		
		return new DaoImp().findUser(user);
	}

	public void add(User user) {
		// TODO Auto-generated method stub
		
		new DaoImp().add(user);
	}

	



}
