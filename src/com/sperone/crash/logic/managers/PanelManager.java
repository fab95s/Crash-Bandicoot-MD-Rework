package com.sperone.crash.logic.managers;

import java.util.HashMap;
import java.util.Map;

import com.sperone.crash.graphic.panels.GamePanel;

public class PanelManager {
	public static String MAIN = "MenuPanel";
	
	private Map<String, GamePanel> panels = new HashMap<String, GamePanel>();
	
	public GamePanel getPanel(String panelName) {
		if(!panels.containsKey(panelName)) {
			try {
				GamePanel gp = (GamePanel) Class.forName("com.sperone.crash.graphic.panels." + panelName).newInstance();
				panels.put(panelName, gp);
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return panels.get(panelName);
	}
}
