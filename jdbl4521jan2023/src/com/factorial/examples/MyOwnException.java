package com.factorial.examples;

public class MyOwnException extends RuntimeException {
	
	
	public MyOwnException(String msg){
		super(msg);
		System.out.println("my exception: 123");
	}

}
