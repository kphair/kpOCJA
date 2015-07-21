/**
 * Experiment to check precedence and order of operation of post-increment operator
 */
package com.kevinphair.experiments;

public class PostIncTest {

	public static void main(String[] args) {

		int age = 0;
		
		System.out.println("Age++ is " + age++ + age++);
		System.out.println("Age is now " + age);
	}

}
