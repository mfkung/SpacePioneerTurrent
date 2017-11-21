package com.mygdx.game.desktop;

import static helpers.Art.QuickLoad;

import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {
	
	Normal(QuickLoad("laser"), 10 , 500),
	Slow(QuickLoad("laserSlow"), 3 , 500);
	
	Texture texture;
	int damage;
	float speed;
	
	ProjectileType(Texture texture, int damage, float speed){
		this.texture = texture;
		this.damage = damage;
		this.speed = speed;
	}

}