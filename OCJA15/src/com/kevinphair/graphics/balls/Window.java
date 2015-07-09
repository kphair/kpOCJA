package com.kevinphair.graphics.balls;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * 
 * @author Kevin Phair
 * 
 * Create a Window for putting stuff in
 *
 */
public class Window extends JComponent implements ActionListener {

	private static final long serialVersionUID = 1L;
	private String title;
	private int width;
	private int height;
	private JFrame window;
	private Timer t;
//	private Ball myBall = null;
	private static final int NUM_BALLS = 500;
	private static Ball[] myBalls = new Ball[NUM_BALLS];
	
	// A constructor which sets the Window title and dimensions
	public Window(String newTitle, int newWidth, int newHeight) {
		this.title = newTitle;
		this.width = newWidth;
		this.height = newHeight;

		window = new JFrame(title);
		window.add(this);
		window.setSize(new Dimension(width, height));
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		// Set up a timer registered to the ActionListener of this class (Window)
		t = new Timer(1000 / 60, this);
		t.setActionCommand("update");
		t.start();
		window.setVisible(true);

		for (int i = 0; i < myBalls.length; ++i) {
			myBalls[i]  =  new Ball(width, height, window.getGraphics());
		}
	}
	
	public JFrame getWindow() {
		return window;
	}
	
	// Event handler for the ActionListener
	public void actionPerformed (ActionEvent ae) {
		// Only update the ball's movement if it was the timer that sent the event
		if (ae.getActionCommand() == "update") {
			for (int i = 0; i < myBalls.length; ++i) {
				if (myBalls[i] != null) {
					myBalls[i].setWidth(window.getContentPane().getWidth());
					myBalls[i].setHeight(window.getContentPane().getHeight());
					myBalls[i].update();
				}
			}
		}
		repaint();
	}

	// Called by repaint()
	protected void paintChildren(Graphics g) {
		render(g);
	}

	// Called by the repaint method
	public void render(Graphics g) {
		this.width = window.getContentPane().getWidth();
		this.height = window.getContentPane().getHeight();
		
		for (int i = 0; i < myBalls.length; ++i) {
			if (myBalls[i] != null) {
				myBalls[i].draw(g);
			}
		}
	}

	protected void paintComponent(Graphics g) {
		g.setColor(new Color(0, 0, 0));
		g.fillRect(0, 0, width, height);
	}

}
