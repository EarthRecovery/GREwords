package com.BetterGREwords.main;

import com.BetterGREwords.model.UserWordProgress;
import com.BetterGREwords.model.WordList;
import com.BetterGREwords.model.Words;
import com.BetterGREwords.service.*;
import com.BetterGREwords.utils.GREWordsScraper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.BetterGREwords")
@ComponentScan(basePackages = "com.BetterGREwords")
@EnableJpaRepositories(basePackages = "com.bettergrewords.repository")
@EntityScan(basePackages = "com.bettergrewords")
public class MainApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(MainApplication.class, args);
//		ReciteService reciteService = context.getBean(ReciteService.class);
//		List<Words> words = reciteService.getReciteWords(1);
//		for (Words word : words) {
//			System.out.println(word.getWordName());
//		}
	}

}
