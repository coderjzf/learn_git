package com.jzf.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jzf.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("application-transactional.xml")
public class UserServiceTest {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
//		User user = new User("ZHAO_KEKE","66666");
//		User user2 = userServiceImpl.selectUserById(1);
//		System.out.println(user2);
		userServiceImpl.selectUserById(1);
	}
	
}
