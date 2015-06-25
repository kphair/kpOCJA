
public class HelloWorldApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString;
		
		if (args.length > 0) {
			testString = args[0];
		} else {
			testString = "Professor.\nWould you like to play a game?";
		}
		System.out.println("Hello, "+testString);
	}

}
