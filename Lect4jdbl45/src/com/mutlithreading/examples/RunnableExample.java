package com.mutlithreading.examples;

public class RunnableExample {

	public static void main(String[] args) {
		//Daemon thread - for example garbage collection.
		//non-dameon - app will run when altealst one non daemon thread is running
		
		
		Thread thread = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("IN thread " + Thread.currentThread());
				
			}
			
		});
		
		thread.start();

	}

}
