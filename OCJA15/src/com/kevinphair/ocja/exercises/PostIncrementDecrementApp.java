/**
 * Exercises for the Java programming course 
 * @author Kevin Phair
 *
 */
package com.kevinphair.ocja.exercises;

/*
 * App to demonstrate post-increment and decrement operations
 */
public class PostIncrementDecrementApp {
	
	static final int MIN_AGE = 18;
	static final int MAX_AGE = 199;

	public static void main(String[] args) {
		
		int age = 200;
		
		// Show the initial value of age only if it is 18 or higher and less than 200
		if (ageCheck(age)) {
			System.out.println("Initial value of age: " + age);
		} else {
			System.out.println("Welcome, Lo-Pan");
		}
		
		// Increment and show the new value of age
		age++;
		if (ageCheck(age)) {
			System.out.println("Incremented age: " + age);
		}
		
		// Decrement and show the new value of age
		age--;
		if (ageCheck(age)) {
			System.out.println("Decremented age: " + age);
		}
		
	}
	
	/*
	 * This class will check that the age supplied is within the configured range
	 */
	public static boolean ageCheck(int age) {

		return ((age >= MIN_AGE) && (age <= MAX_AGE));
	}

}
