package com.sperone.crash.logic.events;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.sperone.crash.logic.objects.generic.DynamicObject;

public class KeyInput extends KeyAdapter {
	DynamicObject player;
	
	public KeyInput(DynamicObject player) {
		this.player = player;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
		if(key == KeyEvent.VK_D) { player.setVelX(5); }
		if(key == KeyEvent.VK_A) { player.setVelX(-5); }
		if(key == KeyEvent.VK_SPACE && !player.isJumping()) {
			player.setJumping(true);
			player.setVelY(-10);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_D) { player.setVelX(0); }
		if(key == KeyEvent.VK_A) { player.setVelX(0); }
	}
}
