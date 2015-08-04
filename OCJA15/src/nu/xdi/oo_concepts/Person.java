package nu.xdi.oo_concepts;

/**
 * A class to use in demonstrating object-oriented concepts such as
 * inheritance, polymorphism, abstraction
 * 
 * @author Kevin Phair
 * Created 4 Aug 2015
 *
 */
public class Person {

	String name;
	
	Person() {
		name = "";
	}
	
	Person (String name) {
		this.name = name;
	}
	
	public void makeNoise() {
		System.out.println("Person object makes a noise.");
	}
	
	public String toString() {
		return this.name;
	}
	
	
}
