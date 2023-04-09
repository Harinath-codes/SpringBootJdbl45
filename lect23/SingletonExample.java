package com.series.sorting;

public class SingletonExample implements Cloneable{

	private static SingletonExample singleton;

	private SingletonExample() {

	}

	public static SingletonExample getInstance() {

		if (singleton == null) {
			singleton = new SingletonExample();
		}
		return singleton;
	}
	
	
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	//
//	protected Object clone() throws CloneNotSupportedException {
//		return getInstance();
//	}
}
