package com.functionalinterface.example;


@FunctionalInterface
public interface DemoInterface {

	//it can have only 1 and only 1 abstract method 
	//methods in interface are by default public and abstract you need not to declare explicitly
	String calculate(int a, int b);

	
	
	// it can have n number default or static method 
	default String getName(){
		return "Bhauvam";
	}
	
	
	
}
