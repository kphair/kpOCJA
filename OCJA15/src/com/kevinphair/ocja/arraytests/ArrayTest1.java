package com.kevinphair.ocja.arraytests;

public class ArrayTest1 {

	public static void main(String[] args) {

		// Initialise an array to hold a sequence of ints
		int[] sequence = new int[10];
		int[] counts = new int[100];
		int sequenceMax = 0;
		int sequenceMin = 100;
		int sequenceSum = 0;
		
		// Go through each element of the array, assigning a value to each one
		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = 1 + (int) (Math.random() * 100);
		}
		
		// Sort the array
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
		
		
		// Do some processing on the array to display each value and
		// calculate the overall average, maximum and minimum values
		for (int i = 0; i < sequence.length; ++i) {
			System.out.println("sequence[" + i + "] contains " + sequence[i]);
			sequenceSum += sequence[i];
			// increment the counter for this particular number
			counts[sequence[i] - 1]++;
			if (sequence[i] > sequenceMax) sequenceMax = sequence[i];
			if (sequence[i] < sequenceMin) sequenceMin = sequence[i];
		}

		
		// Calculate the mode numbers of the sequence
		int modeMax = counts[0];
		int modeResult = 0;
		
		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] > modeMax) {
				modeMax = counts[i];
				modeResult = i;			
			}
		}
		
		// Display some interesting properties of the elements in the array
		System.out.println("The " + sequence.length + " elements of sequence array have the following numeric properties:");
		System.out.println(" > Maximum " + sequenceMax);
		System.out.println(" > Minimum " + sequenceMin);
		System.out.println(" > Average " + (double) sequenceSum / sequence.length);
		System.out.println(" > Median  " + sequence[5]);
		System.out.print(" > Mode    ");
		if (counts[modeResult] <= 1) {
			System.out.println("No mode detected");
		} else {
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
