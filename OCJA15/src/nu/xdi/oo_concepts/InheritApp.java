package nu.xdi.oo_concepts;

/**
 * Program to demonstrate how inheritance works with the Person object
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class InheritApp {

	public static void main (String[] args) {
		
		new InheritApp().runProgram();
	}

	// Perform the required tasks
	private void runProgram () {
		Person person = new Person ("Kevin");
		System.out.println(person + " is present.");
		
		Cat cat = new Cat ("Fluff");
		System.out.println(cat + " is present.");
		
		this.talk(person);
		this.talk(cat);
		
	}

	// talk method for Person objects
	private void talk (Person p) {
		p.makeNoise();
	}
	
	// talk method for Cat objects
	private void talk (Cat c) {
		c.makeNoise();
	}
	
}
