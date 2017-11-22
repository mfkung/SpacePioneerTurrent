package com.mygdx.game.desktop;
import static helpers.Art.QuickLoad;
public class Asteroids extends Enemy {

	public Asteroids(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);
		this.setTexture(QuickLoad("spaceship"));
	}

}
