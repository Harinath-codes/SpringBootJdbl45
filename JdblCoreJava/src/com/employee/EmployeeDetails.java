package com.employee;

import com.person.Person;

public class EmployeeDetails extends Person{

	public static void main(String[] args) {
		Person person = new Person();
		//person.name // not acccesible becoz default
		person.address = " Hyderabad";
		EmployeeDetails ed = new EmployeeDetails();
		ed.isAdult = true;
		
		//person.setSalary(5000.0);
		
		System.out.println(person.getSalary());
		
		

	}

}
