package com.mutlithreading.examples;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;



public class FactorialExample {

	public static void main(String[] args) {
	//q1 find the factorial for the numbers given in a list.
		
		
		//List<Integer> al = Arrays.asList(1,2,3,4,5,6,7,8);
		//	al.stream().map(x -> calculateFact(x)).forEach(y -> System.out.println(y));
		// this is a sequential approach
		List<Integer> al2 = Arrays.asList(10000,20000,30000,40000,50000,60000,70000,80000);
		
		long start = System.currentTimeMillis();
		
		al2.stream().map(x -> calculateFact(x)).forEach(y -> {System.out.println(y);System.out.println();});
		
		long end = System.currentTimeMillis();
	
		System.out.println("Total time taken " + (end-start));
		
		
		
	}
	
	
	private static BigInteger calculateFact(int num){
		
		System.out.println("In calculate function " + num + "thread " + Thread.currentThread().getName());
		BigInteger result = BigInteger.ONE;
		
		for(int i = 2;i<=num;i++){
			result = result.multiply(BigInteger.valueOf(i));
		}
		
		return result;
	}
	
	
//	private static int calculateFact(int num){
//		int result = 1;
//		
//		for(int i = 2;i<=num;i++){
//			result = result * i;
//		}
//		
//		return result;
//	}
	
	
	
	
	

}
