package com.kevinphair.games.spaceinvaders;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 * Game function code
 * 
 * This class manages the tracking and updating of all game objects

 * @author Kevin Phair
 * @date 15 Jul 2015
 */
public class Game {
	private static int x = 240, y = 580;
	private static int direction = 0;
	private static boolean keyStats[] = {
			false,		// Left 
			false, 		// Right
			false, 		// Fire
			false,		// Player 1 start
			false		// Quit game
			};
	
	private static Invader[] invaders = new Invader[55];
	static boolean gameRunning = false;
	static int currentRow = 4;
	static int currentCol = 10;

	/**
	 * Start the game by resetting the score and initialising a new array of invaders
	 * 
	 */
	public static void StartGame() {

		for (int i = 0; i < 5; ++i) {
			for (int j = 0; j < 11; ++j) {
				invaders[i * 11 + j] = new Invader(40 + j * 32, 80 + i * 32, i + 1);
			}
		}
		Game.setDirection(1);
		gameRunning = true;
	}
	
	/**
	 * Redraw the enemies, player, barriers, bullets and score.
	 * 
	 * @param graphics context of drawable area
	 */
	public static void update(Graphics g) {

		
		if (gameRunning) {
			
			g.setColor(Color.GREEN);
			g.fillRect(x, y, 28, 16);

			/*
			 * Step left or right across the current row of invaders
			 * moving up one row if the end is reached
			 */
			do {
				invaders[currentRow * 11 + currentCol].moveInvader();
				if (direction < 0) {
					currentCol++;
					if (currentCol > 10) {
						currentCol = 0;
						currentRow--;
					}
				} else if (direction > 0) {
					currentCol--;
					if (currentCol < 0) {
						currentCol = 10;
						currentRow--;
					}
				}
			} while ((currentRow >= 0) && (invaders[currentRow * 11 + currentCol].getType() == 0));
			

			/*
			 * If all the invaders are done set the direction flag to 
			 * purely horizontal movement if they were moving down
			 */
			if (currentRow < 0) {
				currentRow = 4;
				if (direction < 0) {
					direction = -1;
					currentCol = 0;
				} else if (direction > 0) {
					direction = 1;
					currentCol = 10;
				}
			}
	
			for (int i = 0; i < 5; ++i) {
				for (int j = 0; j < 11; ++j) {
					invaders[i * 11 + j].redraw(g);
				}
			}

		}
	}

	/**
	 * Update movement of the player and invaders
	 * 
	 * @param window that contains the game
	 */
	public static void movement(Container window) {

		if (keyStats[0] && x > 0) x-= 2;							// LEFT
		if (keyStats[1] && x < window.getWidth() - 16) x+= 2;		// RIGHT
	}

	
	/**
	 * Set items in the controls matrix via key press events
	 * 
	 * @param keyPressed event
	 */
	public static void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		
		switch(key) {
			case KeyEvent.VK_LEFT: keyStats[0] = true; break;
			case KeyEvent.VK_RIGHT: keyStats[1] = true; break;
			case KeyEvent.VK_SPACE: keyStats[2] = true; break;
			case KeyEvent.VK_1: keyStats[3] = true; break;
			case KeyEvent.VK_ESCAPE: keyStats[4] = true; break;
		}
	}
	
	/**
	 * Reset items in the controls matrix via key release events
	 * 
	 * @param keyReleased event
	 */
	public static void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		
		switch(key) {
			case KeyEvent.VK_LEFT: keyStats[0] = false; break;
			case KeyEvent.VK_RIGHT: keyStats[1] = false; break;
			case KeyEvent.VK_SPACE: keyStats[2] = false; break;
			case KeyEvent.VK_1: keyStats[3] = false; break;
			case KeyEvent.VK_ESCAPE: keyStats[4] = false; break;
		}
	}
	
	/**
	 * Set the direction of the Invaders
	 * 
	 * When the direction is +/-2 (moving down and right/left) it will be changed to +/-1 when
	 * the entire squadron has been redrawn
	 * 
	 * @param newDirection - -2 = moving down and left, -1 = left, 1 = right, 2 = moving down and right
	 * 
	 */
	public static void setDirection(int newDirection) {
		direction = newDirection;
	}
	
	/**
	 * Get the direction of the invaders
	 * 
	 * @return -2 = moving down and left, -1 = left, 1 = right, 2 = moving down and right
	 */
	public static int getDirection() {
		return direction;
	}
}
