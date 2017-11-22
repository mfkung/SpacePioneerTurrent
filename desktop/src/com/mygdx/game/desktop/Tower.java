package com.mygdx.game.desktop;

import org.newdawn.slick.opengl.Texture;
import static helpers.Art.DrawQuadTex;
import static helpers.Art.QuickLoad;
import static helpers.Clock.Delta;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
public abstract class Tower implements Entity {

	private float x, y, timeSinceLastShot, firingSpeed;
	private int width, height, range, cost;
	public Enemy target;
	private Texture[] textures;
	private CopyOnWriteArrayList<Enemy> enemies;
	private boolean targeted;
	public ArrayList<Projectile> projectiles;
	public TowerType type;
	
	public Tower(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		this.type = type;
		this.textures = type.textures;
		this.range = type.range;
		this.cost = type.cost;
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.width = startTile.getWidth();
		this.height = startTile.getHeight();
		this.enemies = enemies;
		this.targeted = false;
		this.timeSinceLastShot = 0f;
		this.projectiles = new ArrayList<Projectile>();
		this.firingSpeed = type.firingSpeed;
	}
	
	private Enemy acquireTarget() {
		Enemy closest = null;
		float closestDistance = 2000;
		for (Enemy e: enemies) {
			if (isInRange(e) && findDistance(e) < closestDistance && e.getHiddenHealth() > 0) {
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
	
	public abstract void shoot(Enemy target);
	
	public void updateEnemyList(CopyOnWriteArrayList<Enemy> newList){
		enemies = newList;
	}
	
	public void update() {
		if (!targeted || target.getHiddenHealth() < 0) {
			target = acquireTarget();
		} else if (timeSinceLastShot > firingSpeed) {
			shoot(target);
			timeSinceLastShot = 0;
		}
		
		if (target == null || target.isAlive() == false)
			targeted = false;
		
		timeSinceLastShot += Delta();
		
		
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

	public Enemy getTarget() {
		return target;
	}

	public int getCost() {
		return cost;
	}
}
