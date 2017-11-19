package com.mygdx.game.desktop;


import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;

public enum TowerType {
	
	Turrentred(new Texture[] {QuickLoad("rocket2")}, 10, 10000, 2), 
	TurrentBlack(new Texture[]{QuickLoad("rocket3")}, 30, 10000, 2);
	
	Texture[] textures;
	int damage, range;
	float firingSpeed;
	
	TowerType(Texture[] textures, int damage, int range, float firingSpeed){
		this.textures = textures;
		this.damage = damage;
		this.range = range;
		this.firingSpeed = firingSpeed;
	}

}