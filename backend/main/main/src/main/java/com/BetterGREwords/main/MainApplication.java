package com.BetterGREwords.main;

import com.BetterGREwords.model.WordList;
import com.BetterGREwords.service.UserService;
import com.BetterGREwords.service.WordListService;
import com.BetterGREwords.utils.GREWordsScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.BetterGREwords")
@ComponentScan(basePackages = "com.BetterGREwords")
@EnableJpaRepositories(basePackages = "com.bettergrewords.repository")
@EntityScan(basePackages = "com.bettergrewords")
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MainApplication.class, args);
		WordListService wordListService = context.getBean(WordListService.class);
		for(int i=1; i<=154;i++){
			wordListService.createWordList(1,i,"154GREWords");
		}
	}

}
