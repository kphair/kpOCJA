package com.kevinphair.games.spaceinvaders;

/**
 * Space Invaders game in Java
 * 
 * @author Kevin Phair
 * @date 14 Jul 2015
 */
public class InvadersApp {

	public static void main(String[] args ) {
		
		new Window("Test window", 512,640);

		Game.StartGame();
	}

}
