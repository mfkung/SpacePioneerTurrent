package com.mygdx.game.desktop;


import com.mygdx.game.desktop.Tile;

public class Checkpoint {
	
	private Tile tile;
	private int xDirection, yDirection;
	
	public Checkpoint(Tile tile, int xDirection, int yDirection) {
		this.tile = tile;
		this.xDirection = xDirection;
		this.yDirection = yDirection;
	}

	public Tile getTile() {
		return tile;
	}

	public int getxDirection() {
		return xDirection;
	}

	public int getyDirection() {
		return yDirection;
	}
	
}
