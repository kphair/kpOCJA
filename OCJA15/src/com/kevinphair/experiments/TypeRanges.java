package com.kevinphair.experiments;

public class TypeRanges {

	public static void main(String[] args) {

		System.out.println("Char: 0 to " + ((char)-1 >>> 0));
		System.out.println("Integer: " + (((int)-1 >>> 1) + 1) + " to " + ((int)-1 >>> 1));
		System.out.println("Long: " + (((long)-1 >>> 1) + 1) + " to " + ((long)-1 >>> 1));
		System.out.println("Float: " + (float)(((int)-1 >>> 1) + 1) + " to " + (float)((int)-1 >>> 1));
		System.out.println("Double: " + (double)(((long)-1 >>> 1) + 1) + " to " + (double)((long)-1 >>> 1));

		int[] testInts = { (-1 >>> 1) + 1, -1 >>> 1 };
		float[] testFloats = { 0, 0 };
		
		System.out.println("Int array stored at " + testInts + " contains " + testInts[0]);
		// We force the testFloats reference to point to the testInts array?
		//testFloats = (float[])testInts;
		System.out.println("Float array stored at " + testFloats+ " contains " + testFloats[0]);
		
	}

}
