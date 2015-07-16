/**
 * Created 16 Jul 2015
 * @author Kevin Phair
 * 
 */
package com.kevinphair.ocja.arraytests;

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
		
	}

}
