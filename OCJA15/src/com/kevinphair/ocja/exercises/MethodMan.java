package com.kevinphair.ocja.exercises;

/**
 * Short exercise to demonstrate methods
 * 
 * @author Kevin Phair
 *
 */
public class MethodMan {
	private int age;
	private String name;
	
	/**
	 * Get the MethodMan's age
	 * 
	 * @return age in years
	 */
	public int getAge () {
		return age;
	}
	
	/**
	 * Set the MethodMan's age
	 * 
	 * @param age in years
	 */
	public void setAge (int age) {
		this.age = age;
	}
	
	/**
	 * Get the MethodMan's name
	 * 
	 * @return name as string
	 */
	public String getName () {
		return name;
	}
	
	/**
	 * Set the MethodMan's name
	 * 
	 * @param name as string
	 */
	public void setName (String name) {
		this.name = name;
	}
	
	/**
	 * Get a description of the MethodMan
	 * 
	 * @return String presenting MethodMan's data fields
	 */
	public String getDescription () {
		return name + " is " + age + " years old.";
	}

	/**
	 * Get the year of MethodMan's birth
	 * 
	 * @return
	 */
	public int getBirthYear () {
		return calculateBirthYear();
	}
	
	/**
	 * Work out the birth year of this MethodMan
	 * 
	 * @return the estimated year of birth
	 */
	private int calculateBirthYear () {
		return 2015 - age;
	}
	
}
