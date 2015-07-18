package com.kevinphair.games.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Invader class to handle the properties of each invader on the screen
 * 
 * @author Kevin Phair
 * @date 15 Jul 2015
 */
public class Invader {
	private int x;
	private int y;
	private int type;		// 0:inactive, 1-5:rows 1-5, 6:saucer

	/**
	 * Constructor for a new Invader object with position and type
	 * 
	 * @param x
	 * @param y
	 * @param type
	 */
	public Invader(int x, int y, int type) {
		
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	/**
	 * Redraw the invader on the screen with the current position and type
	 * 
	 * @param Graphics context for play area
	 */
	public void redraw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval(x, y, 24, 16);
	}
	
	/**
	 * Step an invader across the screen
	 * 
	 * The invaders are redrawn from the bottom row up.
	 * When they are marching right, each row is updated starting from the right.
	 * When they are marching left, each row is updated starting from the left.
	 * 
	 * When any invader hits the edge of the screen, all of them move down 16 pixels
	 * and the direction changes
	 * 
	 * The array starts from the top left invader and goes left to right then down
	 */
	public void moveInvader() {
		int dir = Game.getDirection();
	
		if ((x < 40 && dir == -1) || (x > 400 && dir == 1) || (Game.getChangeDirection())) {
			Game.changeDirection();
			y += 16;
		}
		x += Math.signum(Game.getDirection()) * 4;
	}
	
	/**
	 * Get the type of the current invader
	 * 
	 * @return invader type
	 */
	public int getType() {
		return type;
	}
}
