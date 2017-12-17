package com.mygdx.game.desktop;
public class EnemySpaceShip3 extends Enemy {

	public EnemySpaceShip3(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture("ss");
		this.setHealth(80);
		this.setSpeed(65);
	}

}
