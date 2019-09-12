package com.sperone.crash.graphic.panels;

import java.awt.Color;
import java.awt.Graphics;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.logic.events.KeyInput;
import com.sperone.crash.logic.managers.LevelManager;
import com.sperone.crash.logic.objects.Level;

@SuppressWarnings("serial")
public class LevelPanel extends GamePanel implements Runnable {
	private LevelManager LevelM = new LevelManager();
	private Level level = LevelM.getLevel(LevelManager.LEVEL1);
	
	public LevelPanel() {
		super();
		this.addKeyListener(new KeyInput(level.getPlayer()));
		new Thread(this).start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameFrame.WindowSize.width, GameFrame.WindowSize.height);
		
		level.render(g);
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			if(!this.hasFocus()) {
				this.requestFocus();
			}
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
