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
		
		Person person = new Person ("Kevin");
		System.out.println("'person's toString method returns '" + person + "'");
		person.makeNoise();
		
	}
}
