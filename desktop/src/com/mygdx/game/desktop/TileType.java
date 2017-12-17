package com.mygdx.game.desktop;


public enum TileType {

	reachedend("starfield_01", false),  //0
	enemyfield("starfield_02", false),  //1
	platformH("tile-1-horizontal", false),  //2
	platformV("tile-1-vertical", true),  //3
	platformHB("tile-1-horizontal", true), //4
	platform1("tile-1-center", true),   //5
	platform2("tile-1-corner-left-bottom", true), //6
	platform3("tile-1-corner-left-top", true), //7
	platform4("tile-1-corner-right-bottom", true),  //8
	platform5("tile-1-corner-right-top", true),  //9
	NULL("starfield_02", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
