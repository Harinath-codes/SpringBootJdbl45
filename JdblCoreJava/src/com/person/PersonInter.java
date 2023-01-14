package com.person;

public interface PersonInter {

	Double getWeight();

	// Double getHeight();

	public default String getGender() {
		//complicated logic 
		return "Male-Female";
	}

	static Double getHeight() {

		return 1.3;

	}

}
