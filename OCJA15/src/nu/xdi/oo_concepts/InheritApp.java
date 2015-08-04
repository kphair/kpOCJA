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
		
		System.out.println("Instance of " + this.toString().split("@", 0)[0] + " is now running...");
		
		Person person = new Person ("Kevin");
		System.out.println(person + " is present.");
		
		Cat cat = new Cat ("Fluff");
		System.out.println(cat + " is present.");
		
		Dog dog = new Dog ("Bitzer");
		System.out.println(dog + " is present.");
		
		Duck duck = new Duck ("Jemima");
		System.out.println(duck + " is present.");

		Snake snake = new Snake ("Sid");
		System.out.println(snake + " is present.");
		
		this.talk(person);
		this.talk(cat);
		this.talk(dog);
		this.talk(duck);
		this.talk(snake);
		
		this.move(person);
		this.move(cat);
		this.move(dog);
		this.move(duck);
		this.move(snake);
		
		for (Animal a : Animal.getArrayList()) {
			a.sleep();
		}
	}

	/**
	 * talk method for all Animal objects - Let's polymorph!
	 * @param animal object
	 */
	private void talk (Animal a) {
		a.makeNoise();
	}
	
	/**
	 * move method for all Animals - We like to move it, move it!
	 * @param animal object
	 */
	private void move (Animal a) {
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
