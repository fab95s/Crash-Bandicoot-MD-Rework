package com.sperone.crash.logic.managers;

import java.awt.Image;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ImageManager {
	public static String BACKGROUND_DEFAULT = "Background.jpg";
	
	public static String EXIT_BTN = "buttons/Exit.png";
	public static String CLOSE_BTN = "buttons/Close.png";
	
	private Map<String, Image> images = new HashMap<String, Image>();
	
	public Image getImage(String imageName) {
		if(!images.containsKey(imageName)) {
			try {
				Image image = ImageIO.read(ImageManager.class.getResource("/resources/images/" + imageName));
				images.put(imageName, image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return images.get(imageName);
	}
}
