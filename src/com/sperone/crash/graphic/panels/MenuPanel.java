package com.sperone.crash.graphic.panels;

import java.awt.Graphics;

import javax.swing.JButton;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.logic.managers.ImageManager;

@SuppressWarnings("serial")
public class MenuPanel extends GamePanel {
	private JButton play = this.BtnF.make(this.ImageM.getImage(ImageManager.PLAY_BTN));
	private JButton editor = this.BtnF.make(this.ImageM.getImage(ImageManager.EDITOR_BTN));
	private JButton controls = this.BtnF.make(this.ImageM.getImage(ImageManager.CONTROLS_BTN));
	private JButton close = this.BtnF.make(this.ImageM.getImage(ImageManager.CLOSE_BTN));
	private JButton exit = this.BtnF.make(this.ImageM.getImage(ImageManager.EXIT_BTN));
	
	public MenuPanel() {
		super();
		this.BG_Image = this.ImageM.getImage(ImageManager.BACKGROUND_DEFAULT);
		play.setEnabled(false);
		editor.setEnabled(false);
		controls.setEnabled(false);
		this.add(play);
		this.add(editor);
		this.add(controls);
		this.add(close);
		this.add(exit);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		play.setLocation(this.CenterHorizontalComponent(play), this.CenterVerticalComponent(play, 0));
		editor.setLocation(this.CenterHorizontalComponent(editor), this.CenterVerticalComponent(editor, 1));
		controls.setLocation(this.CenterHorizontalComponent(controls), this.CenterVerticalComponent(controls, 2));
		exit.setLocation(this.CenterHorizontalComponent(exit), this.CenterVerticalComponent(exit, 3));
		close.setLocation(GameFrame.WindowSize.width - close.getWidth() - 20, 10);
	}
}
