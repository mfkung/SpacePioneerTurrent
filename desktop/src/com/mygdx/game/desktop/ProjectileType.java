package com.mygdx.game.desktop;

import static helpers.Art.QuickLoad;

import org.newdawn.slick.opengl.Texture;

public enum ProjectileType {
	
	Normal(QuickLoad("laser"), 12 , 700),
	Slow(QuickLoad("laserSlow"), 4 , 700);
	
	Texture texture;
	int damage;
	float speed;
	
	ProjectileType(Texture texture, int damage, float speed){
		this.texture = texture;
		this.damage = damage;
		this.speed = speed;
	}

}