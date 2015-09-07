package nu.xdi.code_challenges;

import java.util.Random;

public class MakePPSN {

	public static void main (String[] args) {

		System.out.println (make("6986035"));

		while (true) {
			System.out.println (make(String.format("%d", new Random().nextInt(9000000) + 1000000)));
		}	

	}

	public static String make(String ppsn) {

	    int w = 8;
	    int sum = 0;

		for (int i = 0; i < 7; ++i) {
			sum += Integer.parseInt(ppsn.charAt(i) + "") * w--; 
		}

		return (ppsn + (char)('A' + (sum - 1) % 23));
	}

}
