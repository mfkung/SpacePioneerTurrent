package com.mygdx.game.desktop;

import java.util.concurrent.CopyOnWriteArrayList;

public class TurrentSlow extends Tower {
	//Tower that slow down enemy
	public TurrentSlow(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}
	
	@Override
	public void shoot(Enemy target) {
		super.projectiles.add(new ProjectileSlow(super.type.projectileType, super.target, super.getX() + 32, super.getY() + 32, 21,6));
		super.target.reduceHiddenHealth(super.type.projectileType.damage);
	}
}
