package com.mutlithreading.examples;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class FactorialUsingMultithreading {

	public static void main(String[] args) {
		List<Integer> al2 = Arrays.asList(1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000);
		//List<Integer> al2 = Arrays.asList(10000,20000,30000,40000,50000,60000,70000,80000);
       // List<Integer> al2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		MyThread[] threads = new MyThread[al2.size()];
		long start = System.currentTimeMillis();
		IntStream.range(0, al2.size()).forEach(i -> {
			threads[i] = new MyThread(al2.get(i));
			threads[i].start();

		});

		Arrays.stream(threads).forEach(x -> {
			try {
				x.join(); // it is a blocking 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(x.result);
		});
		
		long end = System.currentTimeMillis();
		
		System.out.println("Total time taken " + (end-start));

	}

	private static class MyThread extends Thread {

		private int inputNum;
		private BigInteger result;

		public MyThread(int num) {
			this.inputNum = num;
			this.result = BigInteger.ONE;

		}

		@Override
		public void run() {
			calculateFact(this.inputNum);
		}

		private BigInteger calculateFact(int num) {

			System.out.println("In calculate function " + num + "thread " + Thread.currentThread().getName());

			for (int i = 2; i <= num; i++) {
				this.result = this.result.multiply(BigInteger.valueOf(i));
			}

			return this.result;
		}
	}

}
