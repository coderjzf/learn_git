package com.jzf.test;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jzf.dao.UserDaoImpl;
import com.jzf.domain.User;
import com.jzf.service.UserServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:application-transaction.xml"})
public class UserServiceTest {
	@Autowired
	private UserServiceImpl userServiceImpl;	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void test() {
		List<User> users = new ArrayList<>();
		User user = new User("ZHANG_TING","222333");
		user.setId(20);
		
		User user2 = new User("JIA_ZHENGFENG_FENG","333333");
		user2.setId(21);
		
		User user3 = new User("XIAO_HU","555555");
		user3.setId(22);
		
		User user4 = new User("XIAO_FAN","444466");
		user4.setId(23);
		
		users.add(user);
		users.add(user2);
		users.add(user3);
		users.add(user4);

		userServiceImpl.updateUsers(users);
	}
	
}
