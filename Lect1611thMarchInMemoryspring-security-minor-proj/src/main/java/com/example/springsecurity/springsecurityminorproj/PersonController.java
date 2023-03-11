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
