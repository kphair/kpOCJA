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
	
}
