package nu.xdi.oo_concepts;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class Snake extends Animal {

	private static final String SOUND = "Hiss!";
	
	/**
	 * Default constructor initialises blank name
	 */
	Snake() {
		this("");
	}
	
	/**
	 * Constructor to initialise a new object with specified name
	 * @param name
	 */
	Snake (String name) {
		super (name, Snake.SOUND);
	}
	
	/**
	 * Snake-specific move method
	 */
	public void move () {
		System.out.println(super.getName() + " is slithering...");
	}
	
	/**
	 * Snake's sleep method
	 */
	public void sleep() {
		System.out.println(super.getName() + " coils up and goes to sleep");
	}
	
	/**
	 * This class's implementation of spawn()
	 */
	public void spawn () {
		System.out.println(super.getName() + " lays an egg.");
	}

}
