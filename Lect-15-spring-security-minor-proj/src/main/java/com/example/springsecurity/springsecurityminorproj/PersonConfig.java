package com.example.springsecurity.springsecurityminorproj;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;



@Configuration
@EnableWebSecurity
public class PersonConfig  extends WebSecurityConfigurerAdapter{
	
	//extends WebSecurityConfigurerAdapter
	/// we want to have multiple user 
	//we want to apply permission for different users
	
	// lets have two authority 
	private static final String DEVELOPER_AUTHORITY = "developer";
	private static final String DEVOPS_AUTHORITY = "devops";
	private static final String ADMIN_AUTHORITY = "admin";
	
	//@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//auth.inMemoryAuthentication();
		//auth.ldapAuthentication(); ---- here the  store the data in hirerachy mgr --- > sr dev ---> you
		//AuthenticationManagerBuilder ----> purpose is to provide different way of authentication
		
		//want to add a few users
		auth.inMemoryAuthentication()
			.withUser("Jim")
			.password("Jim123")
			.authorities(DEVELOPER_AUTHORITY)
			.and()
			.withUser("John")
			.password("John123")
			.authorities(DEVOPS_AUTHORITY)
			.and()
			.withUser("Catalina")
			.password("Catalina123")
			.authorities(ADMIN_AUTHORITY)
			.and()
			.withUser("Ankit")
			.password("Ankit123");
		}
	
	
	//greetDevops --- random guy 
	// always write your ant matchers from the most restrictive to least restrictive
	
	///home 
	
	protected void configure(HttpSecurity http) throws Exception {
		
	    http.
        httpBasic()
        .and()
        .authorizeHttpRequests()
        .antMatchers("/devops/**").hasAuthority(DEVOPS_AUTHORITY)
        .antMatchers(HttpMethod.POST, "/developer/**").hasAuthority(DEVOPS_AUTHORITY)
        .antMatchers("/developer/**").hasAuthority(DEVELOPER_AUTHORITY)
        .antMatchers("/**").permitAll()
        .and()
        .formLogin();
		    
	}
	
	
//	
//	http.httpBasic()
//    .and()
//    .authorizeHttpRequests()
//    .requestMatchers("/greetDeveloper/**").hasAnyAuthority(DEVELOPER_AUTHORITY)
//    .requestMatchers("/greetDevops/getName/**").hasAnyAuthority(ADMIN_AUTHORITY)
//    .requestMatchers("/greetDevops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
//    .requestMatchers("/greetDeveloper/**").hasAnyAuthority(DEVELOPER_AUTHORITY)
//    .requestMatchers("greetAdmin/**").hasAnyAuthority(ADMIN_AUTHORITY)
//    
//
//    .requestMatchers("/**").permitAll()
//    .and()
//    .formLogin();
//	

}
