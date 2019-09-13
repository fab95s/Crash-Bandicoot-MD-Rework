package com.sperone.crash.logic.objects.generic;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import com.sperone.crash.logic.objects.Player;

public class DynamicObject extends GameObject {
	protected float velX = 0;
	protected float velY = 0;
	protected boolean falling = true;
	protected boolean jumping = false;

	public DynamicObject(int x, int y) {
		super(x, y);
	}
	
	public float getVelX() { return this.velX; }
	public float getVelY() { return this.velY; }
	public boolean isJumping() { return this.jumping; }
	public void setVelX(float velX) { this.velX = velX; }
	public void setVelY(float velY) { this.velY = velY; }
	public void setJumping(boolean jumping) { this.jumping = jumping; }

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(this.x, this.y, this.width, this.height);
		if(true) {
			g.setColor(Color.RED);
			g.fillRect(this.TopBound.x, this.TopBound.y, this.TopBound.width, this.TopBound.height);
			g.fillRect(this.BottomBound.x, this.BottomBound.y, this.BottomBound.width, this.BottomBound.height);
			g.fillRect(this.RightBound.x, this.RightBound.y, this.RightBound.width, this.RightBound.height);
			g.fillRect(this.LeftBound.x, this.LeftBound.y, this.LeftBound.width, this.LeftBound.height);
		}
		this.update();
	}
	
	public void update() {
		this.x += this.velX;
		this.y += this.velY;
		this.refreshBounds();
	}
	
	public void refreshBounds() {
		this.Bounds.setBounds(this.x, this.y, this.width, this.height);
		this.TopBound.setBounds(this.x + 5, this.y, this.width - 10, 1);
		this.BottomBound.setBounds(this.x + 5, this.y + this.height, this.width - 10, 1);
		this.RightBound.setBounds(this.x + this.width - 1, this.y + 10, 1, this.height - 20);
		this.LeftBound.setBounds(this.x, this.y + 10, 1, this.height - 20);
	}
	
	public void collide(List<GameObject> objects) {
		objects.forEach(el -> {
			// Top Collision
			if(!(el instanceof Player) & el.Bounds.intersects(this.TopBound)) {
				this.y = el.getY() + el.getHeight();
				this.velY = 0;
			}
			// Bottom Collision
			if(!(el instanceof Player) & el.Bounds.intersects(this.BottomBound)) {
				System.out.println(this.velY);
				this.y = el.getY() - this.height - (this.jumping ? 8 : 0);
				this.velY = (this.jumping ? this.velY : 0);
				this.falling = false;
				this.jumping = false;
			} else {
				this.falling = true;
			}
			// Right Collision
			if(!(el instanceof Player) & el.Bounds.intersects(this.RightBound)) {
				this.x = el.getX() - this.width;
				this.velX = 0;
			}
			// Left Collision
			if(!(el instanceof Player) & el.Bounds.intersects(this.LeftBound)) {
				this.x = el.getX() + this.width;
				this.velX = 0;
			}
		});
	}
}
