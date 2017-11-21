package com.mygdx.game.desktop;

import org.newdawn.slick.opengl.Texture;

public class ProjectileNormal extends Projectile {

	public ProjectileNormal(ProjectileType type, Enemy target, float x, float y, int width, int height) {
		super(type, target, x, y, width, height);
	}
	
	
	@Override
	public void damage(){

		super.damage();
	}

}
