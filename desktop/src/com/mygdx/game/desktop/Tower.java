package com.mygdx.game.desktop;

import org.newdawn.slick.opengl.Texture;
import static helpers.Art.DrawQuadTex;
import static helpers.Art.QuickLoad;
import static helpers.Clock.Delta;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
public abstract class Tower implements Entity {

	private float x, y, timeSinceLastShot, firingSpeed;
	private int width, height, damage, range;
	private Enemy target;
	private Texture[] textures;
	private CopyOnWriteArrayList<Enemy> enemies;
	private boolean targeted;
	private ArrayList<Projectile> projectiles;
	
	public Tower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		this.textures = type.textures;
		this.damage = type.damage;
		this.range = type.range;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
		this.enemies = enemies;
		this.targeted = false;
		this.timeSinceLastShot = 0f;
		this.firingSpeed = type.firingSpeed;
		this.projectiles = new ArrayList<Projectile>();
	}
	
	private Enemy acquireTarget() {
		Enemy closest = null;
		float closestDistance = 10000;
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
		float yDistance = Math.abs(e.getY() - y);
		if (xDistance < range && yDistance < range)
			return true;
		return false;
	}
	
	private float findDistance(Enemy e) {
		float xDistance = Math.abs(e.getX() - x);
		float yDistance = Math.abs(e.getY() - y);
		return xDistance + yDistance;
	}
	
	private void shoot() {
		timeSinceLastShot = 0;
		projectiles.add(new Projectile(QuickLoad("laser"), target, x + Game.TILE_SIZE / 2 , y + Game.TILE_SIZE / 2 , 21, 6, 900, 10));
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
		for (int i = 0; i < textures.length; i++)
			DrawQuadTex(textures[i], x , y, width, height);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	
	
}
