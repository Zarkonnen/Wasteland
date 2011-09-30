package com.zarkonnen.wasteland.model;

public class GameMap {
	public double[][] heightMap;

	public GameMap(int size) {
		heightMap = new double[size][size];
	}
}
