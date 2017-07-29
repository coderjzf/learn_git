package com.jzf.service;

import com.jzf.domain.User;

public interface UserService {
	public User selectUserById(int id);
	
	public void createTable();
}
