package com.mygdx.game.desktop;


import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;

public enum TowerType {
	
	Turrentred(new Texture[] {QuickLoad("rocket2")}, ProjectileType.Normal, 10, 2000, 2, 10), 
	TurrentBlack(new Texture[]{QuickLoad("rocket3")}, ProjectileType.Normal, 30, 2000, 2, 20),
	TurrentSlow(new Texture[]{QuickLoad("rocket4")}, ProjectileType.Slow, 30, 2000, 2, 50);
	
	Texture[] textures;
	ProjectileType projectileType;
	int damage, range, cost;
	float firingSpeed;
	
	TowerType(Texture[] textures, ProjectileType projectileType , int damage, int range, float firingSpeed, int cost){
		this.textures = textures;
		this.projectileType = projectileType;
		this.damage = damage;
		this.range = range;
		this.firingSpeed = firingSpeed;
		this.cost = cost;
	}

}