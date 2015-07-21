package com.kevinphair.experiments;

/**
 * A test app to store ints as floats and compare the fidelity
 * 
 * @author Kevin Phair
 * @version 1.0
 * @see https://en.wikipedia.org/wiki/IEEE_754-1985
 * 
 * As suspected, once the int goes over a value of 2^24, the number
 * is scaled down fit within a float's storage requirements.
 * 
 * Converting back to integer results in most of the floats no longer
 * matching their original ints
 */
public class FloatTest {

	public static void main(String[] args) {

		int maxNum = (-1 >>> 1);
		int lastGood = 0;
		int i = 0;
		float f = 0;
		int lost = 0;

		System.out.printf("Check int to float from 0 to %08x (%d)...\n", maxNum, maxNum);

		for (int k = 0; k < maxNum; k++) {
			f = k;
			i = (int) f;
			if (i != k) {
				lost ++;
				if (lastGood == 0) lastGood = i - 1;
				//System.out.println("We lost " + k + " (it became " + i + ")");
			}
		}
		System.out.printf("We lost %d integers. The last good one was %08x (%d)\n", lost, lastGood, lastGood);
	}
}
