package com.mygdx.game.desktop;
import static helpers.Art.QuickLoad;
public class EnemySpaceShip extends Enemy {

	public EnemySpaceShip(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture(QuickLoad("spaceship"));
	}

}
