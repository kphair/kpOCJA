package nu.xdi.oo_concepts;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class Person extends Animal {

	private static final String SOUND = "Hello!";
	
	/**
	 * Default constructor initialises blank name
	 */
	Person() {
		this("");
	}
	
	/**
	 * Constructor to initialise a new object with specified name
	 * @param name
	 */
	Person (String name) {
		super (name, Person.SOUND);
	}
	
	/**
	 * Person-specific moving method
	 */
	public void move () {
		System.out.println(super.getName() + " is walking...");
	}

	/**
	 * Person's sleep method
	 */
	public void sleep() {
		System.out.println(super.getName() + " finds a bed to lie in and goes to sleep");
	}

	/**
	 * This class's implementation of spawn()
	 */
	public void spawn () {
		System.out.println(super.getName() + " gives birth.");
	}

//	Person (String name) {
//		this.name = name;
//	}
//	
//	/**
//	 * This object makes a noise
//	 */
//	public void makeNoise() {
//		System.out.println(this.name + " goes \"" + new String[]{"Hello.", "Hi!"}[new Random().nextInt(2)] + "\"");
//	}
//	
//	/**
//	 * Override default toString()
//	 */
//	public String toString() {
//		return this.name;
//	}
}
