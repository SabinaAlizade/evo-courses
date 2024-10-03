package com.example.EvoCourses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EvoCoursesApplication {

	public static void main(String[] args) {
		SpringApplication.run(EvoCoursesApplication.class, args);
	}

}
