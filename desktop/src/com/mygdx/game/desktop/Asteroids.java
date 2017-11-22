package com.mygdx.game.desktop;
public class Asteroids extends Enemy {

	public Asteroids(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture("Giant3");
		this.setHealth(35);
		this.setSpeed(80);
	}

}
