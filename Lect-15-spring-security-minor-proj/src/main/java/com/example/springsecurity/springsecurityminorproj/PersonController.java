package com.example.springsecurity.springsecurityminorproj;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	// all the api are secure by default when we add spring security
	// if you want to unsecure an api in that case you will have to specify

	@GetMapping("/getName")
	public String greetPerson(@RequestParam("userName") String userName) {

	//	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("Example from a" + user.getUsername());
		return "Hi User!!!!!";
	}

	@GetMapping("/demo")
	public String greet() {
		return "Hi User!!";
	}

	@GetMapping("/devops")
	public String greetDevops() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Hi Devops " + user.getUsername() + "!!!";
	}

	@GetMapping("/developer")
	public String greetDeveloper() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return "Hi Developer " + user.getUsername() + "!!!";
	}

	@PostMapping("/developer")
	public void createDeveloper() {

	}

}
