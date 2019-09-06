package com.sperone.crash.logic.factory;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.sperone.crash.graphic.main.GameFrame;
import com.sperone.crash.graphic.panels.GamePanel;
import com.sperone.crash.logic.factory.interfaces.IButtonFactory;

public class ButtonFactory implements IButtonFactory {

	@Override
	public JButton make(String text) {
		JButton button = new JButton(text);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		return button;
	}
	
	@Override
	public JButton make(String text, String panel) {
		JButton button = new JButton(text);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				GameFrame.Frame.SwitchPanel(GamePanel.PanelM.getPanel(panel));
			}
		});
		return button;
	}

	@Override
	public JButton make(Image image) {
		JButton button = new JButton(new ImageIcon(image));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		return button;
	}

	@Override
	public JButton make(Image image, String panel) {
		JButton button = new JButton(new ImageIcon(image));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				GameFrame.Frame.SwitchPanel(GamePanel.PanelM.getPanel(panel));
			}
		});
		return button;
	}

}
