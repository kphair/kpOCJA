/*
 * HelloWorldApp
 * 
 * Version 1
 * 
 * A "Hello, World" test app learning exercise
 */
package com.kevinphair.ocja.helloworld;

public class HelloWorldApp {

	public static void main(String[] args) {
		
		/* Set up identities for later */
		Person user = new Person();
		Person computer = new Person();
		
		computer.setName("Joshua");
		computer.setAge(17);
		// computer.setGender('m');
		
		/* Check for any supplied arguments */
		if (args.length > 0) {
			/* If there is a user-supplied string, use that */
			user.setName (args[0]);
		} else {
			/* Otherwise, ask the user for a name */
			
			/* If still no name provided, use a default if the
			 * class itself has no default name */
			if (user.getName() == null) {
				System.out.println("* No name set in class, setting a default");
				user.setName("Professor");
			}
		}

		System.out.println("Hello, " + user.getName());
		
		System.out.println("My name is " + computer.getName() + ".");
		System.out.print("I am ");
		
		/* Figure out whether to use "a" or "an" */
		System.out.print('a');
		if (computer.getAge() < 10) {
			if (computer.getAge() == 1) {
				System.out.print("n");
			}
		} else if (computer.getAge() < 20) {
			if (computer.getAge() == 11 || computer.getAge() == 18) {
				System.out.print("n");
			}
		}

		System.out.println(" "+computer.getAge()+" year old "+computer.getGenderFull()+".");
		System.out.println("Would you like play a game?");
		
	}

}
