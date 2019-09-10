package com.sperone.crash.logic.objects.generic;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected int width = 32;
	protected int height = 32;
	
	protected Rectangle bounds;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.bounds = new Rectangle(x, y, this.width, this.height);
	}
	
	public abstract void render(Graphics g);
	
	public int getX() { return this.x; }
	public int getY() {	return this.y; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
}
