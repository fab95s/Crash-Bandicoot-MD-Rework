package com.sperone.crash.logic.managers;

import java.awt.Graphics;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.logic.objects.generic.DynamicObject;

public class CameraManager {
	private int x;
	private int y;
	private DynamicObject player;

	public CameraManager(DynamicObject player) {
		this.player = player;
	}
	
	public void beginCamera(Graphics g) {
		this.follow();
		g.translate(x, y);
	}
	
	public void endCamera(Graphics g) {
		g.translate(-x, -y);
	}
	
	private void follow() {
		this.x = -player.getX() + (GameFrame.WindowSize.width / 2);
		this.y = -player.getY() + (GameFrame.WindowSize.height - 200);
	}
}
