package com.kevinphair.graphics.keycontrols;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Window extends JComponent implements ActionListener {

	// Explicitly define a serialisation ID instead of overriding
	// the warning.
	private static final long serialVersionUID = 1L;
	private String title;
	private int width, height;
	private JFrame window;
	
	public Window (String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;

		window = new JFrame(title);
		window.add(this);				// Add this JComponent to the JFrame, "window"
		window.setSize(new Dimension (width,height));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		window.setVisible(true);	

		/* Attach the keyboard event handlers that are in Game.java
		 */
		window.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Game.keyPressed(e);
			}
			public void keyReleased(KeyEvent e) {
				Game.keyReleased(e);
			}
		} );
	
		/* Attach a 60Hz timer to the window and start it
		 * This will run the game update code
		 */
		Timer t = new Timer(1000 / 60, this);
		t.start();
		
	}

	public void actionPerformed(ActionEvent ae) {
		Game.movement(window.getContentPane());
		repaint();
	}

	/* Draw the component's graphics
	 * Generally this is the first step in updating the window and
	 * means redrawing the background and any major layout and graphical elements 
	 */
	protected void paintComponent(Graphics g) {
		
		// Update the dimensions of our graphics area in case it was resized 
		width = window.getContentPane().getWidth();
		height = window.getContentPane().getHeight();

		// Clear the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
	}

	/* Drawn the components children
	 * In this, the object under user control
	 */
	protected void paintChildren(Graphics g) {
		Game.update(g);
	}

}
