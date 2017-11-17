package com.mygdx.game.desktop;

import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;
import static helpers.Clock.*;
import helpers.StateManager;

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
	public static final int WIDTH = 1280, HEIGHT = 1152;
	
	public DesktopLauncher() {
		Begin();

		
		//Game game = new Game(map);
		while(!Display.isCloseRequested()) {
			Clock.update();
			
			//game.update();
			StateManager.update();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
	}

	public static void main (String[] arg) {
		new DesktopLauncher();
	}
}
