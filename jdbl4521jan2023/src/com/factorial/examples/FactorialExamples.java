package com.factorial.examples;

import java.util.Arrays;
import java.util.List;

public class FactorialExamples {

	public static void main(String[] args) {

		// q1 given list of numbers or replace numbers with its square?

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

//		for(int i =0;i<numbers.size();i++){
//		numbers.set(i, numbers.get(i)* numbers.get(i));
//		
//	}
		
		System.out.println(numbers);
		
		
		//q2 find the sum of square of even in list?
		
		int result = 0;
		for(int i =0;i<numbers.size();i++){
			
			if(numbers.get(i)%2 ==0){
				result += (numbers.get(i)* numbers.get(i));
			}
			
		}
		
		System.out.println(result);
		
		

}
}
