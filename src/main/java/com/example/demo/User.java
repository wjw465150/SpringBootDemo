package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


//@wjw_note: 注意这种方式创建的实例其实是Spring通过CGLib增强的类,序列化时要特别注意!
@Configuration
@PropertySource(value = "classpath:user.properties")  //@wjw 指定属性文件位置.To be used in conjunction with @Configuration. 

@ConfigurationProperties(prefix = "com.forezp")  //@wjw 从属性文件自动注入属性
public class User {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
