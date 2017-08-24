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
@ContextConfiguration(locations="application-transaction.xml")
public class UserServiceTest {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Before
	public void setUp() throws Exception {
		
	} 

	@Test
	public void test() {
		userServiceImpl.selectUserById(1);
	}
	
}
