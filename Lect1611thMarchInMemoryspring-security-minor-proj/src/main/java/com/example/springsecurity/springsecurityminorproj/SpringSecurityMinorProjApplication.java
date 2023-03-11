package com.example.springsecurity.springsecurityminorproj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringSecurityMinorProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityMinorProjApplication.class, args);
		BCryptPasswordEncoder obj = new BCryptPasswordEncoder();
		System.out.println(obj.encode("jim123"));
		System.out.println(obj.encode("john123"));
		System.out.println(obj.encode("catalina123"));
		

	}
	
	
	// this encoded pass generate few min back
	// $2a$10$zX4OnByHjr3hSkdJo6pzZu9dta68ClMXDMTVeCs/oWEBUg4rXxMYu
	// $2a$10$T/K2r6TTQ8jtr4amf7YHn.gFHMnLSK3ZyZrxoy4h7jTBpAbxxFdYe
	// $2a$10$toRdoofYzUS7qFE2vMowqOYA14T4hTLA3IsBCW1xiPqrE2E6gidCO
	
	
//	$2a$10$sEQSXh.2OppqBxKFcs/Z2exRzWhEhZrsrbx67U3q1k/dPAujzwZim
//	$2a$10$XTaULUvlgDIATy/Dsq4i2.B7Q2z.zE8cxe8Kp/X7RF4DG05NwJH7q
//	$2a$10$1At3tvTImmokZbritm58R.Bi61Ou4klXrJ./Sf/j7TchSTVGZtVl2
	
	
	// exmaple -----> 1.2.3
	//1 ==time
	//2 == data
	//3 == salt
	
	
	

}
