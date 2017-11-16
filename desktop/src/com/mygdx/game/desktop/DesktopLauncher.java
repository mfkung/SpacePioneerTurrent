package com.mygdx.game.desktop;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;

import com.mygdx.game.SPTGame;

public class DesktopLauncher {
	public static final int WIDTH = 1280, HEIGHT = 960;
	public DesktopLauncher() {
		Begin();

		int[][] map = {
				{1,2,3,2,1,2,3,4},
				{3,5,3,5,4,5,4,5},
				{4,1,4,2,1,2,3,4},
				{2,3,1,1,3,4,1,3},
				{3,1,2,3,4,1,2,1},
				{1,4,3,2,1,2,3,4}
				
		};
		
		TileGrid grid = new TileGrid(map);
		
		while(!Display.isCloseRequested()) {
			grid.Draw();

			Display.update();
			Display.sync(60);
		}
	}

	public static void main (String[] arg) {
		new DesktopLauncher();
	}
}
