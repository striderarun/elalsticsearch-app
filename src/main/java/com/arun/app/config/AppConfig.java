package com.arun.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@ComponentScan(basePackages = "com.arun.app")
@EnableElasticsearchRepositories(basePackages = "com.arun.app.repository")
@EnableAutoConfiguration
public class AppConfig {

	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args);
	}
}
