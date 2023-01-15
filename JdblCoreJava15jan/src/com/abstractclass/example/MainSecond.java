package com.abstractclass.example;

public class MainSecond implements InterfaceFrist,InterfaceSecond {

	public static void main(String[] args) {
		MainSecond obj = new MainSecond();
		System.out.println(obj.getFirstName());

	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return "Inside the method firstName: 1";
	}

}
