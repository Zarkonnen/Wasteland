package com.zarkonnen.wasteland.model;

import java.awt.Color;

public class Tile {
	static enum Type {
		OCEAN(new Color(0, 0, 255)),
		FARMLAND(new Color(127, 255, 0)),
		FOREST(new Color(0, 127, 0)),
		ROADS(new Color(191, 191, 191)),
		SUBURBIA(new Color(127, 127, 127)),
		VILLAGE(new Color(255, 127, 127)),
		CITY(new Color(127, 127, 255)),
		CITYCENTRE(new Color(63, 63, 127));
		
		final Color color;
		private Type (Color color) {
			this.color = color;
		}
	}
	
}
