package com.abstractclass.example;

public class ObjectsExamples {
	
	private String firstName;
	private String lastName;
	private int age;
	
	
//
//	@Override
//	public String toString() {
//		return "ObjectsExamples [firstName=" + firstName + ", age=" + age + "]";
//	}






	public static void main(String[] args) {
		ObjectsExamples obj =new ObjectsExamples();
		obj.firstName = "Kartik";
		obj.lastName = "Aryan";
		obj.age = 25;
		
		ObjectsExamples obj2 =new ObjectsExamples();
		obj2.firstName = "Kartik";
		obj2.lastName = "Aryan";
		obj2.age = 25;
		
		
		System.out.println(obj);
		System.out.println(obj2);
		
		System.out.println("----------------------------------------------------");
		
		System.out.println(obj.equals(obj2));
		
		
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ObjectsExamples other = (ObjectsExamples) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
