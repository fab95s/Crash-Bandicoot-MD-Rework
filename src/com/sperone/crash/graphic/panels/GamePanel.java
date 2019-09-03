package com.sperone.crash.graphic.panels;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import com.sperone.crash.logic.managers.ImageManager;

@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel {
	protected ImageManager ImageM = new ImageManager();
	protected Image BG_Image;
	
	public GamePanel() {
		super();
		this.setLayout(new FlowLayout());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BG_Image, 0, 0, GameWindow.WindowSize.width, GameWindow.WindowSize.height, this);
	}
}
