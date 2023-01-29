package com.gfg.examples.jdbl45second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Jdbl45SecondApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jdbl45SecondApplication.class, args);
		System.out.println("Here to play the game of life");
		//server - a program running for infinite amount of time 
		//it takes user request and returns some response.
		
		//spring boot is a server --- no
		//spring boot is a framework that contains embedded server and also contains code to start the embedded server
		//tomcat , jetty is server ---- yes
		
		
		//springboot- an enhancement on the top of spring framework 
				// feature to autoconfigure
			   // we can write or create objects using annaotation		
		
		
	}

}
