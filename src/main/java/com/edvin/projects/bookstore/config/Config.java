package com.edvin.projects.bookstore.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Config {
	
	private Logger logger = LoggerFactory.getLogger(Config.class);
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.profiles.active : prod}")
	private String activeProfile;
	
	@Bean
	@Profile("dev")
	String activeProfile() {
		logger.info("Active profile : {}", activeProfile);
		
		logger.info("Database URL: {}", dbUrl);
		
		
		
        return System.getProperty("spring.profiles.active", "dev");
    }
	
	@Bean(name = "ProdProfile")
	@Profile("prod")
	String prodProfile() {
		logger.info("Active profile : {}", System.getProperty("spring.profiles.active", "prod"));
		return System.getProperty("spring.profiles.active", "prod");
	}
	 
}
