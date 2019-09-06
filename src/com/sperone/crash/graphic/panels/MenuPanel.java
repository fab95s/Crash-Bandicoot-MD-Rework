package com.sperone.crash.graphic.panels;

import java.awt.Graphics;

import javax.swing.JButton;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.logic.managers.ImageManager;

@SuppressWarnings("serial")
public class MenuPanel extends GamePanel {
	private JButton play = this.BtnF.make(this.ImageM.getImage(ImageManager.PLAY_BTN));
	private JButton editor = this.BtnF.make(this.ImageM.getImage(ImageManager.EDITOR_BTN));
	private JButton close = this.BtnF.make(this.ImageM.getImage(ImageManager.CLOSE_BTN));
	private JButton exit = this.BtnF.make(this.ImageM.getImage(ImageManager.EXIT_BTN));
	
	public MenuPanel() {
		super();
		this.BG_Image = this.ImageM.getImage(ImageManager.BACKGROUND_DEFAULT);
		this.add(play);
		this.add(editor);
		this.add(close);
		this.add(exit);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		play.setLocation((GameFrame.WindowSize.width / 2) - (play.getWidth() / 2), (GameFrame.WindowSize.height / 3) - play.getHeight());
		editor.setLocation((GameFrame.WindowSize.width / 2) - (editor.getWidth() / 2), (GameFrame.WindowSize.height / 3) + this.Space);
		exit.setLocation((GameFrame.WindowSize.width / 2) - (exit.getWidth() / 2), (GameFrame.WindowSize.height / 3) + exit.getHeight() + this.Space * 2);
		close.setLocation(GameFrame.WindowSize.width - close.getWidth() - 20, 10);
	}
}
