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
		
		this.update();
	}
	
	public void update() {
		this.x += this.velX;
		this.y += this.velY;
		this.bounds.setBounds(this.x, this.y, this.width, this.height);
	}
	
	public void collide(List<GameObject> objects) {
		objects.forEach(el -> {
			if(!(el instanceof Player) && el.bounds.intersects(this.bounds)) {
				this.y = el.getY() - this.height;
				this.velY = 0;
				this.falling = false;
				this.jumping = false;
			} else {
				this.falling = true;
			}
		});
	}
}
