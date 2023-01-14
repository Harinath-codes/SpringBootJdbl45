package com.employee;

import java.util.ArrayList;
import java.util.List;

import com.person.PersonFourth;

public class EmployeeThird extends PersonFourth{
	
	public int getAge(){
		return 100;
	}
	public int getAge2(){
		return 100;
	}
	
	public int getAge3(double val){
		return 100;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EmployeeThird obj = new EmployeeThird(); // first possibilty 
		System.out.println("first " + obj.getAge());// 100
		
		PersonFourth obj2 = new PersonFourth();
	//	System.out.println("second " + obj2.getAge());//500
		
		
		//EmployeeThird obj = new EmployeeThird();// this is valid 
		//PersonFourth obj2 = new PersonFourth(); // this is valid
		
		//PersonFourth obj3 = new EmployeeThird(); // is this valid  - valid 
		//EmployeeThird obj4 = new PersonFourth(); // is this valid	- 	not valid 
		
		
		PersonFourth obj3 = new EmployeeThird();// it is for resolving purpose only 
		// it will load only those methods of child class which are present in parent and overrided in child
		System.out.println("third " + obj3.getAge());
		
//		
//		ArrayList<String> obj5 = new ArrayList<>();
//		obj5.trimToSize();
//		
//		List<String> obj = new ArrayList<>();
//		obj.
		
		
		
	
		
		
		
		

	}

}
