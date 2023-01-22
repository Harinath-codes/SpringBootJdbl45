package com.mutlithreading.examples;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExamples {

	public static void main(String[] args) throws InterruptedException {

		
		List<Integer> al = Arrays.asList(100, 20000, 30000, 4, 5, 6, 7, 8);
		// there are diff types of threadpool in java
		ExecutorService es = Executors.newFixedThreadPool(5);
		al.stream().forEach(num -> es.submit(() -> calculateFact(num)));
	//FUTURE HAS ABILTY TO ONLY WAIT IT WILL NOT NOTIFY
		//COMPLETEABLE FUTURE IT CAN WAIT IT WILL COMPLETE AND NOTIFY
		es.awaitTermination(10,TimeUnit.SECONDS);
		//es.shutdown();

	}

	private static BigInteger calculateFact(int num) {

		System.out.println("In calculate function " + num + "thread " + Thread.currentThread().getName());
		BigInteger result = BigInteger.ONE;

		for (int i = 2; i <= num; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}

}
