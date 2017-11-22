package UserInterface;

import java.awt.Font;
import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;

import static helpers.Art.*;

public class UI {
	
	private ArrayList<Button> buttonList;
	private ArrayList<Menu> menuList;
	private TrueTypeFont font;
	private Font awtFont;
	
	public UI() {
		buttonList = new ArrayList<Button>();
		menuList = new ArrayList<Menu>();
		awtFont = new Font("JasminUPC", Font.BOLD, 20);
		font = new TrueTypeFont(awtFont, false);
	}
	
	public void drawString(int x, int y, String text) {
		font.drawString(x, y, text);
	}
	
	public void addButton(String name, String textureName, int x, int y) {
		buttonList.add(new Button(name, QuickLoad(textureName), x, y));
	}
	
	public boolean isButtonClicked(String buttonName) {
		Button b = getButton(buttonName);
		float mouseY = HEIGHT - Mouse.getY() - 1;
		if (Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() &&
				mouseY > b.getY() && mouseY < b.getY() + b.getHeight()) {
			return true;
		}
		return false;
	}
	
	private Button getButton(String buttonName) {
		for (Button b: buttonList) {
			if (b.getName().equals(buttonName)) {
				return b;
			}
		}
		return null;
	}
	
	public void createMenu(String name, int x, int y, int optionWidth, int optionHeight) {
		menuList.add(new Menu(name, x, y, optionWidth, optionHeight));
	}
	
	public Menu getMenu(String name) {
		for (Menu m: menuList)
			if(name.equals(m.getName()))
				return m;
		return null;
	}
	
	public void draw() {
		for (Button b: buttonList)
			DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		for (Menu m: menuList)
			m.draw();
	}
	
	public class Menu {
		String name;
		private ArrayList<Button> menuButtons;
		private int x, y, buttonAmount, optionWidth, optionHeight;
		public Menu(String name, int x, int y, int optionWidth, int optionHeight) {
			this.name = name;
			this.x = x;
			this.y = y;
			this.optionWidth = optionWidth;
			this.optionHeight = optionHeight;
			this.buttonAmount = 0;
			this.menuButtons = new ArrayList<Button>();
		}
				
		public void addButton(Button b) {
			if (optionWidth != 0)
				b.setY(y + (buttonAmount / optionWidth) * 64);
			b.setX(x + (buttonAmount % optionWidth) * 64);
			buttonAmount++;
			menuButtons.add(b);
		}
		
		public boolean isButtonClicked(String buttonName) {
			Button b = getButton(buttonName);
			float mouseY = HEIGHT - Mouse.getY() - 1;
			if (Mouse.getX() > b.getX() && Mouse.getX() < b.getX() + b.getWidth() &&
					mouseY > b.getY() && mouseY < b.getY() + b.getHeight()) {
				return true;
			}
			return false;
		}
		
		private Button getButton(String buttonName) {
			for (Button b: menuButtons) {
				if (b.getName().equals(buttonName)) {
					return b;
				}
			}
			return null;
		}
		
		public void draw() {
			for (Button b: menuButtons)
				DrawQuadTex(b.getTexture(), b.getX(), b.getY(), b.getWidth(), b.getHeight());
		}
		
		public String getName() {
			return name;
		}
	}

}
