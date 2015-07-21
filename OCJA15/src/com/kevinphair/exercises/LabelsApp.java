package com.kevinphair.exercises;

/*
 * Using break and continue with labels
 */
public class LabelsApp {

	public static void main(String[] args) {

		outer:
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 5; ++j) {
					System.out.println("Hello");
					if (j == 0) continue outer;
				}	// End of inner loop
				System.out.println("Outer loop");		// Will never print
			}	// End of outer loop
	System.out.println("Good-Bye");
	}
}
