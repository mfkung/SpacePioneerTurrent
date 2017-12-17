package com.mygdx.game.desktop;


public class TileGrid {

	public Tile[][] map;
	private int tilesWide, tilesHigh;
	

	
	public TileGrid(int[][] newMap) {
		this.tilesWide = newMap[0].length;
		this.tilesHigh = newMap.length;
		map = new Tile[tilesWide][tilesHigh];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				switch (newMap[j][i]) {
				case 0:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.reachedend);
					break;
				case 1:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.enemyfield);
					break;
				case 2:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platformH);
					break;
				case 3:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platformV);
					break;
				case 4:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platformHB);
					break;
				case 5:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platform1);
					break;
				case 6:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platform2);
					break;
				case 7:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platform3);
					break;
				case 8:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platform4);
					break;
				case 9:
					map[i][j] = new Tile(i * 64, j * 64, 64, 64, TileType.platform5);
					break;
					
				}
			}
		}
	}
	
	public void SetTile(int xCoord, int yCoord, TileType type) {
		map[xCoord][yCoord] = new Tile(xCoord * 64, yCoord * 64, 64, 64, type);
	}
	
	public Tile GetTile(int xPlace, int yPlace) {
		if (xPlace < tilesWide && yPlace < tilesHigh && xPlace > -1 && yPlace > -1)
			return map[xPlace][yPlace];
		else
			return new Tile(0, 0, 0, 0, TileType.NULL);
	}

	
	public void Draw() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j].Draw();
			}
		}
	}

	public int getTilesWide() {
		return tilesWide;
	}

	public void setTilesWide(int tilesWide) {
		this.tilesWide = tilesWide;
	}

	public int getTilesHigh() {
		return tilesHigh;
	}

	public void setTilesHigh(int tilesHigh) {
		this.tilesHigh = tilesHigh;
	}
	
	
}

