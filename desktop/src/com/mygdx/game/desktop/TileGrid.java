package com.mygdx.game.desktop;
import static helpers.Art.*;
public class TileGrid {
	
	public Tile[][] map;
	
	public TileGrid() {
		map = new Tile[12][8];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = new Tile(i * 160, j * 160, 160, 160, TileType.Ground);
				
			}
		}
	}
	public TileGrid(int[][] newMap) {
		map = new Tile[12][8];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {	
				if (newMap[j][i] == 1)
					map[i][j] = new Tile(i * 160, j * 160, 160, 160, TileType.Ground);
				else if (newMap[j][i] == 2)
					map[i][j] = new Tile(i * 160, j * 160, 160, 160, TileType.Ground2);
				else if (newMap[j][i] == 3)
					map[i][j] = new Tile(i * 160, j * 160, 160, 160, TileType.Ground3);
				else if (newMap[j][i] == 4)
					map[i][j] = new Tile(i * 160, j * 160, 160, 160, TileType.Ground4);
				else if (newMap[j][i] == 5)
					map[i][j] = new Tile(i * 160, j * 160, 160, 160, TileType.GroundM);
			}
		}
	}
	public void SetTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord * 160, yCoord * 160, 160, 160, type);
	}
	public Tile GetTile(int xCoord, int yCoord) {
		return map[xCoord][yCoord];
	}
	public void Draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				Tile t = map[i][j];
				DrawQuadTex(t.getTexture(), t.getX(), t.getY(), t.getWidth(), t.getHeight());
			}
		}
	}
}
