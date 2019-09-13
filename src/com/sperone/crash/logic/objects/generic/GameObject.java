package com.sperone.crash.logic.objects.generic;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	public static int Slot = 32;
	protected int x;
	protected int y;
	protected int width = Slot;
	protected int height = Slot;
	
	protected Rectangle Bounds;
	protected Rectangle TopBound;
	protected Rectangle BottomBound;
	protected Rectangle RightBound;
	protected Rectangle LeftBound;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
		this.Bounds = new Rectangle(x, y, this.width, this.height);
		this.TopBound = new Rectangle(this.x + 5, this.y, this.width - 10, 1);
		this.BottomBound = new Rectangle(this.x + 5, this.y + this.height - 1, this.width - 10, 1);
		this.RightBound = new Rectangle(this.x + this.width - 1, this.y + 10, 1, this.height - 20);
		this.LeftBound = new Rectangle(this.x, this.y + 10, 1, this.height - 20);
	}
	
	public abstract void render(Graphics g);
	
	public int getX() { return this.x; }
	public int getY() {	return this.y; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	public int getWidth() { return this.width; }
	public int getHeight() { return this.height; }
}
