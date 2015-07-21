package com.kevinphair.exercises;

/**
 * @author Kevin Phair
 *
 */
public class MethodManApp {

	/**
	 * Demonstrate the use of the MethodMan class
	 */
	public static void main(String[] args) {

		MethodMan mM = new MethodMan();
		
		mM.setAge(20);
		mM.setName("Mr Method");
		
		System.out.println(mM.getDescription());
	}

}
