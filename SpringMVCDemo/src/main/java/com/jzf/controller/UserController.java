package com.jzf.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.jzf.model.User;
import com.jzf.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService;

	@RequestMapping()
	public ModelAndView createUser(User user) {
		userService.createUser(user);
		ModelAndView mav = new ModelAndView("user/success");
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping("/register")
	public String register() {
		return "user/register";
	}

	/**
	 * @PathVariable ��url·������ռλ������Ĳ����󶨵��������
	 */
	@RequestMapping("/userinfo/{id}")
	public ModelAndView getUser(@PathVariable("id") Integer id) {
		User user = userService.selectUserById(id);
		ModelAndView mav = new ModelAndView("user/success");
		mav.addObject("user", user);
		return mav;
	}
	
	

	/**
	 * ���������@ModelAttributeע��Ὣ��������ֵ��ӵ�ģ����(���ܼ�@RequestMappingע��)
	 */
	@ModelAttribute("user")
	public User handler2() {
		User user = new User();
		user.setUsername("jia_zheng_feng");
		user.setId(23333);
		return user;
	}

	@RequestMapping("/handler5")
	public String handler5(@ModelAttribute User user) {
		user.setPassword("2333333333333333333");
		return "redirect:handler6";
	}

	@RequestMapping("/handler6")
	public String handler6(ModelMap modelMap, @ModelAttribute User user) {
		user = (User) modelMap.get("user");
		if (user != null) {
			user.setUsername("handler6");
		}
		return "user/success";
	}

	/*	*//**
			 * ����ϵ�@ModelAttributeע��Ὣ��ζ�����ӵ�ģ����
			 * ��������ͼ��ģ�����ݽ�����Ⱦǰ�����Ὣģ�����ݴ洢����ͼ��������
			 * ����jsp��ͼ��˵���ͻὫģ�����ݴ洢��ServletRequest�������б���(������)
			 */

	/*
	 * @RequestMapping("/modelAttribute") public String
	 * handler3(@ModelAttribute("user") User user){
	 * user.setPassword("66666666"); return "user/success"; }
	 * 
	 *//**
		 * springmvc�ڵ��÷���֮ǰ�ᴴ��һ����ʽ��ģ�Ͷ�����Ϊ�洢ģ�����ݵĴ洢����
		 * ���������ΪMap����Model���ͣ���springmvc�Ὣģ�Ͷ�������ô��ݸ����
		 * �����Ϳ���ͨ����ν���ģ���л�ȡ���ݻ�����ģ�����������
		 *//*
		 * @RequestMapping("/modelMap") public String handler4(HashMap hashMap){
		 * hashMap.put("value", "22222222222"); User user = (User)
		 * hashMap.get("user"); user.setPassword("map?"); return "user/success";
		 * }
		 */
	@ResponseBody
	@RequestMapping("/{id}")
	public User handler7(@PathVariable("id") int id){
		return userService.selectUserById(id);
	}
	
	/*@RequestMapping("/{id}")
	public ResponseEntity<User> handler7(@PathVariable("id") int id){
		User user = userService.selectUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}*/
	
	@RequestMapping("/string")
	public String convertHandler(@RequestParam("user") User user,ModelMap modelMap){
		System.out.println(user);
		modelMap.addAttribute("user", user);
		return "user/success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}
