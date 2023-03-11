package com.example.jbdl.demosecuritydb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Value("${user.authority.developer}")
    private String DEVELOPER_AUTHORITY;

    @Value("${user.authority.devops}")
    private String DEVOPS_AUTHORITY;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/demo")
    public String greet(){
        return "Hi User!!";
    }

    @GetMapping("/devops")
    public String greetDevops(){
        MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi Devops " + user.getUsername() + "!!!";
    }

    @GetMapping("/developer")
    public String greetDeveloper(){
        MyUser user = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "Hi Developer " + user.getUsername() + "!!!";
    }
    
    
    
    @PostMapping("/signUp")
    public MyUser createNewUser(@Valid @RequestBody UserCreateRequest userDetails) {
    
    	MyUser user = MyUser.builder()
    						.username(userDetails.getUsername())
    						.password(passwordEncoder.encode(userDetails.getPassword()))
    						.authorities(userDetails.getIsDeveloper() ? DEVELOPER_AUTHORITY : DEVOPS_AUTHORITY)
    						.build();
    	
    	return userService.createUser(user);
    	
    	
    }
    
 
  

}
