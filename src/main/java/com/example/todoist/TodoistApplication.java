package com.example.todoist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class TodoistApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TodoistApplication.class, args);
	}
}

