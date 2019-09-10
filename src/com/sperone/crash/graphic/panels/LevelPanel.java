package com.sperone.crash.graphic.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.logic.events.KeyInput;
import com.sperone.crash.logic.objects.Player;
import com.sperone.crash.logic.objects.generic.GameObject;
import com.sperone.crash.logic.objects.generic.StaticObject;

@SuppressWarnings("serial")
public class LevelPanel extends GamePanel implements Runnable {
	private Player p = new Player(10, 10);
	private LinkedList<GameObject> objects = new LinkedList<GameObject>();
	
	public LevelPanel() {
		super();
		objects.add(p);
		for(int i = 0; i <= GameFrame.WindowSize.width + 32; i += 32) {
			objects.add(new StaticObject(i, GameFrame.WindowSize.height - 71));
		}
		this.addKeyListener(new KeyInput(p));
		new Thread(this).start();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, GameFrame.WindowSize.width, GameFrame.WindowSize.height);
		
		p.collide(objects);
		objects.forEach(el -> {
			el.render(g);
		});
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
