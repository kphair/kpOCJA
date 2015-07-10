package com.kevinphair.graphics.spritetest;

import javax.swing.Timer;

/**
 * @author Kevin Phair
 * 
 * Demo of a Sprite class which can either use a single image sprite
 * or take multiple frames of animation from an image
 * 
 * There are also some image functions to load an image from disk
 * and extract tiles from it
 */
public class Testapp {
	
	private static GWindow window;

	/* Create the window and container within the usable part of the window
	 */
	public static void main(String[] args ) {

		window = new GWindow("Sprite class demo", 300,200);

		window.loadSprites();
		
		// Set up a timer registered to the ActionListener the window
		Timer t = new Timer(1000 / 60, window);			// 60 fps
		t.setActionCommand("update");
		t.start();
		
	}

}
