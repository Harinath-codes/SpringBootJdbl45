package com.factorial.examples;

public class Person {

	String fname;
	String lname;
	int age;

	
	
	@Override
	public String toString() {
		return "Person [fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}



	public Person(String fname, String lname, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

}
