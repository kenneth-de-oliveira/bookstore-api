package com.kenneth.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.kenneth.bookstore.services.DBServiceToTest;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServiceToTest dbServiceToTest;

	@Bean
	public void executeInstaceDatabase() {
		this.dbServiceToTest.instaceDatabase();
	}

}
