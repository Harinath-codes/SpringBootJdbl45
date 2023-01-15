package com.functionalinterface.example;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class DemoFunctionalInterface {

	public static void main(String[] args) {
		//DemoFunctionalInterface obj = new DemoFunctionalInterface();
		
//		DemoInterface obj = new DemoInterface(){
//
//			@Override
//			public String calculate() {
//				// TODO Auto-generated method stub
//				return UUID.randomUUID().toString();
//			}
//			
//		};
		
		DemoInterface obj = (a,b) -> {
			
			System.out.println("Bhuvam");
			return UUID.randomUUID().toString();
			
			};
		
		System.out.println(obj.calculate(5,6));
		
		//Consumer FI
		//return a value 3 times appended to a string Kartik ---- kartik kartik kartik
		Consumer<String> consumer=(val)->{
			String result= "";
			for(int i=0;i<3;i++){
				result += val+" ";
			}
			
			System.out.println(result);
		};
		
		consumer.accept("kartik");
		
		
		//SUPPLIER - WILL ONLY RETURN THE VALUE
		Supplier<String> supplier =()->{
			return UUID.randomUUID().toString();
			
		};
		
		System.out.println(supplier.get());
		
		
		//Function - will accept and return both
		Function<String,Integer> function =(param)->{
			return Integer.parseInt(param);
			
		};
		
		
		int a = function.apply("80");
		
		System.out.println("functional interface---------- " + a);
		
		
		
		
        //question 
		//try out with normal for loop
		// then try out with lambda 
		//given a list of number replace every number with its cube;
		

		
		
		
		
	}


}
