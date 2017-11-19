package com.mygdx.game.desktop;

import static helpers.Art.QuickLoad;
import static helpers.Clock.*;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private float time;
	private WaveManager waveManager;
	private WaveManager waveManager5;
	private WaveManager waveManager4;
	private WaveManager waveManager3;
	private WaveManager waveManager2;
	private TurrentBlack black;
	public static final int TILE_SIZE = 64;

	public Game(int[][] map) {
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 3), grid, 64, 64, 70, 25),
				10, 2);
		waveManager2 = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 5), grid, 64, 64, 70, 25),
				12, 2);
		waveManager3 = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 7), grid, 64, 64, 70, 25),
				6, 2);
		waveManager4 = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 9), grid, 64, 64, 70, 25),
				15, 2);
		waveManager5 = new WaveManager(new Enemy(QuickLoad("ss"), grid.GetTile(19, 11), grid, 64, 64, 70, 25),
				20, 2);  
		player = new Player(grid, waveManager);
		black = new TurrentBlack(QuickLoad("rocket3"), 128, 128, 64, 64);
	}
	
	public void update() {
		time += Delta();
		grid.Draw();
		black.draw();
		if (time > 4)
			waveManager.update();
		if (time > 6)
			waveManager5.update();
		if (time > 10)
			waveManager4.update();
		if (time > 17)
			waveManager3.update();
		if (time > 20)
			waveManager2.update(); 
		player.update();

		
	}
}
