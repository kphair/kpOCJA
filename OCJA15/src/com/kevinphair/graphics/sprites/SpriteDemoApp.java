package com.kevinphair.graphics.sprites;

import javax.swing.Timer;

/**
 * @author Kevin Phair
 * 
 * Demo of a Sprite class which can either use a single image sprite
 * or take multiple frames of animation from an image
 * 
 * There are also some image functions to load an image from disk
 * and extract tiles from it
 * 
 * This is a development from the moving balls demo with a lot of
 * lessons learned and a lot of tidying up of code done too
 */
public class SpriteDemoApp {
	
	private static GWindow window;

	/* Create the window and container within the usable part of the window
	 */
	public static void main(String[] args ) {

		window = new GWindow("Sprite class demo", 300,200);

		window.loadSprites();
		
		// Set up a timer registered to the window
		Timer t = new Timer(1000 / 60, window);			// 60 fps
		t.setActionCommand("update");
		t.start();
		
	}

}
