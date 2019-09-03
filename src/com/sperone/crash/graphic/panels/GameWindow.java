package com.sperone.crash.graphic.panels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.sperone.crash.logic.factory.ButtonFactory;
import com.sperone.crash.logic.factory.interfaces.IButtonFactory;
import com.sperone.crash.logic.managers.ImageManager;

@SuppressWarnings("serial")
public class GameWindow extends GamePanel {
	public static Dimension WindowSize;
	private IButtonFactory BtnFactory = new ButtonFactory();
	private MouseAdapter clickExit = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			System.exit(0);
		};
	};
	private JButton play = BtnFactory.make(this.ImageM.getImage(ImageManager.PLAY_BTN));
	private JButton close = BtnFactory.make(this.ImageM.getImage(ImageManager.CLOSE_BTN), clickExit);
	private JButton exit = BtnFactory.make(this.ImageM.getImage(ImageManager.EXIT_BTN), clickExit);
	
	public GameWindow() {
		super();
		this.BG_Image = this.ImageM.getImage(ImageManager.BACKGROUND_DEFAULT);
		this.add(play);
		this.add(close);
		this.add(exit);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		play.setLocation((WindowSize.width / 2) - (play.getWidth() / 2), (WindowSize.height / 3) - play.getHeight());
		exit.setLocation((WindowSize.width / 2) - (exit.getWidth() / 2), (WindowSize.height / 3) + exit.getHeight());
		close.setLocation(WindowSize.width - close.getWidth() - 20, 10);
		super.paintComponent(g);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Crash Bandicoot MD");
		frame.setContentPane(new GameWindow());
		frame.setSize(640, 360);
		frame.setLocation(50, 50);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowSize = frame.getSize();
		frame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Component w = (Component) e.getSource();
				WindowSize = w.getSize();
			}
		});
	}
}
