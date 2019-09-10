package com.sperone.crash.logic.objects;

import com.sperone.crash.logic.objects.generic.DynamicObject;

public class Player extends DynamicObject {
	private float gravity = 0.5f;
	private final float MAX_SPEED = 10;

	public Player(int x, int y) {
		super(x, y);
		this.height = this.height * 2;
	}
	
	@Override
	public void update() {
		super.update();
		
		if(this.falling || this.jumping) {
			this.velY += gravity;
			if(this.velY > MAX_SPEED) {
				this.velY = MAX_SPEED;
			}
		}
	}
}
