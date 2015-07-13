package com.kevinphair.graphics.keycontrols;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Game {
	public static int x,y;
	private static boolean keyStats[] = { false, false, false, false };

	public static void update(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 40, 40);
		g.setColor(Color.WHITE);
		g.drawOval(x, y, 40, 40);
	}

	public static void movement(Container window) {

		if (keyStats[0] && y > 0) y-= 4;			// UP
		if (keyStats[1] && y < window.getHeight() - 44) y+= 4;			// DOWN
		if (keyStats[2] && x > 0) x-= 4;			// LEFT
		if (keyStats[3] && x < window.getWidth() - 44) x+= 4;			// RIGHT
	}

	
	/*
	 * By setting and resetting boolean flags we can act on the
	 * user's actions every time the game runs its movement method.
	 * Otherwise, the keyboard handler only gets activated on the
	 * first key press and thereafter once the keyboard repeat
	 * kicks in.
	 * 
	 * For demonstration purposes, WASD also double as control keys
	 * but without using the boolean flags to show how the keyboard
	 * repeat settings affect the response
	 */
	
	public static void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		
		switch(key) {
			case KeyEvent.VK_UP: keyStats[0] = true; break;
			case KeyEvent.VK_DOWN: keyStats[1] = true; break;
			case KeyEvent.VK_LEFT: keyStats[2] = true; break;
			case KeyEvent.VK_RIGHT: keyStats[3] = true; break;
			case KeyEvent.VK_W: y-= 4; break;
			case KeyEvent.VK_S: y+= 4; break;
			case KeyEvent.VK_A: x-= 4; break;
			case KeyEvent.VK_D: x+= 4; break;
		}
	}
	
	public static void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println(key);
		
		switch(key) {
			case KeyEvent.VK_UP: keyStats[0] = false; break;
			case KeyEvent.VK_DOWN: keyStats[1] = false; break;
			case KeyEvent.VK_LEFT: keyStats[2] = false; break;
			case KeyEvent.VK_RIGHT: keyStats[3] = false; break;
		}
	}
}
