package com.mygdx.game.desktop;


public enum TileType {

	createablefield("starfield_01", true), enemyfield("starfield_m", false), starfield("starfield_02", false), NULL("starfield_02", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
