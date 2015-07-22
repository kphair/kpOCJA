/**
 * @author Kevin Phair
 * Created 22 Jul 2015
 */
package com.kevinphair.inheritance;

/**
 * @author Kevin Phair
 * Created 22 Jul 2015
 *
 */
public class ParentClass {

	/**
	 * main method to demonstrate the Parent and Sub-class constructor behaviours
	 * @param args
	 */
	public static void main (String[] args) {
		
		System.out.println("Demonstrating how child class's no-args constructor calls its parent's no-args constructor");
		ChildClass childClass1 = new ChildClass();

		System.out.println("\nDemonstrating how child class's String-args constructor calls its parent's String-args constructor");
		ChildClass childClass2 = new ChildClass("test");
		
		System.out.println("\nDemonstrating how child class's method uses its parent's className() method");
		ChildClass childClass = new ChildClass();
		System.out.println(childClass.className());
	}
	
	/**
	 * No-args constructor
	 */
	public ParentClass() {
		System.out.println("ParentClass Constructor");
	}
	
	/**
	 * Constructor which takes a String parameter
	 * @param s
	 */
	public ParentClass(String s) {
		System.out.println("ParentClass Constructor " + s);
	}

	/**
	 * Return the name of this object's Class
	 * @return class name
	 */
	public String className() {
		return "ParentClass";
	}
}
