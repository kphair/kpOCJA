package com.kevinphair.ocja.exercises.passingparameters;

/**
 * Person class to accompany PersonApp
 * 
 * @author Kevin Phair
 * Created 21 Jul 2015
 */
public class Person {

	private int age = -1;
	private String name = "Anon";
	
	/**
	 * Default constuctor. No code, uses variables' defaults
	 */
	Person() {
		
	}
	
	/**
	 * Constructor which sets the name and age
	 * @param name as string
	 * @param age as integer
	 */
	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Get the Person's age
	 * @return age as integer
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * Set the Person's age
	 * @param age as integer
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * Get the person's name
	 * @return name as string
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set the Person's name
	 * @param name as string
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
