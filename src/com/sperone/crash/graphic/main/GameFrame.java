package com.sperone.crash.graphic.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;

import com.sperone.crash.graphic.panels.GamePanel;
import com.sperone.crash.logic.managers.PanelManager;

@SuppressWarnings("serial")
public class GameFrame extends JFrame {
	public static Dimension WindowSize;
	public static GameFrame Frame;
	
	public GameFrame() {
		super("Crash Bandicoot MD");
		this.setContentPane(GamePanel.PanelM.getPanel(PanelManager.MAIN));
		this.setSize(640, 360);
		this.setMinimumSize(new Dimension(640, 360));
		this.setLocation(50, 50);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		WindowSize = this.getSize();
		Frame = this;
		this.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Component w = (Component) e.getSource();
				WindowSize = w.getSize();
			}
		});
	}
	
	public void SwitchPanel(GamePanel gp) {
		this.setContentPane(gp);
		this.revalidate();
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}
