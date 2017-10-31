package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ConfigBean;
import com.example.demo.User;

@RestController
public class LucyController {
	@Autowired
	ConfigBean configBean;

	@RequestMapping(value = "/lucy")
	public String miya() {
		return configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean.getUuid() + " >>>>"
				+ configBean.getMax();
	}

	@Autowired
	//@wjw_note: 注意这种方式创建的实例其实是Spring通过CGLib增强的类,序列化时要特别注意!
	User user;

	@RequestMapping(value = "/user")
	public String user() {
		return user.getName() + user.getAge();
	}

	@RequestMapping(value = "/user2")
	public User user2() {
		//@wjw_note: 不能直接使用自动注入的user,那种方式创建的实例其实是Spring通过CGLib增强的类,序列化时要特别注意!
		User uu = new User();
		uu.setName(user.getName());
		uu.setAge(user.getAge());
		return uu;
	}

}
