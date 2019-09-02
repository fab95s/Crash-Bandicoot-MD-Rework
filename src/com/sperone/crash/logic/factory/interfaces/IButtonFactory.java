package com.sperone.crash.logic.factory.interfaces;

import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;

public interface IButtonFactory {
	public JButton make(String text);
	public JButton make(String text, MouseAdapter event);
	public JButton make(Image image);
	public JButton make(Image image, MouseAdapter event);
}
