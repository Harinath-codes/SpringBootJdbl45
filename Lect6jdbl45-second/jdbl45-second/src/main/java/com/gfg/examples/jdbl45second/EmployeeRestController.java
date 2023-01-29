package com.gfg.examples.jdbl45second;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeRestController {

	
	//make an api 
	//method -----
	//GET-----> this method is used to retrieve some response from the Backend.
	//Post ----> is used to save/store some data to backend
	//Put ---> used to update the details on backend.
	//DELETE ---> it is used to delete some data on backend.
	// all the above are http methods 
	
	// Http get is a safe method -> if some method get executed partially it will not impact so its safe. consistent data
	//Http post is unsafe method -> it will impact so its not safe. not consistent if code paritally excutes.
	
	//request
	//response
	
	
	// how many types of API  are there 
	//REST
	//SOAP
	
	
	//@GetMapping("/greetPerson")
	@RequestMapping(value="/greetPersonGet",method=RequestMethod.GET)
	public String myMessageNotifications() {
		return "Hi There everyone : Get";
	}
	
	@RequestMapping(value="/greetPersonPost",method=RequestMethod.POST)
	public String postMessage() {
		return "Hi There everyone: Post";
	}
	
	@RequestMapping(value="/greetPersonPut",method=RequestMethod.PUT)
	public String getName() {
		return "Hi There everyone: Put";
	
	
	}
	
	//Requestparam 
	//pathvariable 
	
	
	
	

}
