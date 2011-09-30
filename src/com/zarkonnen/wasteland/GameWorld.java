package com.zarkonnen.wasteland;

import com.zarkonnen.wasteland.model.GameMap;
import com.zarkonnen.wasteland.model.MapGen;

public class GameWorld {
	GameMap gm = MapGen.gen(600);

	public GameWorld() {
		gm = MapGen.gen(600);
	}
	
	public void tick() {
		
	}
}
