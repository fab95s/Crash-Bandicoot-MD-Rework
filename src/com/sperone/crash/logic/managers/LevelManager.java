package com.sperone.crash.logic.managers;

import java.util.HashMap;
import java.util.Map;

import com.sperone.crash.logic.objects.Level;

public class LevelManager {
	public static String LEVEL1 = "level1.mdlvl";
	
	private Map<String, Level> levels = new HashMap<String, Level>();
	
	public Level getLevel(String level) {
		if(!levels.containsKey(level)) {
			Level l = new Level(LevelManager.class.getResource("/resources/levels/" + level));
			levels.put(level, l);
		}
		return levels.get(level);
	}
}
