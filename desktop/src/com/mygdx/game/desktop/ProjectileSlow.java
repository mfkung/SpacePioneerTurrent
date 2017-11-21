package com.mygdx.game.desktop;

import org.newdawn.slick.opengl.Texture;

public class ProjectileSlow extends Projectile {

	public ProjectileSlow(Texture texture, Enemy target, float x, float y, int width, int height, float speed,
			int damage) {
		super(texture, target, x, y, width, height, speed, damage);
	}
	
	@Override
	public void damage(){
		super.getTarget().setSpeed(20);
		super.setAlive(false);
		super.damage();
	}

}
