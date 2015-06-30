/**
 * 
 */
package com.kevinphair.ocja.experiments;

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
