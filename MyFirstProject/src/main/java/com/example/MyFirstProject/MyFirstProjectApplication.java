package com.example.MyFirstProject;

import com.example.MyFirstProject.Utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstProjectApplication {
	private static final Logger logger= LoggerFactory.getLogger(MyFirstProjectApplication.class);
	public static void main(String[] args) {

		SpringApplication.run(MyFirstProjectApplication.class, args);
		logger.info(Constants.START);
	}

}
