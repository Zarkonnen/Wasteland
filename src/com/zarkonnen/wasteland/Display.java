package com.zarkonnen.wasteland;

import java.awt.Color;
import java.awt.Graphics2D;

public class Display {
	final GameWorld w;
	final int width;
	final int height;

	Display(GameWorld w, int width, int height) {
		this.w = w;
		this.width = width;
		this.height = height;
	}

	void draw(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);

		for (int y = 0; y < w.gm.heightMap.length; y++) { for (int x = 0; x < w.gm.heightMap[y].length; x++) {
			int amt = Math.min(255, Math.max(0, (int) (w.gm.heightMap[y][x] * 255)));
			g.setColor(new Color(amt, amt, amt));
			if (amt < 100) {
				if (amt > 85) {
					g.setColor(new Color(100, 100, amt * 2));
				} else {
					g.setColor(new Color(0, 0, amt * 2));
				}
			}
			g.fillRect(x, y, 1, 1);
		}}
	}
}
