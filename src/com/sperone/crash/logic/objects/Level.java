package com.sperone.crash.logic.objects;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.sperone.crash.logic.managers.CameraManager;
import com.sperone.crash.logic.objects.generic.GameObject;
import com.sperone.crash.logic.objects.generic.StaticObject;

public class Level {
	private Player player;
	private CameraManager cam;
	private List<ArrayList<Character>> matrix = new ArrayList<ArrayList<Character>>();
	private List<GameObject> objects = new LinkedList<GameObject>();
	
	public Level(URL url) {
		try {
			String level = url.getPath().replace("%20", " ");
			String line = null;
			BufferedReader buffer = new BufferedReader(new FileReader(level));
			while((line = buffer.readLine()) != null) {
				processFileLine(line);
			}
			buffer.close();
			loadObjects();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void processFileLine(String line) {
		ArrayList<Character> tempList = new ArrayList<Character>();
		for(int i = 0; i < line.length(); i++) {
			tempList.add(line.charAt(i));
		}
		matrix.add(tempList);
	}
	
	private void loadObjects() {
		for(int i = 0; i < matrix.size(); i++) {
			List<Character> tempList = matrix.get(i);
			for(int j = 0; j < tempList.size(); j++) {
				int x = j * GameObject.Slot;
				int y = i * GameObject.Slot;
				if(tempList.get(j) == ObjectChar.PLAYER.toChar()) {
					player = new Player(x, y);
					player.collide(objects);
					cam = new CameraManager(player);
					objects.add(player);
				} else if(tempList.get(j) == ObjectChar.BLOCK.toChar()) {
					objects.add(new StaticObject(x, y));
				}
			}
		}
	}
	
	public void render(Graphics g) {
		cam.beginCamera(g);
		player.collide(objects);
		objects.forEach(el -> {
			el.render(g);
		});
		cam.endCamera(g);
	}
	
	public Player getPlayer() { return this.player; }
}
