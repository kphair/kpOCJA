/**
 * Created 16 Jul 2015
 * @author Kevin Phair
 * 
 */
package com.kevinphair.arraytests;

import java.util.Random;

/**
 * An implementation of John Conway's "Life" algorithm using a
 * 2-dimensional array of integers to represent the cells
 * 
 * Rules:
 * 	A live cell with fewer than two or more than three neighbours dies
 *	A live cell with two or three neighbours lives
 *	An empty cell with exactly three neighbours becomes live 
 * 
 * @author Kevin Phair
 * @version 1.0
 */
public class LifeApp {

	/**
	 * Initial version
	 * 
	 * 	DECLARE the cell arrays
	 * 	DECLARE a cell neighbour counter
	 * 	INITALISE the cell arrays
	 * 	WHILE (true)
	 * 		FOR each cell
	 * 			RESET counter
	 * 			INCREMENT counter for each live neighbour
	 * 			IF counter < 2 THEN
	 * 				
	 * 		END FOR
	 * 	END WHILE
	 * 		
	 */
	public static void main(String[] args) {

		int[][] cells = new int[8][8];
		
		//System.out.println((char)-1 % 8);
		
	}
	
	public static int countNeighbours(int[][] a) {
		int count = 0;
		int height = a.length;
		int width = a[0].length;
		
		// Step through the rows of cells
		for (int row = 0; row < height; ++row) {
			// Step through the columns in each row of cells
			for (int col = 0; col < width; ++col) {
				// Go through the 8 neighbours of the cell
				for (int x = -1; x < 2; ++x) {
					for (int y = -1; y < 2; ++y) {
						if (x != 0 && y != 0) {
							count += a[((char)row - 1) % height][((char)col - 1) % width];
						}
					}
				}
			}
		}
		
		return count;
	}
	
	public static void initPopulation(int[][] a) {

		// Step through the rows of cells
		for (int row = 0; row < a.length; ++row) {
			// Step through the columns in each row of cells
			for (int col = 0; col < a[row].length; ++col) {
				if (new Random().nextInt(10) < 3) {
					a[row][col] = 1;
				} else {
					a[row][col] = 0;
				}
			}
		}
	}

}
