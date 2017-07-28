package com.jzf.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jzf.model.User;
import com.jzf.service.UserService;

@SessionAttributes("user")
@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;
	
	@RequestMapping()
	public ModelAndView createUser(User user){
		userService.createUser(user);
		ModelAndView mav = new ModelAndView("user/success");
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/register")
	public String register(){
		return "user/register";
	}
	
	@RequestMapping("/userinfo/{id}")
	public ModelAndView getUser(@PathVariable("id") Integer id){
		User user = userService.selectUserById(id);
		ModelAndView mav = new ModelAndView("user/success");
		mav.addObject("user", user);
		return mav;
	}
	
	@RequestMapping("/handler/{id}")
	public @ResponseBody User handler(@PathVariable int id){
		
		return userService.selectUserById(id);
	}
	
	/**
	 * ���������@ModelAttributeע��Ὣ��������ֵ��ӵ�ģ����(���ܼ�@RequestMappingע��)
	 */
	@ModelAttribute("user")
	public User handler2(){
		User user = new User();
		user.setUsername("jia_zheng_feng");
		user.setId(23333);
		return user;
	}
	
	
	@RequestMapping("/handler5")
	public String handler5(@ModelAttribute User user){
		user.setPassword("2333333333333333333");
		return "redirect:handler6";
	}
	
	@RequestMapping("/handler6")
	public String handler6(ModelMap modelMap,@ModelAttribute User user){
		user = (User)modelMap.get("user");
		if(user!=null){
			user.setUsername("handler6");
		}
		return "user/success";
	}
	
	
/*	*//**
	 * ����ϵ�@ModelAttributeע��Ὣ��ζ�����ӵ�ģ����
	 * ��������ͼ��ģ�����ݽ�����Ⱦǰ�����Ὣģ�����ݴ洢����ͼ��������
	 * ����jsp��ͼ��˵���ͻὫģ�����ݴ洢��ServletRequest�������б���(������)
	 *//*
	@RequestMapping("/modelAttribute")
	public String handler3(@ModelAttribute("user") User user){
		user.setPassword("66666666");
		return "user/success";
	}
	
	*//**
	 * springmvc�ڵ��÷���֮ǰ�ᴴ��һ����ʽ��ģ�Ͷ�����Ϊ�洢ģ�����ݵĴ洢����
	 * ���������ΪMap����Model���ͣ���springmvc�Ὣģ�Ͷ�������ô��ݸ����
	 * �����Ϳ���ͨ����ν���ģ���л�ȡ���ݻ�����ģ�����������
	 *//*
	@RequestMapping("/modelMap")
	public String handler4(HashMap hashMap){
		hashMap.put("value", "22222222222");
		User user = (User) hashMap.get("user");
		user.setPassword("map?");
		return "user/success";
	}*/
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
