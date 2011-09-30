package com.zarkonnen.wasteland.model;

import java.util.Random;

public class MapGen {
	static final double SEA_LEVEL = 100.0 / 255;
	static final double WALK_LEVEL = 85.0 / 255;
	
	public static GameMap gen(int size) {
		mapgen: do {
			GameMap m = genOne(size); 
			// No brown M&Ms.
			for (int i = 0; i < size; i++) {
				if (m.heightMap[i][0] >= WALK_LEVEL) { continue mapgen; }
				if (m.heightMap[i][size - 1] >= WALK_LEVEL) { continue mapgen; }
				if (m.heightMap[0][i] >= WALK_LEVEL) { continue mapgen; }
				if (m.heightMap[size - 1][i] >= WALK_LEVEL) { continue mapgen; }
			}
			return m;
		} while (true);
	}
		
	public static GameMap genOne(int size) {
		Random r = new Random();
		Perlin pl1 = new Perlin(r);
		Perlin pl2 = new Perlin(r);
		Perlin pl3 = new Perlin(r);
		GameMap gm = new GameMap(size);
		for (int y = 0; y < size; y++) { for (int x = 0; x < size; x++) {
			gm.heightMap[y][x] = (pl1.pnoise(x / 156.0, y / 156.0, 0.5) +
					stepulate(
						pl2.pnoise((x * Math.cos(0.2) + y * Math.sin(0.2)) / 91.0, (y * Math.cos(0.2) + x * Math.sin(0.2)) / 91.0, 0.5)
					)+
					pl3.pnoise(x / 16.0, y / 16.0, 0.5) * 0.1 + 2.7) / 6.0;
			gm.heightMap[y][x] -= Math.pow(((y - size / 2) * (y - size / 2) + (x - size / 2) * (x - size / 2)), 1.5) * 0.00000001;
		}}
		return gm;
	}
	
	static double stepulate(double d) {
		return Math.atan(d);
	}
}
