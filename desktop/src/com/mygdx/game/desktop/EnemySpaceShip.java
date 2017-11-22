package com.mygdx.game.desktop;

public class EnemySpaceShip extends Enemy {

	public EnemySpaceShip(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture("spaceship");
		this.setHealth(60);
		this.setSpeed(60);
	}

}
