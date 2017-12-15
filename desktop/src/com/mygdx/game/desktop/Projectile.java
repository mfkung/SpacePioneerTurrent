package com.mygdx.game.desktop;

import org.newdawn.slick.opengl.Texture;

import static helpers.Clock.*;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import static helpers.Art.*;


import com.mygdx.game.desktop.Turrent.*;

public abstract class Projectile implements Entity {

	private Texture texture;
	private float x, y, speed, xVelocity, yVelocity;
	private int damage, width, height, range;
	private Enemy target;
	private boolean alive;

	private ArrayList<Projectile> projectiles;
	private CopyOnWriteArrayList<Enemy> enemies;

	private boolean targeted;

	public Projectile(ProjectileType type, Enemy target, float x, float y, int width, int height) {
		this.texture = type.texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = type.speed;
		this.damage = type.damage;
		this.target = target;
		this.alive = true;
		this.xVelocity = 0f;
		this.yVelocity = 0f;
		calculateDirection();
	}

	public void damage() {
		target.damage(damage);
		alive = false;
	}
	private void calculateDirection() {
		float totalAllowedMovement = 1.0f;
		float xDistanceFromTarget = Math.abs(target.getX() - x - 64
				/ 4 + 64 / 2);
		float yDistanceFromTarget = Math.abs(target.getY() - y - 64
				/ 4 + 64 / 2);
		float totalDistanceFromTarget = xDistanceFromTarget
				+ yDistanceFromTarget;
		float xPercentOfMovement = xDistanceFromTarget
				/ totalDistanceFromTarget;
		xVelocity = xPercentOfMovement;
		yVelocity = totalAllowedMovement - xPercentOfMovement;
		
		//Set direction based on position of target relative to tower
		if (target.getX() < x)
			xVelocity *= -1;
		if (target.getY() < y)
			yVelocity *= -1;
	}

	public void update() {
		if (alive) {
			calculateDirection();
			x += xVelocity * speed * Delta();
			y += yVelocity * speed * Delta();
			if (CheckCollision(x, y, width, height, target.getX(),target.getY(), target.getWidth(), target.getHeight()))
				damage();
			draw();
		}
	}

	public Enemy acquireTarget() {
		Enemy closest = null;
		float closestDistance = 2000;
		for (Enemy e : enemies) {
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

	public void draw() {
		DrawQuadTex(texture, x, y, 11, 11);
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

	public void setAlive(boolean status) {
		alive = status;
	}
}
