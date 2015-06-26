
public class HelloWorldApp {

	public static void main(String[] args) {
		
		// Set up an identity for later
		Person p = new Person();
		
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
		System.out.println("Would you like play a game?");
	}

}
