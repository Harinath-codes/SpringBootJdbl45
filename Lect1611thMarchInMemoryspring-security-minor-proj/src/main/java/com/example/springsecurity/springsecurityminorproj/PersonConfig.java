package com.example.springsecurity.springsecurityminorproj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class PersonConfig  extends WebSecurityConfigurerAdapter{
	

	private static final String DEVELOPER_AUTHORITY = "developer";
	private static final String DEVOPS_AUTHORITY = "devops";
	private static final String ADMIN_AUTHORITY = "admin";


		  @Override
		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		        auth.inMemoryAuthentication()
		                .withUser("Jim")
		                .password("$2a$10$zX4OnByHjr3hSkdJo6pzZu9dta68ClMXDMTVeCs/oWEBUg4rXxMYu")
		                .authorities(DEVELOPER_AUTHORITY)
		                .and()
		                .withUser("John")
		                .password("$2a$10$XTaULUvlgDIATy/Dsq4i2.B7Q2z.zE8cxe8Kp/X7RF4DG05NwJH7q")
		                .authorities(DEVOPS_AUTHORITY)
		                .and()
		                .withUser("Catalina")
		                .password("$2a$10$toRdoofYzUS7qFE2vMowqOYA14T4hTLA3IsBCW1xiPqrE2E6gidCO")
		                .authorities(DEVOPS_AUTHORITY, DEVELOPER_AUTHORITY);
		    }
	

		  @Override
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
		  
		  
		@Bean
		public PasswordEncoder getPE() {
			return new BCryptPasswordEncoder();
		}



}
