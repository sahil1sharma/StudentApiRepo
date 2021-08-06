package com.trantor.springbootassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The SpringBootAssignmentApplication class acts as the launching point for
 * application.
 * 
 * @author Sahil Sharma
 * 
 */
@SpringBootApplication
@EnableWebMvc
@EnableSwagger2
public class SpringBootAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignmentApplication.class, args);
	}

}
