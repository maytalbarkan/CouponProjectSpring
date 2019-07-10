package com.mbms.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com.mbms.test" })
public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
		
		
	}

}
