package com.kevinphair.ocja.exercises.passingparameters;

/**
 * An application to show instance variables and getters and setters
 * Added to show constructors
 * 
 * @author Kevin Phair
 * Created 21 Jul 2015
 */
public class PersonApp {

	public static void main(String[] args) {

		// Use the default constructor
		Person me = new Person();
		Person you = new Person();
		
		System.out.println("Default constructor: " + me.getName() + " is " + me.getAge());
		System.out.println("Default constructor: " + you.getName() + " is " + you.getAge());

		// Use the new constructor with name and age arguments
		me = new Person("Kevin", 21);
		you = new Person("Computer", 100);

		System.out.println("Name and age constructor: " + me.getName() + " is " + me.getAge());
		System.out.println("Name and age constructor: " + you.getName() + " is " + you.getAge());

		// Use the setters to set the objects's fields
		me.setName("Bob");
		me.setAge(50);
		you.setName("Toby");
		you.setAge(6);
		
		System.out.println("Using setters: " + me.getName() + " is " + me.getAge());
		System.out.println("Using setters: " + you.getName() + " is " + you.getAge());
	}

}
