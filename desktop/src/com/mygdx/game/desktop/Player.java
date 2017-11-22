package com.mygdx.game.desktop;


import helpers.Clock;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import static helpers.Art.*;

public class Player {

	private TileGrid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	private boolean leftMouseButtonDown, holdingTurrent;
	private Tower tempTurrent;
	public static int Scrap, Lives;
	
	public Player(TileGrid grid, WaveManager waveManager) {
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.createablefield;
		this.types[1] = TileType.enemyfield;
		this.types[2] = TileType.starfield;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
		this.leftMouseButtonDown = false;
		this.holdingTurrent = false;
		this.tempTurrent = null;
		Scrap = 0;
		Lives = 0;
	}
	
	public void setup() {
		Scrap = 50;
		Lives = 10;
	}
	
	public static boolean modifyScrap (int amount) {
		if (Scrap + amount >= 0) {
			Scrap += amount;
			System.out.println(Scrap);
			return true;
		}
		System.out.println(Scrap);
		return false;
	}
	
	public static void modifyLives(int amount) {
		Lives += amount;
	}
	
	public void update() {
		if (holdingTurrent) {
			tempTurrent.setX(getMouseTile().getX());
			tempTurrent.setY(getMouseTile().getY());
			tempTurrent.draw();
		}
		for (Tower t : towerList) {
			t.update();
			t.draw();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		//Handle Mouse Input
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown) {
			placeTurrent();
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
	
	private void placeTurrent() {
		Tile currentTile = getMouseTile();
		if (holdingTurrent)
			if (!currentTile.getOccupied() && modifyScrap(-tempTurrent.getCost())) {
				towerList.add(tempTurrent);
				currentTile.setOccupied(true);
				holdingTurrent = false;
				tempTurrent = null;
			}
	}
	
	public void pickTurrent(Tower t) {
		tempTurrent = t;
		holdingTurrent = true;
	}
	
	private Tile getMouseTile() {
		return grid.GetTile(Mouse.getX() / 64, (HEIGHT - Mouse.getY() - 1) / 64);
	}
	
	
}
