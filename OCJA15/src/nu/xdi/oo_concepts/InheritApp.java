package nu.xdi.oo_concepts;

/**
 * Program to demonstrate how inheritance works with similar but separate objects
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class InheritApp {

	public static void main (String[] args) {
		
		new InheritApp().runProgram();
	}

	/**
	 * Create various Animal-derived objects and make them perform.
	 */
	private void runProgram () {
		
		System.out.println("Instance of " + this.toString().split("@", 0)[0] + " is now running...");
		
		// Since the Animal.ArrayList was added there's no need to assign the objects to
		// specific variables but the code has been kept for clarity.
		Person person = new Person ("Kevin");
		Cat cat = new Cat ("Jones");
		Dog dog = new Dog ("Bitzer");
		Duck duck = new Duck ("Jemima");
		Snake snake = new Snake ("Sid");

		System.out.println("\n\u001b[33;1mRoll call!\u001b[0m");
		for (Animal a : Animal.getArrayList()) {
			System.out.println("\u001b[32;1m" + a.getName() + "\u001b[37;0m is present.");
		}
		System.out.println("\n\u001b[33;1mSing, my children!\u001b[0m");
		for (Animal a : Animal.getArrayList()) {
			talk(a);
		}
		System.out.println("\n\u001b[33;1mWe like to moveIt(), moveIt()!\u001b[0m");			// (use local method to call objects' methods)
		for (Animal a : Animal.getArrayList()) {
			moveIt(a);
		}
		System.out.println("\n\u001b[33;1mAll the children are tired now...\u001b[0m");		// (use objects' methods directly)
		for (Animal a : Animal.getArrayList()) {
			a.sleep();
		}
		System.out.println();
	}

	/**
	 * talk method for all Animal objects - Let's polymorph!
	 * @param animal object
	 */
	private void talk (Animal a) {
		a.makeNoise();
	}
	
	/**
	 * move method for all Animals
	 * @param animal object
	 */
	private void moveIt (Animal a) {
		a.move();
	}
	
//	/**
//	 *  talk method for Person objects
//	 * @param person object
//	 */
//	private void talk (Person p) {
//		p.makeNoise();
//	}
//	
//	/**
//	 *  talk method for Cat objects
//	 * @param cat object
//	 */
//	private void talk (Cat c) {
//		c.makeNoise();
//	}
//	
//	/**
//	 *  talk method for Dog objects
//	 * @param dog
//	 */
//	private void talk (Dog d) {
//		d.makeNoise();
//	}
	
}
