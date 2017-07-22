package com.weight.monitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
	
	public static ApplicationContext ctx;

	public static void main(String[] args) {
		
		/* run method performs the following things under the hood:
		 * creates the spring container to run the application in its own container
		 * sets up default configuration 
		 * starts spring application context (spring container)
		 * performs class path scan - plug in code by annotating classes with controller/service markers
		 * start tomcat server
		 */
		 ctx = SpringApplication.run(Main.class, args);
		
		
	}

}
