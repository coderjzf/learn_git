package com.jzf.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jzf.service.UserServiceImpl;

public class Test {
	private UserDaoImpl userDaoImpl;
	private UserServiceImpl userServiceImpl;
	
	
	@Autowired
	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}


	@Autowired
	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}



	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:application-transaction.xml");
		Test test = new Test();
		System.out.println(test.userServiceImpl);
	}
}
