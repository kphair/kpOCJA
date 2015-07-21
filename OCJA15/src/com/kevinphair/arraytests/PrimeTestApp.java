/**
 * 
 */
package com.kevinphair.arraytests;

/**
 * A java app to find prime numbers using an array (sieve of Eratosthenes)
 * 
 * @author Kevin Phair
 * 
 */
public class PrimeTestApp {

	/**
	 * We will use an array of booleans to mark each number off the non-primes list 
	 */
	public static void main(String[] args) {

		boolean[] nonPrimeFlags = new boolean[1000000000];

		nonPrimeFlags[0] = true;
		nonPrimeFlags[1] = true;
		int totalFound = 0;
		
		System.out.println("Finding primes...");
		for (int i = 2; i < nonPrimeFlags.length; i++) {
			if (false == nonPrimeFlags[i]) {				
				
				if (2 == i) {
					// 2 is a special case here. Not prime but we need to mark off its multiples
					nonPrimeFlags[i] = true;
				} else {
					// Found a prime
					System.out.print(i + " ");
					totalFound++;
					if (0 == totalFound % 10) System.out.println();
				}
				
				// Now mark off all its multiples as non-primes
				for (int j = i + i; j < nonPrimeFlags.length; j += i) {
					nonPrimeFlags[j] = true;
				}
			}
		}
		System.out.println("\nDone!");
	}
}
