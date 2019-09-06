package com.sperone.crash.logic.factory.interfaces;

import java.awt.Image;

import javax.swing.JButton;

public interface IButtonFactory {
	public JButton make(String text);
	public JButton make(String text, String panel);
	public JButton make(Image image);
	public JButton make(Image image, String panel);
}
