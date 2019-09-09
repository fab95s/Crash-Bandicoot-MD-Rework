package com.sperone.crash.graphic.panels;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.logic.factory.ButtonFactory;
import com.sperone.crash.logic.factory.interfaces.IButtonFactory;
import com.sperone.crash.logic.managers.ImageManager;
import com.sperone.crash.logic.managers.PanelManager;

@SuppressWarnings("serial")
public abstract class GamePanel extends JPanel {
	public static PanelManager PanelM = new PanelManager();
	protected ImageManager ImageM = new ImageManager();
	protected IButtonFactory BtnF = new ButtonFactory();
	protected Image BG_Image;
	private int Space = 80;
	
	public GamePanel() {
		super();
		this.setLayout(new FlowLayout());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(BG_Image, 0, 0, GameFrame.WindowSize.width, GameFrame.WindowSize.height, this);
	}
	
	protected int CenterHorizontalComponent(JComponent component) {
		return (GameFrame.WindowSize.width / 2) - (component.getWidth() / 2);
	}
	
	protected int CenterVerticalComponent(JComponent component, int numSpace) {
		return (GameFrame.WindowSize.height / 10) + component.getHeight() + (this.Space * numSpace);
	}
}
