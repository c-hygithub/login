package com.itcast.service;

import com.itcast.entity.User;

public interface Service {
	public User login(User user);
	public void add(User user);
}
