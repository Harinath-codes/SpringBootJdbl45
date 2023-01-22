package com.mutlithreading.examples;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureAndExecutorsServiceExample {

	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(100, 200, 300, 400, 500, 600, 700, 800);
		
		// so using forkjoinpool if we create threads by default it will have only those many num of threads as many num of processor
		
		ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		List<Future<BigInteger>> futures = new ArrayList<>();
		
		al.parallelStream().forEach(num -> {
			futures.add(es.submit(() -> calculateFact(num)));
		});
		
		es.shutdown();
		
		futures.stream().forEach(future-> {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		

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
