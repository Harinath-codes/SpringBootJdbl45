package com.example.api.thfeb.demoapi4thfeb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	
	
	@GetMapping("/getNotificationMsg")
	public String getNotified() {
		
	 System.out.print("Error details1.......................");
	 System.out.print("Error details2.......................");
	 System.out.print("Error details3.......................");
	 System.out.print("Error details4.......................");
	 
		logger.error("This is error log"); //1 line persec per user
		logger.warn("This is warn log"); //10 line persec per user
		logger.info("This is info log"); //100 line persec per user
		logger.debug("This is debug log"); //350 line persec per user
		logger.trace("This is trace log"); //1000 line persec per user
		
		return "Hi ";
	}
	
	// dev ---- developer 10 user
	//tst - qa - testing team - 5 user
	// stg --- uat --- 2 user
	//prod --- prod most stable env  
	
	
	
	//zomato
	//dev --- 20 user
	//staging - 10k
	//prod --- 10crore if log level is set to trace 50gb log data we can not go for this . go for info or warn logs
	
	
	
	
	
	
}
