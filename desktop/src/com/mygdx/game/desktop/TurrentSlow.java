package com.mygdx.game.desktop;

import java.util.concurrent.CopyOnWriteArrayList;

public class TurrentSlow extends Tower {
	//Tower that slow down enemy
	public TurrentSlow(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}
	
}
