package helpers;

import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Art {
	public static final int WIDTH = 1280, HEIGHT = 860;
	
	public static void Begin() {
		Display.setTitle("SPACEPIONEERTURRENT");
		try {
			Display.setDisplayMode(new DisplayMode(1240, 860));
			Display.create();
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,1240,860,0,1,-1);
		glMatrixMode(GL_MODELVIEW);
		}
	public static void DrawQuad(float x, float y, float width, float height) {
		glBegin(GL_QUADS);
		glVertex2f(x, y);
		glVertex2f(x + width, y);
		glVertex2f(x + width, y + height);
		glVertex2f(x , y + height);
		glEnd();
	}
}
