package com.exampleredis.redisexamplejdbl45;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable{

	private int id;
	private String name;
	private int age;

	
	
	
	//From our local app we are sending to redis ----- serilization
	//Recieve data from redis ---- deserilize
}
