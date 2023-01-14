package com.person;

public class PersonThird {

	private double height;
	private double weight;
	private String gender;

	public double getBMI() {
		return 25.0;
	}

	public double getBMI(double weight) {
		return weight * 5.0;
	}

	public double getBMI(double weight, double height) {
		return height * weight * 5.0;
	}

	public static double getBMI(String gender, double weight) {
		return 5.0;
	}
	
	
	
	

	// method name can be same
	// but type of agrument is diff
	// there is not such thing as order.
	// return type does not matter in method overloading
	// does access modifiers matters in method overloading - no

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getBMI("ad", 4);

	}

}
