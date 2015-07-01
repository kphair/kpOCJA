package com.kevinphair.ocja.arraytests;

public class SortArray {

	public int[] sortInts (int[] intArray) {
		
		boolean itemSwapped = false;
		int tempInt; 
		
		do {
			itemSwapped = false;
			for (int i=0; i < intArray.length - 1; ++i) {
				if (intArray[i] < intArray[i+1]) {
					tempInt = intArray[i+1];
					intArray[i] = intArray[i+1];
					intArray[i+1] = tempInt;
					itemSwapped = true;						
				}
			}
		} while (itemSwapped);
		return intArray;
	}
}
