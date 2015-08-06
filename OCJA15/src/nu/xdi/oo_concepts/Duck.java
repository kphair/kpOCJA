package nu.xdi.oo_concepts;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class Duck extends Animal {

	private static final String SOUND = "Quack!";
	
	/**
	 * Default constructor initialises blank name
	 */
	Duck() {
		this("");
	}
	
	/**
	 * Constructor to initialise a new object with specified name
	 * @param name
	 */
	Duck (String name) {
		super (name, Duck.SOUND);
	}

	/**
	 * Duck-specfic move method
	 */
	public void move () {
		System.out.println(super.getName() + " is waddling...");
	}

	/**
	 * Duck's sleep method
	 */
	public void sleep() {
		System.out.println(super.getName() + " settles down and goes to sleep");
	}

	/**
	 * This class's implementation of spawn()
	 */
	public void spawn () {
		System.out.println(super.getName() + " lays an egg.");
	}

}
