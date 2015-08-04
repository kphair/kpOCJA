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
public class Dog extends Animal{

	private static final String SOUND = "Woof!";
	
	/**
	 * Default constructor initialises blank name
	 */
	Dog() {
		this("");
	}
	
	/**
	 * Constructor to initialise a new object with specified name
	 * @param name
	 */
	Dog (String name) {
		super (name, Dog.SOUND);
	}

//	Dog (String name) {
//		this.name = name;
//	}
//	
//	/**
//	 * This object makes a noise
//	 */
//	public void makeNoise() {
//		System.out.println(this.name + " goes \"" + new String[]{"Woof", "Woof Bark!", "Woof woof woof woof woof!", "Grrr!"}[new Random().nextInt(4)] + "\"");
//	}
//	
//	/**
//	 * Override default toString()
//	 */
//	public String toString() {
//		return this.name;
//	}
//	
//	public String getName() {
//		return this.name;
//	}
}
