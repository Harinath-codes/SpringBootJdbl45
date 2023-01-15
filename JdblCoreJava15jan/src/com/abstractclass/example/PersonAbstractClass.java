package com.abstractclass.example;

public abstract class PersonAbstractClass {

	//[10000,5000,30000,45000,120000,34000]
	//Hiding the implementation details and only showing the functionality to the user 
	//can have both abstract method as well non abstract methods 
	//a non-abs class can not have abstract method
	protected abstract void getPersonDetails();
	
	public String getName(){
		return "Anshu";
	}
	
	
	
}
