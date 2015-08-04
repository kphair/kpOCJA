package nu.xdi.oo_concepts;

import java.util.ArrayList;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public abstract class Animal {

	private String name;
	private String sound;
	private static ArrayList<Animal> animals;
	
	/**
	 * Default constructor initialises blank name
	 */
	Animal() {
		this("", "");
	}
	
	/**
	 * Constructor to initialise a new object with specified name
	 * @param name
	 */
	Animal (String name, String sound) {
		this.name = name;
		this.sound = sound;
		if (Animal.animals == null) Animal.animals = new ArrayList<Animal>();
		Animal.animals.add(this);
	}
	
	/**
	 * Object goes to sleep but don't define it here,
	 * make it abstract so subclasses must take care of it
	 */
	abstract public void sleep ();
	
	/**
	 * This object makes a noise
	 */
	public void makeNoise() {
		System.out.println(this.name + " says, \"" + this.sound + "\"");
	}
	
	/**
	 * Override default toString()
	 */
	public String toString() {
		return this.name;
	}
	
	/**
	 * General move animal method
	 * @return
	 */
	public void move() {
		System.out.println(this.name + " is moving...");
	}
	
	/**
	 * Get the name of this animal
	 * @return
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Get the ArrayList of all Animal objects
	 * 
	 */
	public static ArrayList<Animal> getArrayList () {
		return Animal.animals;
	}
}
