package com.arun.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableElasticsearchRepositories(basePackages = "com.arun.app.repository")
public class AppConfig {
	
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
