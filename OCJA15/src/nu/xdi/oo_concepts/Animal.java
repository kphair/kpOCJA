package nu.xdi.oo_concepts;

import java.util.ArrayList;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * We make the class abstract because we don't want it to be possible to instantiate it specifically
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public abstract class Animal {

	private String name;
	private String sound;
	private static ArrayList<Animal> animals;
	
	// Default constructor initialises blank name
	Animal() {
		this("", "");
	}
	
	// Constructor to initialise a new object with specified name
	Animal (String name, String sound) {
		this.name = name;
		this.sound = sound;
		if (Animal.animals == null) Animal.animals = new ArrayList<Animal>();
		Animal.animals.add(this);
	}
	
	/**
	 * method to represent the Object going to sleep
	 * Don't define it here, make it abstract 
	 * subclasses are forced to remain abstract themselves or take care of it
	 */
	abstract public void sleep ();
	
	// makes a noise
	public void makeNoise() {
		System.out.println(this.name + " says, \"" + this.sound + "\"");
	}
	
	// Return string representation
	public String toString() {
		return this.name;
	}
	
	// General move animal method
	public void move() {
		System.out.println(this.name + " is moving...");
	}
	
	// Get the name of this animal
	public String getName() {
		return this.name;
	}
	
	// Get the ArrayList of all Animal objects
	public static ArrayList<Animal> getArrayList () {
		return Animal.animals;
	}
}
