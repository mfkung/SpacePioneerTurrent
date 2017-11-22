package com.mygdx.game.desktop;


import org.lwjgl.opengl.Display;

import static helpers.Art.*;

import helpers.StateManager;



import helpers.Clock;



public class DesktopLauncher {
	
	public static final int WIDTH = 1280, HEIGHT = 1152;
	
	public DesktopLauncher() {
		//call Begin from Art class to init OpenGl 
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
