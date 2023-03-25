package com.exampleredis.redisexamplejdbl45;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	// there are mutiple ways you can store data
	//1)string: string
	//2)string: list 
	//3)string: hash<string:string>
	
	private static final String PERSON_REDIS_STRING_KEY_PREFIX = "per::";
	
	
	@Autowired
	RedisTemplate<String,Object> redisTemplate;
	
	//Storing the value as string
	
	
	@PostMapping("/value")
	public void saveValue(@RequestBody Person person,@RequestParam(value = "expire",required = false) Integer expiry) {
		
		if(expiry == null) {
			redisTemplate.opsForValue().set(getPersonKey(person.getId()),person);
		}else {
			redisTemplate.opsForValue().set(getPersonKey(person.getId()),person,expiry,TimeUnit.SECONDS);
		}
		
		
		
		
		
	}
	
	
	@GetMapping("/value")
	public Person getValue(@RequestParam("id") int personId) {
		
		
		return (Person) redisTemplate.opsForValue().get(getPersonKey(personId));
		
		//go and query from db 
		//return 
		
		
		
	}
	
	
	private String getPersonKey(Integer personId) {
		return PERSON_REDIS_STRING_KEY_PREFIX + personId;
	}
	
	
	
	

}
