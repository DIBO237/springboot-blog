package com.mongodbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MongodbtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbtestApplication.class, args);
	}

}
