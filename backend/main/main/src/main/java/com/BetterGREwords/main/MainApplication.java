package com.BetterGREwords.main;

import com.BetterGREwords.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.BetterGREwords")
@EnableJpaRepositories(basePackages = "com.bettergrewords.repository")
@EntityScan(basePackages = "com.bettergrewords.model")
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MainApplication.class, args);

		UserService userService = context.getBean(UserService.class);
		userService.deleteUserByUsername("admintest");
		userService.createUser("admintest", "admin@test.cn","password_hash");
		System.out.println(userService.findByUsername("admintest").getEmail());
	}

}
