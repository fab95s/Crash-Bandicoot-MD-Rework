package com.sperone.crash.logic.objects.generic;

import java.awt.Color;
import java.awt.Graphics;

public class StaticObject extends GameObject {
	
	public StaticObject(int x, int y) {
		super(x, y);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.x, this.y, this.width, this.height);
	}
}
