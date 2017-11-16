package com.mygdx.game.desktop;

import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;
import static helpers.Clock.*;

import com.mygdx.game.SPTGame;

import helpers.Clock;



public class DesktopLauncher {
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	public static final int WIDTH = 1920, HEIGHT = 1280;
	public DesktopLauncher() {
		Begin();
		Random rand = new Random();
		int[][] map = {
				{1,2,3,2,1,2,3,4,1,2,4,3},
				{3,5,3,5,4,5,4,5,2,5,3,5},
				{4,1,4,2,1,2,3,4,3,2,4,1},
				{2,3,1,1,3,4,1,3,4,1,2,3},
				{3,1,2,3,4,1,2,1,4,2,3,1},
				{1,4,3,2,1,2,3,4,1,3,4,2},
				{2,1,4,3,1,2,4,3,1,3,4,2},
				{1,2,3,2,1,2,3,4,1,2,4,3}
				
		};
		
		TileGrid grid = new TileGrid(map);
		//grid.SetTile(3, 4, grid.GetTile(1, 1).getType());
		Enemy enemy = new Enemy(QuickLoad("spaceship"), grid.GetTile(11, 1), 160, 160, 2);
		Wave wave = new Wave(80, enemy);
		while(!Display.isCloseRequested()) {
			Clock.update();
			enemy.Update();
			grid.Draw();
			wave.Update();
			enemy.Draw();
			Display.update();
			Display.sync(60);
		}
	}

	public static void main (String[] arg) {
		new DesktopLauncher();
	}
}
