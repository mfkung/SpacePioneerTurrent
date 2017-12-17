package helpers;


import com.mygdx.game.desktop.Game;
import com.mygdx.game.desktop.GameClear;
import com.mygdx.game.desktop.GameOver;
import com.mygdx.game.desktop.MainMenu;

public class StateManager {
	
	public static enum GameState {
		MAINMENU, GAME , GAMEOVER, GAMECLEAR
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static GameOver gameOver;
	public static GameClear gameClear;

	public static Game game;
	public static long nextSecond = System.currentTimeMillis() + 1000;
	public static int framesInLastSecond = 0;
	public static int framesInCurrentSecond = 0;

	
	static int[][] map = {
			{1, 1, 1, 3, 1, 3, 1, 1, 1, 1, 1, 1, 7, 4, 4, 1, 1, 1, 1, 1},
			{1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 4, 1, 1, 4, 1, 4, 4},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{4, 4, 9, 1, 4, 1, 4, 4, 4, 4, 4, 4, 9, 1, 1, 1, 1, 1, 5, 3},
			{1, 1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6, 9, 1, 1, 4, 4, 4, 8},
			{1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 4, 1, 1, 3, 1, 1, 1, 1, 1, 1},
			{7, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 1, 7, 8, 1, 1, 1, 1, 1, 1},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4},
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
			{6, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
			
	};
	
	public static void update() {
		switch(gameState) {
		case MAINMENU:
			if (mainMenu == null)
				mainMenu = new MainMenu();
			mainMenu.update();
			break;
			
		case GAME:
			if (game == null)
				game = new Game(map);
			game.update();
			break;
			
		case GAMEOVER:
			if (gameOver == null)
				gameOver = new GameOver();
			gameOver.update();
			break;
		case GAMECLEAR:
			if (gameClear == null)
				gameClear = new GameClear();
			gameClear.update();
			break;
			
		}
		long currentTime = System.currentTimeMillis();
		if (currentTime > nextSecond) {
			nextSecond += 1000;
			framesInLastSecond = framesInCurrentSecond;
			framesInCurrentSecond = 0;
		}
		
		framesInCurrentSecond++;
	}
	
	public static void setState(GameState newState) {
		gameState = newState;
	}

}
