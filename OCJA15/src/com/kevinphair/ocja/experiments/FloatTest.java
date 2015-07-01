/**
 * A test app to store ints as floats and compare the fidelity
 * 
 * As suspected, once the int goes over a value of 2^24, the number
 * is scaled down fit within a float's storage requirements.
 * 
 * Converting back to integer results in most of the floats no longer
 * matching their original ints
 */
package com.kevinphair.ocja.experiments;

/**
 * @author Kevin Phair
 * @version 1.0
 * @see https://en.wikipedia.org/wiki/IEEE_754-1985
 */

public class FloatTest {

	public static void main(String[] args) {

		int i = 0;
		float f = 0;
		int lost = 0;
		
		for (int k = 0; k < (Math.pow(2, 31) - 1); k++) {
			f = k;
			i = (int) f;
			if (i != k) {
				lost ++;
				//System.out.println("We lost " + k + " (it became " + i + ")");
			}	
		}
		System.out.println("We lost " + lost + " integers");
	}
}
