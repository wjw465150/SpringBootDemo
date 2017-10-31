package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootApplication // @wjw 是Sprnig Boot项目的核心注解，主要目的是开启自动配置。
@EnableConfigurationProperties({ ConfigBean.class, User.class }) // 需要自动注入属性值的bean
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

//	@Bean
//	public ObjectMapper ObjectMapper() {
//		ObjectMapper objectMapper = new ObjectMapper();
//		// 忽略json字符串中不识别的属性
//		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		// 忽略无法转换的对象 “No serializer found for class com.xxx.xxx”
//		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
//		return objectMapper;
//	}
}
