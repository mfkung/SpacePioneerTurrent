package com.mygdx.game.desktop;

import static helpers.Art.QuickLoad;
import static helpers.Art.DrawQuadTex;
import static helpers.Clock.*;

import org.lwjgl.input.Mouse;

import UserInterface.Button;
import UserInterface.UI;
import helpers.StateManager;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private float time;
	private WaveManager waveManager;
	private WaveManager waveManager5;
	private WaveManager waveManager4;
	private WaveManager waveManager3;
	private WaveManager waveManager2;
	private UI PickerUI;
	private Enemy[] enemyTypes;
	public static final int TILE_SIZE = 64;

	public Game(int[][] map) {
		grid = new TileGrid(map);
		Enemy[] enemyTypes = new Enemy[2];
		enemyTypes[0] = new EnemySpaceShip(19, 4, grid);
		enemyTypes[1] = new Asteroids(19, 6, grid);
		waveManager = new WaveManager(enemyTypes, 3, 3);
		
		player = new Player(grid, waveManager);
		player.setup();
		setupUI();
	}
	
	private void setupUI() {
		PickerUI = new UI();
		//PickerUI.addButton("TurrentBlack", "rocket3", 0, 0);
		//PickerUI.addButton("TurrentSlow", "rocket4", 64, 0);
		PickerUI.createMenu("TurrentPicker", 24, 792, 10, 2);
		PickerUI.getMenu("TurrentPicker").addButton(new Button("TurrentBlack", QuickLoad("rocket3"), 0, 0));
		PickerUI.getMenu("TurrentPicker").addButton(new Button("TurrentSlow", QuickLoad("rocket4"), 0, 0));
		//PickerUI.getMenu("TurrentPicker").addButton(new Button("TurrentSlow", QuickLoad("rocket4"), 0, 0));
		//PickerUI.getMenu("TurrentPicker").addButton(new Button("TurrentSlow", QuickLoad("rocket4"), 0, 0));
		//PickerUI.getMenu("TurrentPicker").addButton(new Button("TurrentSlow", QuickLoad("rocket4"), 0, 0));
		
	}
	
	private void updateUI() {
		PickerUI.draw();
		PickerUI.drawString(960, 740, "Lives: " + Player.Lives);
		PickerUI.drawString(1120, 740, "Metal Scrap: " + Player.Scrap);
		PickerUI.drawString(0, 0, StateManager.framesInLastSecond + " fps");
		
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if(PickerUI.getMenu("TurrentPicker").isButtonClicked("TurrentBlack"))
					player.pickTurrent(new TurrentBlack(TowerType.TurrentBlack, grid.GetTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
				else if(PickerUI.getMenu("TurrentPicker").isButtonClicked("TurrentSlow"))
					player.pickTurrent(new TurrentSlow(TowerType.TurrentSlow, grid.GetTile(0, 0), waveManager.getCurrentWave().getEnemyList()));
			}
		}
	}
	
	public void update() {
		//DrawQuadTex(QuickLoad("menuPicker"), 0 , 768, 1280,256 );
		time += Delta();
		grid.Draw();
		//black.draw();
	//	if (time > 4)
			waveManager.update();
	/*	if (time > 6)
			waveManager5.update();
		if (time > 10)
			waveManager4.update();
		if (time > 17)
			waveManager3.update();
		if (time > 20)
			waveManager2.update(); */
		player.update();
		PickerUI.draw();
		updateUI();
	}
}
