package txa.core.UI;

import java.io.Console;

import txa.core.player.Player;

public abstract class UI {
	protected boolean pausegame;
	protected String name;
	
	public UI(String name) 
	{
		this.name=name;
		pausegame=true;
	}

	public boolean isgamePaused() {
		return pausegame;
	}

	public abstract void processCommand(Console c,Player p);

}
