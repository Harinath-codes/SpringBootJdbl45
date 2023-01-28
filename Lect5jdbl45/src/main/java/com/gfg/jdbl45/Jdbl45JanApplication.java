package com.gfg.jdbl45;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jdbl45JanApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jdbl45JanApplication.class, args);
		
		// maven phases
		//clean - will delted the target folder 
				//validate 
				//compile - will create byte code for the code in mainfolder 
				//test - mvn test - it runs only in test folder 
				//package - it creates the jar file of the project and add it to target folder 
				// install - mvn install - has responsibilty to copy the jar to local repo
				
				
				//all of the above phase will run sequential - 
	}

}
