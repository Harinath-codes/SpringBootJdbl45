package com.factorial.examples;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindSumOfAge {

	
	public static void main(String[] args) {
		
		
		List<Person> personList = Arrays.asList(
				
				new Person("John2","Mark2",21),
				new Person("John","Mk3",23),
				new Person("John4","Mark4",18),
				new Person("John","Mk5",19),
				new Person("John","Mk",18)
				);
				
		//q1 find the sum of ages of all the person
		int totalAge = personList.stream().map(x -> x.age).reduce(0,(i1,i2)-> i1+i2);
		
		System.out.println(totalAge);
		
		System.out.println(
				personList.stream()
				          .filter(x->x.fname.equals("John"))
				          .findAny());
		
		//sequential and collection we are using is ordered 
		//a stream can never have multiple terminal operator
		
		
		System.out.println(
		 		personList.parallelStream()
				          .filter(x->x.fname.equals("John"))
				          .findAny());
		// becoz we are using parallel stream
		
		
		//Person personObj = new Person();
		//personObj.fname.equals("");
		
//		Optional<String> obj =  Optional.of("str");
//		
//		obj.isPresent()
	
		
		//q3 find all the people who have last name has 3 char long
		
		System.out.println("-----------------------------------------------------------");
				personList.stream().filter(x-> x.lname.length() == 3)
				.forEach(y -> System.out.println(y));
			
	// throw error in the end if the object in not found or value doesnot meet the condition
		//find objects if age is greater than 40;
				System.out.println("------------------------question 4 -----------------------------------");	
	Person pobj = 	personList.stream().filter(x ->x.age>40).findFirst().orElse(new Person("firstname", "lastNmae",45));	
			System.out.println(pobj);	
				
			
			
			
			
			System.out.println("------------------------get scenario -----------------------------------");	
			Optional<Person> pobj2 = 	personList.stream().filter(x ->x.age>40).findFirst();	
					System.out.println(pobj2);
					
					
					
				
				
					System.out.println("------------------------Own exception scenario -----------------------------------");	
					Person pobj3 = 	personList.stream().filter(x ->x.age==18).findAny().orElseThrow(() -> new MyOwnException("Element was not found....."));	
							System.out.println(pobj3);		
				
				
				
		
		

	}

}
