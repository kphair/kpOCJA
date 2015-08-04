package nu.xdi.oo_concepts;

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
	}
	
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
	
	public String getName() {
		return this.name;
	}
}
