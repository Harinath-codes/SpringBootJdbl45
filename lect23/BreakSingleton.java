package com.series.sorting;

public class BreakSingleton {

	public static void main(String[] args) throws CloneNotSupportedException {
	SingletonExample obj1 = SingletonExample.getInstance();
	SingletonExample obj2 = SingletonExample.getInstance();
	
	
	System.out.println(obj1.hashCode());
	System.out.println(obj2.hashCode());
	
	//reflection 
	//cloneable
	//using desrilization
	
	SingletonExample obj3 = SingletonExample.getInstance();
	SingletonExample obj4 =(SingletonExample) obj3.clone();
	
	
	System.out.println(obj3.hashCode());
	System.out.println(obj4.hashCode());
	
	

	}

}
