package com.mutlithreading.examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ParallelStreamExamples {

	// 1given list calculate sum of squares of even number
	// 2given list find the first even number
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		List<Integer> al2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,9,10);
	

//		ForkJoinPool fjp = new ForkJoinPool(10);
//
//		Future<Integer> future = fjp.submit(() -> al2.stream().filter(x -> {
//			System.out.println("In filter function " + x + "thread " + Thread.currentThread().getName());
//			return x % 2 == 0;
//		}).map(y -> {
//			
//			System.out.println("In map function " + y + "thread " + Thread.currentThread().getName());
//			return y * y;
//
//		}).reduce(0, (i1, i2) -> {
//			System.out.println("In reduce function " + i1 + "-----" + i2 + " : thread " + Thread.currentThread().getName());
//			return i1 + i2;
//		}));
//		
//		System.out.println(future.get());
//		
		
		
		///////////////////////////////////////////find first even
		
		// 2
		
		System.out.println(al2.parallelStream().filter(x -> {
			
			System.out.println("In filter function " + x + Thread.currentThread().getName());
			return x % 2 == 0;
					}).findFirst().orElse(null));
		
		

	}

}
