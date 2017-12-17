package com.mygdx.game.desktop;

public class EnemySpaceShip2 extends Enemy {

	public EnemySpaceShip2(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture("spaceship2");
		this.setHealth(120);
		this.setSpeed(45);
	}

}