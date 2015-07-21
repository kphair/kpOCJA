/**
 * Array testing app 
 * 
 * @author Kevin Phair
 * 
 */
package com.kevinphair.arraytests;

public class ArrayTest1 {

	public static void main(String[] args) {

		int[] sequence = new int[10];		// Will hold the number sequence
		int[] counts = new int[100];		// Will hold the counts for each number
		
		/*
		 * Go through each element of the array, assigning a value to each one
		 */
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = 1 + (int) (Math.random() * 100);
		}

		/*
		 * A simple bubble sort of the array
		 */
		/*
		boolean intSwapped;
		int tempInt = 0;
		
		do {
			intSwapped = false;
			for (int i = 0; i < sequence.length - 1; ++i) {
				if (sequence[i] > sequence[i + 1]) {
					tempInt = sequence[i];
					sequence[i] = sequence[i + 1];
					sequence[i + 1] = tempInt;
					intSwapped = true;
				}
			}
		} while (intSwapped);
		*/

		java.util.Arrays.sort(sequence);
		
		/*
		 *  Do some processing on the array to display each value and
		 *  calculate the overall average, maximum and minimum values
		 *  We will also keep a count of how many times each number turns
		 *  up for later analysis.
		 */
		int sequenceSum = 0;
		int sequenceMin = sequence[0];
		int sequenceMax = sequence[0];
		int currentNum = 0;
		
		System.out.print("sequence[] contains: ");
		for (int i = 0; i < sequence.length; ++i) {
			currentNum = sequence[i];
			System.out.print(currentNum + ((i < sequence.length - 1) ? "," : "\n"));
			sequenceSum += currentNum;
			if (currentNum > sequenceMax) sequenceMax = currentNum;
			if (currentNum < sequenceMin) sequenceMin = currentNum;
			counts[currentNum - 1]++;			// increment this number's appearance count
		}
		
		/*
		 * Calculate the mode numbers of the sequence by scanning
		 * through the array of counts for each number and selecting 
		 * whichever has the highest count
		 */
		int modeMax = counts[0];
		int modeResult = 0;
		
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] > modeMax) {
				modeMax = counts[i];
				modeResult = i;			
			}
		}
		
		/*
		 * Now display some interesting properties of the elements in the array
		 */
		System.out.println("The " + sequence.length + " elements of sequence[] have the following numeric properties:");
		System.out.println(" > Maximum " + sequenceMax);
		System.out.println(" > Minimum " + sequenceMin);
		System.out.println(" > Average " + (double) sequenceSum / sequence.length);
		System.out.println(" > Median  " + sequence[5]);
		System.out.print(" > Mode    ");
		if (counts[modeResult] <= 1) {
			System.out.println("No mode detected");
		} else {
			/*
			 * If there is more than one mode number, we'll need to pad the console output
			 * after the first line to keep each count aligned.
			 */
			String modePadding = "";		
			for (int i = 0; i < counts.length; ++i) {
				if (counts[i] == counts[modeResult]) {
						System.out.println(modePadding + "'" + (i + 1) + "' appeared " + counts[i] + " times");
						modePadding = "           ";
				}
			}
		}
	}

}
