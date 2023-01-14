package com.person;

import java.util.ArrayList;
import java.util.List;

public class Person {

	/// list of attributes
	// access modifiers in java

	private int age; // only in the current class
	String name; // visible only inside the current package
	public String address; // visible anywhere in the project
	protected boolean isAdult; // visible in the same packages + child class of
								// different packages
	String gender;
	
	private double salary;
	
	
	public Person(){
		
	}

	public Person(int age, String name, String address, boolean isAdult, String gender) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
		this.isAdult = isAdult;
		this.gender = gender;
	}
	
	public double getSalary() {
		return salary-600;
	}
//encapsultation - it is wrapping up of attributes and methods to handle the behaviour in certain way 
// it is kind of wrapping up of attribute property and method to single unit.
//	public void setSalary(double salary) {
//		if(user == valid ){
//			this.salary = sal
//			
//		}else{
//			
//		}
//		
//		this.salary = salary-500;
//	}

	
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		//PersonThird.getBMI(gender, weight)
		List<String> obj = new ArrayList<>();

	}

}
