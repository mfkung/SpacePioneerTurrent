package com.mygdx.game.desktop;

import static helpers.Art.QuickLoad;

public class Game {
	
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	public static final int TILE_SIZE = 64;

	public Game(int[][] map) {
		grid = new TileGrid(map);
		waveManager = new WaveManager(new Enemy(QuickLoad("spaceship"), grid.GetTile(19, 7), grid, 64, 64, 70),
				2, 2);
		player = new Player(grid, waveManager);
	}
	
	public void update() {
		grid.Draw();
		waveManager.update();
		player.update();
		
	}
}
