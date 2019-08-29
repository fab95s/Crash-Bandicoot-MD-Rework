package com.sperone.crash.graphic.panels;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameWindow extends JPanel {
	
	public GameWindow() {
		super();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Crash Bandicoot MD");
		frame.setContentPane(new GameWindow());
		frame.setSize(500, 230);
		frame.setLocation(50, 50);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
