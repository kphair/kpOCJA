package com.kevinphair.graphics.balls;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Define our Ball class here
 */
public class Ball {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private double xRot;
	private double yRot;
	private double dXRot;
	private double dYRot;
	private Color ballColor;
//	private Graphics g;
	
	public Ball(int width, int height, Graphics g) {

		this.width = width;
		this.height = height;
		xRot = Math.PI * 2 * Math.random();
		yRot = Math.PI * 2 * Math.random();
		dXRot = Math.PI * (0.002 + Math.random() / 200);
		dYRot = Math.PI * (0.002 + Math.random() / 200);
		x = width / 2 + (int) (Math.sin(xRot) * width / 2);
		y = height / 2 + (int) (Math.cos(yRot) * height / 2);
		ballColor = new Color ((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256), 100);
				
}
	
	public void update() {
		x = width / 2 + (int) (Math.sin(xRot) * width / 2);
		y = height / 2 + (int) (Math.cos(yRot) * height / 2);
		xRot += dXRot;
		yRot += dYRot;
	}

	public void draw(Graphics g) {
		g.setColor(ballColor);
		g.fillOval(x-10, y-10, width/40, height/40);
	}
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}


}
