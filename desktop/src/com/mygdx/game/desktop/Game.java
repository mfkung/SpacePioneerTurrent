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
	public static final int TILE_SIZE = 64;

	public Game(int[][] map) {
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 4), grid, 64, 64, 70, 30),
				10, 10);
	/*	waveManager2 = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 5), grid, 64, 64, 70, 25),
				12, 2);
		waveManager3 = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 7), grid, 64, 64, 70, 25),
				6, 2);
		waveManager4 = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 9), grid, 64, 64, 70, 25),
				15, 2);
		waveManager5 = new WaveManager(new Enemy(QuickLoad("ss"), grid.GetTile(19, 11), grid, 64, 64, 70, 25),
				20, 2);  */
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
		//PickerUI.drawString(960, 792, "Lives: " + Player.Lives);
		PickerUI.drawString(1125, 740, "Metal Scrap: " + Player.Scrap);
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
