/**
 * Created 13 Jul 2015
 * @author Kevin Phair
 * 
 */
package com.kevinphair.experiments;

import java.util.Random;

/**
 * This is an experiment to see if the JVM imposes an upper limit 
 * on the size of the string constant pool.
 * 
 * 1. Create a string object
 * 2. Create a second unique string object
 * 3. Transfer the reference from the first object to the second
 * 4. Repeat ad infinitum
 *
 * In theory the pool should be come exhausted due to the generation
 * of new transient string constants. Will the JVM clean up the pool
 * after some time has passed?
 */
public class StringConstantPoolExerciser {

	public static void main(String[] args) {

		String name = "";
		
		System.out.println("Testing...");
		while (true) {
			String name2 = name + (new Random().nextDouble() + name);
			//name = name2;
		}
				
	}

}
