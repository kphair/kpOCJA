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
	 * 
	 * Perform the required tasks
	 * 
	 */
	private void runProgram () {
		Person person = new Person ("Kevin");
		System.out.println(person + " is present.");
		
		Cat cat = new Cat ("Fluff");
		System.out.println(cat + " is present.");
		
		Dog dog = new Dog ("Rover");
		System.out.println(dog + " is present.");
		
		this.talk(person);
		this.talk(cat);
		this.talk(dog);
		
	}

	/**
	 *  talk method for objects
	 * @param person object
	 */
	private void talk (Animal a) {
		a.makeNoise();
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
