// "Hello, World" test app learning exercise
public class HelloWorldApp {

	public static void main(String[] args) {
		
		// Set up identities for later
		Person p = new Person();
		Person c = new Person();
		
		c.setName("Joshua");
		c.setAge(17);
		// c.setGender('m');
		
		// Check for any supplied arguments
		if (args.length > 0) {
			// If there is a user-supplied string, use that
			p.setName (args[0]);
		} else {
			// Otherwise, use the following default if the
			// class has no default name
			if (p.getName()==null) {
				System.out.println("* No name set in class, setting a default");
				p.setName("Professor");
			}
		}

		System.out.println("Hello, "+p.getName());
		
		System.out.println("My name is "+c.getName()+".");
		System.out.print("I am ");
		
		// Figure out whether to use "a" or "an"
		System.out.print('a');
		if (c.getAge()<10) {
			if (c.getAge()==1) {
				System.out.print("n");
			}
		} else if (c.getAge()<20) {
			if (c.getAge()==11 || c.getAge()==18) {
				System.out.print("n");
			}
		}

		System.out.println(" "+c.getAge()+" year old "+c.getGenderFull()+".");
		System.out.println("Would you like play a game?");
		
	}

}
