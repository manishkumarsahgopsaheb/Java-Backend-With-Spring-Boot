package com.example.DemoApp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApp1Application {

	public static void main(String[] args) {

		SpringApplication.run(DemoApp1Application.class, args);

		System.out.println("Hi Spring");
	}

}
