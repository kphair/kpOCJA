/**
 * @author Kevin Phair
 * Created 22 Jul 2015
 */
package nu.xdi.inheritance;

/**
 * A child class to extend ParentClass, demonstrating SuperClass constructor use
 * 
 * @author Kevin Phair
 * Created 22 Jul 2015
 *
 */
public class ChildClass extends ParentClass {

	/**
	 * No-args constructor
	 */
	public ChildClass() {
		System.out.println("ChildClass Constructor");
	}

	/**
	 * Constructor which takes a String parameter
	 * @param s
	 */
	public ChildClass(String s) {
		super(s);
		System.out.println("ChildClass Constructor " + s);
	}
	
	/**
	 * Return the name of this object's SuperClass
	 * @return SuperClass name
	 */
	public String className() {
		return "ChildClass -> " + super.className();
	}
	
}
