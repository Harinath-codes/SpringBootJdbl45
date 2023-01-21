package com.factorial.examples;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetUnorderedExample {

	public static void main(String[] args) {
		
		Set<Person> personSet = new HashSet<>();
		
		personSet.addAll(Arrays.asList(		
				new Person("John2","Mark2",21),
				new Person("John","Mk3",23),
				new Person("John4","Mark4",18),
				new Person("John","Mk5",19),
				new Person("John","Mk",18)));
				
		
		//q1 find first object which has value fname equals to john
		//result is unpredictable
		
		
	Person obj1 = 	personSet.stream().filter(x-> x.fname.equals("John")).findFirst().orElse(null);
		
	System.out.println("Val1 " + obj1);
	
	
	
	//q2 print the square of all the even ages of person and square plus 1 for odd ages ?
	
	personSet.stream().map(x -> {
		
		System.out.println("we are in map " + x.fname + "---" + x.age);
		
		if(x.age % 2 == 0 ){
			x.age = (x.age * x.age);
		}else{
			x.age = (x.age * x.age) + 1;
		}
		return x;
	}).forEach(y -> System.out.println("we are in for each " + y.fname + "----" + y.age));
	
	
	
	//options are 
	//a) all the first line then all the second line for each object 
	//b) all the second line then all the first line for each object
	//c) first line and then second line for each object  ------ answer
	//d)  error
	
	// so the streams work on 1 elemnt going thorugh all the steps at time then 2nd then 3rd then soonnn
	
	
	
		

	}

}
