package com.mygdx.game.desktop;


public enum TileType {

	createablefield("starfield_01", false), enemyfield("starfield_m", false), starfield("starfield_02", true), NULL("starfield_02", true);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
