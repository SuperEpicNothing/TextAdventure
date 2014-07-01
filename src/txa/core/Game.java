package txa.core;

import java.io.Console;
import java.util.HashMap;

import txa.core.command.Command;
import txa.core.command.Examine;
import txa.core.command.ExeptionNotEnoughArguments;
import txa.core.command.Move;
import txa.core.command.Pickup;
import txa.core.player.Player;
import txa.core.world.Place;

public class Game {
	
	protected Player player;
	protected HashMap<String , Place > world;
	public static HashMap<String, Command> commands;
	protected Console c;
	public boolean close;
	
	public Game(Console c)
	{
		this.c=c;
		close=false;
		clear();
		player=createPlayer();
		world = new HashMap<String , Place> ();
		commands = new HashMap<String, Command>();
		initCommands();
		setupWorld(player);			
	}
	//iruwghbihgr9
	//regrgg
	//hi tst
	
	public Player getPlayer()
	{
		return player;		
	}

	public void clear()
	{
		for(int i=0;i<23;i++)
			System.out.print("                                                                                                    ");
		
	}
	
	public void initCommands()
	{
		new Move();
		new Examine();
		new Pickup();

	}

	public void update() {
		processCommand();
		
		if(close)
			processClose();
	}
	
	protected void processCommand()
	{
		String[] command=c.readLine("What do You want to do?\n").toLowerCase().split(" ");
		
		try{
			
		if(command.length >= 1 && commands.get(command[0])!=null)
			commands.get(command[0]).execute(command);
		else
			System.out.println("The command has not been recognised.");			
		}
		catch (ExeptionNotEnoughArguments e) {
			System.out.println("Not Enough Arguments, correct use:");
			System.out.println(e.getMessage());
		}
	}
	
	protected void processClose()
	{
		
	}

	protected void setupWorld(Player p) {}



	protected Player createPlayer() {

		return new Player(c.readLine("What is Your name?\n"));
	}

}
