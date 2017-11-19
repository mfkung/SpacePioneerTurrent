package com.mygdx.game.desktop;


import org.newdawn.slick.opengl.Texture;
import static helpers.Clock.*;
import static helpers.Art.*;

public class Projectile implements Entity {

	private Texture texture;
	private float x, y, speed;
	private int damage, width, height;
	private Enemy target;
	private boolean alive;
	
	public Projectile(Texture texture, Enemy target, float x, float y, int width, int height, float speed, int damage) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.damage = damage;
		this.target = target;
		this.alive = true;
	}
	
	
	
	public void update() {
		if (alive) {
			x += Delta() * speed;
			if (CheckCollision(x, y, width, height, target.getX(), target.getY(), target.getWidth(),
					target.getHeight())) {
				target.damage(damage);
				//System.out.println("HIT!");
				alive = false;
			}
			draw();
		}

	}
	
	public void draw() {
		DrawQuadTex(texture, x, y, 21, 6);
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
