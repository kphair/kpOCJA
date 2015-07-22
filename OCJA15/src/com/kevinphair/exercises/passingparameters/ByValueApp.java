package com.kevinphair.exercises.passingparameters;

/**
 * Application to demonstrate passing by value
 * 
 * @author Kevin Phair
 * @date 21 Jul 2015
 */
public class ByValueApp {

	public static void main(String[] args) {

		int num = 0;
		System.out.println("main: Value of 'num' is " + num);
		System.out.println("main: Passing this value into increaseNum()...");
		increaseNum(num);
		System.out.println("main: Value of 'num' is still " + num);
		
	}

	public static void increaseNum(int number) {
		System.out.println("increaseNum: Value of 'number' is " + number);
		number++;
		System.out.println("increaseNum: Value of 'number' is " + number);
		System.out.println("increaseNum: Returning back to main...");
	}
}
