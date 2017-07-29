package com.jzf.dao;

import com.jzf.domain.User;

public interface UserDao {
	public void createTable();
	
	public User selectUserById(int id);
}
