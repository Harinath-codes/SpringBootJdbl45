package com.multithreading;

public class MultiThreading {

	public static void main(String[] args) {
		
		MyThread myThread = new MyThread();
		myThread.start(); //// In thread Thread[Thread-0,5,main]
		//myThread.run(); //In thread Thread[main,5,main] never prefer this as it 
		
		System.out.println("No of processor are - " + Runtime.getRuntime().availableProcessors());
		// i have 10 task and i have only 8 proceessor 
		// 8 will get executed and 2 will be in waiting state ?
		//then later when proecessor get free then these 2 task will be context switched 
		
		
		System.out.println("No of processor are - " + Runtime.getRuntime().totalMemory());
		

	}
	
	private static class MyThread extends Thread{
		
		@Override
		public void run(){
			System.out.println("In thread " + Thread.currentThread());
		}
		
	}

}
