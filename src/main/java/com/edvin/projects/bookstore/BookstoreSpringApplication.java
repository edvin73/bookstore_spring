package com.edvin.projects.bookstore;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class BookstoreSpringApplication {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(BookstoreSpringApplication.class);
		
		app.setBanner(new Banner() {
			@Override
			public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
				out.println("Welcome to the Bookstore Application!");
			}
		});
		
		
		
		app.run(BookstoreSpringApplication.class, args);
	}

}
