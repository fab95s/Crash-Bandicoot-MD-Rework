package com.sperone.crash.graphic.panels;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.sperone.crash.logic.managers.ImageManager;

@SuppressWarnings("serial")
public class GameWindow extends GamePanel {
	public static Dimension WindowSize;
	
	public GameWindow() {
		super();
		this.BG_Image = this.ImageM.getImage(ImageManager.BACKGROUND_DEFAULT);
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
