package com.mygdx.game.desktop;


import helpers.Clock;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Art.*;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<Turrent> towerList;
	private boolean leftMouseButtonDown;
	
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.createablefield;
		this.types[1] = TileType.enemyfield;
		this.types[2] = TileType.starfield;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Turrent>();
		this.leftMouseButtonDown = false;
	}
	
	
	
	public void update() {
		for (Turrent t : towerList) {
			t.update();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		//Handle Mouse Input
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			towerList.add(new Turrent(QuickLoad("rocket2"), grid.GetTile(Mouse.getX() / 64, (HEIGHT - Mouse.getY() - 1) / 64), 10 , 1000, waveManager.getCurrentWave().getEnemyList()));
			//setTile();
		}
		leftMouseButtonDown = Mouse.isButtonDown(0);
		
		//Handle Keyboard Input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(0.2f);
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()) {
				Clock.ChangeMultiplier(-0.2f);
			}
			//if (Keyboard.getEventKey() == Keyboard.KEY_T && Keyboard.getEventKeyState()) {
			//	towerList.add(new Turrent(QuickLoad("rocket2"), grid.GetTile(18, 9), 10, 1000, waveManager.getCurrentWave().getEnemyList()));
			//}
		}
	}
	
	
}
