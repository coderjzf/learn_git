package com.jzf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jzf.dao.UserDaoImpl;
import com.jzf.domain.User;

@Service
@Transactional
public class UserServiceImpl {
	
	private UserDaoImpl userDao;
	
	public void createTable() {
		userDao.createTable();
	}
	
	@Transactional(readOnly=true)	
	public User selectUserById(int id) {
		return userDao.selectUserById(id);
	}
	
	@Transactional(readOnly=true)
	public User selectUserByUserName(String username){
		return userDao.selectUserByUserName(username);
	}

	public List<User> selectUsersWithRowCallbackHandler(int id){
		return userDao.selectUsersWithRowCallbackHandler(id);
	}
	
	public List<User> selectUsersWithRowMapper(int id){
		return userDao.selectUsersWithRowMapper(id);
	}
	
	public void addUser(User user){
		userDao.addUser(user);
	}
	
	public void addUsers(List<User> users){
		userDao.addUsers(users);
	}
	
	public void deleteUserById(int id){
		userDao.deleteUserById(id);
	}
	
	public void updateUsers(List<User> users){
		userDao.updateUsers(users);
	}
	
	public void updateUser(User user){
		userDao.updateUser(user);
	}
	
	@Autowired
	public void setUserDao(UserDaoImpl userDao) {
		this.userDao = userDao;
	}

}
