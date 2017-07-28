package com.jzf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.dao.UserDao;
import com.jzf.model.User;

@Service
public class UserService {
	private UserDao userDao;
	
	
	public User selectUserById(int id){
		return userDao.selectUserById(id);
	}
	
	public void createUser(User user){
		userDao.createUser(user);
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
