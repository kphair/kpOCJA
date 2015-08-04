package nu.xdi.oo_concepts;

import java.util.Random;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class Cat {

	private String name;
	
	/**
	 * Default constructor initialises blank name
	 */
	Cat() {
		this("");
	}
	
	/**
	 * Constructor to initialise a new object with specified name
	 * @param name
	 */
	Cat (String name) {
		this.name = name;
	}
	
	/**
	 * This object makes a noise
	 */
	public void makeNoise() {
//		System.out.println("Cat object (" + this.name + ") makes a noise.");
		System.out.println(this.name + " goes \"" + new String[]{"Meow", "Meow!", "MEOW!", "Meeeoooow!"}[new Random().nextInt(4)] + "\"");
	}
	
	/**
	 * Override default toString()
	 */
	public String toString() {
		return this.name;
	}
	
	public String getName() {
		return this.name;
	}
}
