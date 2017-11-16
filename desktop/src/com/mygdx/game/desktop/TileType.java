package com.mygdx.game.desktop;


public enum TileType {
	Ground("starfield_01", true),
	Ground2("starfield_02", true),
	Ground3("starfield_03", true),
	Ground4("starfield_04", true),
	GroundM("starfield_m", true);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable){
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
