package com.mygdx.game.desktop;

import static helpers.Art.*;
import static helpers.Clock.*;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.newdawn.slick.opengl.Texture;

public class Turrent {
	
	private float x, y, timeSinceLastShot, firingSpeed;
	private int width, height, damage, range;
	private Texture baseTexture, rocketTexture;
	private Tile startTile;
	private ArrayList<Projectile> projectiles;
	private CopyOnWriteArrayList<Enemy> enemies;
	private Enemy target;
	private boolean targeted;
	
	public Turrent(Texture baseTexture, Tile startTile, int damage, int range,  CopyOnWriteArrayList<Enemy> enemies) {
		this.baseTexture = baseTexture;
		this.startTile = startTile;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = (int) startTile.getWidth();
		this.height = (int) startTile.getHeight();
		this.damage = damage;
		this.range = range;
		this.firingSpeed = 1;
		this.timeSinceLastShot = 0;
		this.projectiles = new ArrayList<Projectile>();
		this.enemies = enemies;
		this.targeted = false;
		//this.target = acquireTarget();

	}
	
	public Enemy acquireTarget() {
		Enemy closest = null;
		float closestDistance = 2000;
		for (Enemy e: enemies) {
			if (isInRange(e) && findDistance(e) < closestDistance) {
				closestDistance = findDistance(e);
				closest = e;
			}
		}
		if (closest != null)
			targeted = true;
		return closest;
	}
	
	private boolean isInRange(Enemy e) {
		float xDistance = Math.abs(e.getX() - x);
		if (xDistance < range)
			return true;
		return false;
	}
	
	private float findDistance(Enemy e) {
		float xDistance = Math.abs(e.getX() - x);
		return xDistance;
	}
	
	private void shoot() {
		timeSinceLastShot = 0;
		//projectiles.add(new ProjectileSlow(QuickLoad("laserSlow"), target, x + Game.TILE_SIZE / 2 , y + Game.TILE_SIZE / 2 , 21, 6, 900, 10));
	}
	
	public void updateEnemyList(CopyOnWriteArrayList<Enemy> newList){
		enemies = newList;
	}
	public void update() {
		if (!targeted) {
			target = acquireTarget();
		}
		
		if (target == null || target.isAlive() == false)
			targeted = false;
		
		timeSinceLastShot += Delta();
		if (timeSinceLastShot > firingSpeed)
			shoot();
		
		for (Projectile p: projectiles)
			p.update();

		draw();
	}
	
	public void draw() {
		DrawQuadTex(baseTexture, x, y, width, height);

	}

}
