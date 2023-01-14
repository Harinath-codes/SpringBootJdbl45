package com.person;

public class PersonFive implements PersonInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersonFive obj = new PersonFive();
		System.out.println(obj.getHeight());
		

	}




	public Double getHeight() {
		// TODO Auto-generated method stub
		return 50.0;
	}


	@Override
	public Double getWeight() {
		// TODO Auto-generated method stub
		return 5.5;
	}

}
