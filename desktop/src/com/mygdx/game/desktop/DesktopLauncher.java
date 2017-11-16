package com.mygdx.game.desktop;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static helpers.Art.*;

import com.mygdx.game.SPTGame;

public class DesktopLauncher {
	public static final int WIDTH = 1240, HEIGHT = 860;
	public DesktopLauncher() {
		Begin();

		
		while(!Display.isCloseRequested()) {

			DrawQuad(50,50,100,100);
			Display.update();
			Display.sync(60);
		}
	}

	public static void main (String[] arg) {
		new DesktopLauncher();
	}
}
