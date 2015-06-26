
public class HelloWorldApp {

	public static void main(String[] args) {
		// Set up a String for later
		String testString;
		
		// Check for any supplied arguments
		if (args.length > 0) {
			// If there is a user-supplied string, use that
			testString = args[0];
		} else {
			// Otherwise, use the following default
			testString = "Professor.\nWould you like to play a game?";
		}
		
		System.out.println("Hello, "+testString);
	}

}
