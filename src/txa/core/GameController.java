package txa.core;

public class GameController {
	protected static Game game;
	public GameController(Game g) 
	{
		
	game=g;
	
	}
	
	public static Game getGame()
	{
		return game;
	}
}
