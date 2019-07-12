package com.mbms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan({ "com.mbms" })
public class Main {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(Main.class, args);
		
		applicationContext.close();
	}

}
