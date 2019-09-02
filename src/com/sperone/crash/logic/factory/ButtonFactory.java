package com.sperone.crash.logic.factory;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.sperone.crash.logic.factory.interfaces.IButtonFactory;

public class ButtonFactory implements IButtonFactory {

	@Override
	public JButton make(String text) {
		JButton button = new JButton(text);
		return button;
	}
	
	@Override
	public JButton make(String text, MouseAdapter event) {
		JButton button = new JButton(text);
		button.addMouseListener(event);
		return button;
	}

	@Override
	public JButton make(Image image) {
		JButton button = new JButton(new ImageIcon(image));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		return button;
	}

	@Override
	public JButton make(Image image, MouseAdapter event) {
		JButton button = new JButton(new ImageIcon(image));
		button.setContentAreaFilled(false);
		button.setOpaque(false);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		button.addMouseListener(event);
		return button;
	}

}
