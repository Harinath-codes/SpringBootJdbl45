package com.abstractclass.example;

public class FinalKeyword {
	
	
	//Final variable 
	//while declaring we can initialse 
	//we can initialise in constructor
	//you can initialse in static block or non-static block 
	//Final Functions
	//Functions which are final it can not be override in child class
	//Final class 
	//if a class is declared as final it can not be inherited
	//if a class final by default all the method are final 
	
	
	public final int count;
	public final static int count2;
	
	static {
		count2 = 100;
	}
	
//	FinalKeyword(){
//		this.count = 100;
//	}
	
	{
		this.count =100;
	}
	
	
	

	public static void main(String[] args) {
		
		FinalKeyword obj = new FinalKeyword();
		//obj.count = 200;
		System.out.println("default value --> "+  obj.count);// will ve having zero 

	}

}
