package com.kevinphair.graphics.spritetest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * @author Kevin Phair
 * 
 * Create a Window for putting the game stuff in
 *
 */
public class GWindow extends JComponent implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String title;
	private int width;
	private int height;
	private JFrame window;
	private int frameNum = 0;

	Sprite[] demoSprite = null;
	
	/* A constructor which sets the Window title and dimensions
	 */
	public GWindow(String newTitle, int newWidth, int newHeight) {
		title = newTitle;
		width = newWidth;
		height = newHeight;

		window = new JFrame(title);				// Create a new JFrame (window)
		window.add(this);						// Add this component to the JFrame
		window.setResizable(true);
		window.setLocationRelativeTo(null);
		window.setSize(new Dimension(width, height));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}

	/* Set up all the sprites for the demo
	 *  - Get the big sprite sheet into a BufferedImage
	 *  - Extract the sections for each kind of sprite
	 *  - Create a multi-frame sprite from that extraction
	 *  - Set random parameters for the sprite location and direction
	 */
	public void loadSprites() {
		BufferedImage spriteSheet = new Images().loadImage("galagaspritesheet.png");
		
		// Allocate a sprite array 
		demoSprite = new Sprite[11];
		
		for (int i = 0; i < demoSprite.length; ++i) {

			// Extract an image holding the frames for one sprite from the sprite sheet
			demoSprite[i] = new Sprite(new Images().extractTile(spriteSheet, 0, 0, 16 * 24, 16, 0, i), 24);
			
			// Set random direction but make sure neither dx or dy are 0
			do {
				demoSprite[i].setDX(2 - new Random().nextInt(4));
				demoSprite[i].setDY(2 - new Random().nextInt(4));
			} while (demoSprite[i].getDX() == 0 || demoSprite[i].getDY() == 0);

			demoSprite[i].setScale(2);

			// Position the sprite somewhere within the content area
			demoSprite[i].setXY(new Random().nextInt(window.getWidth() - demoSprite[i].getWidth()), 
								new Random().nextInt(window.getHeight() - demoSprite[i].getHeight()));
		}
		
	}
	
	/* Event handler for the timer
	 */
	public void actionPerformed (ActionEvent ae) {

		/* Only update movement if it was the timer that sent the event
		 * Otherwise it could have been another kind of message
		 */
		if (ae.getActionCommand() == "update") {
			frameNum++;				// Increment the frame counter
			
			if (demoSprite != null) for (Sprite s : demoSprite) {

				if (s != null) {
					s.move();

					if ((s.getDX() < 0 && s.getX() < 0) || (s.getDX() > 0 && s.getX() > width - s.getWidth())) {
						s.setDX(-s.getDX());
					}
					if ((s.getDY() < 0 && s.getY() < 0) || (s.getDY() > 0 && s.getY() > height - s.getHeight())) { 
						s.setDY(-s.getDY());
					}

					if (frameNum % 4 == 0) s.nextFrame();	// Animate the sprite every 4 frames
				}
			}
		}
		repaint();						// Update our window content
	}

	/* Draw the components children
	 * Called as part of the repaint() process
	 * These are any items that are overlaid after paintComponent() has run
	 */
	protected void paintChildren(Graphics g) {
		
		if (demoSprite != null) for (Sprite s : demoSprite) {
			if (s != null) s.draw(g);
		}
	}

	/* Draw the component's graphics
	 * Generally this is the first step in updating the window and
	 * means redrawing the background and any major layout and graphical elements 
	 */
	protected void paintComponent(Graphics g) {
		
		// Update the dimensions of our graphics area 
		width = window.getContentPane().getWidth();
		height = window.getContentPane().getHeight();

		// Clear the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}
}
