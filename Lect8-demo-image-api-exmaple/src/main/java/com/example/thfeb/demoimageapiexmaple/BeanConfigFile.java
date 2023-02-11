package com.example.thfeb.demoimageapiexmaple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfigFile {
	
	
	 // @component - this annaotaton is used to define our own class as bean 
	// this annotaton is used to define beans of the object  which are part of source code 
	
	@Bean
	@Primary
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
	
	
	@Bean 
	public RestTemplate getTemplate2() {
		return new RestTemplate();
	}
	
	

}
