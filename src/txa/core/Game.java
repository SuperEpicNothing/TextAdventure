package txa.core;

import java.io.Console;
import java.util.HashMap;

import txa.core.command.Command;
import txa.core.command.Examine;
import txa.core.command.ExeptionNotEnoughArguments;
import txa.core.command.Inventory;
import txa.core.command.Move;
import txa.core.command.Pickup;
import txa.core.player.Player;
import txa.core.world.Place;

public class Game {
	
	//data!
	protected Player player;
	protected HashMap<String , Place > world;
	public static HashMap<String, Command> commands;
	protected Console c;
	public boolean close;
	
	//lets call all the stuff we need.
	public Game(Console c)
	{
		//store the console, it is possible we may need it.
		this.c=c;
		//set end condition to false 
		close=false;
		//clear screen
		clear();
		//self explanatory
		player=createPlayer();
		world = new HashMap<String , Place> ();
		commands = new HashMap<String, Command>();
		//create all the possible commands ever
		initCommands();
		//create the world with player in it.
		setupWorld(player);			
	}

	public Player getPlayer()
	{
		return player;		
	}
	
	//function for "clearing" the screen
	public void clear()
	{
		for(int i=0;i<23;i++)
			System.out.print("                                                                                                    ");
		
	}
	
	//TODO: create print functions here so i can add GUI later.
	
	
	//this is how i create commands
	public void initCommands()
	{
		new Move();
		new Examine();
		new Pickup();
		new Inventory();

	}
	
	//update function  , because all games need one
	public void update() {
		//player.
		//if player is not in ui
		if(player.currentUI == null)
		{
		//update game
		updategame();
		//process  the command 	
		processCommand();
		}
		else
		{
			//if ui is not paused
			if(!player.currentUI.isgamePaused())
			updategame();
			
			player.currentUI.processCommand(c,player);					
		}
		
		if(close)
			processClose();
	}
	
	protected void updategame()
	{
		
	}
	
	//this is processing stuff player says
	protected void processCommand()
	{
		//ask him stuff
		String[] command=c.readLine("What do You want to do?\n").toLowerCase().split(" ");
		
		//not sure if it is efficient but OK.
		try{
			
			//get the command
		if(command.length >= 1 && commands.get(command[0])!=null)
			//execute it
			commands.get(command[0]).execute(command);
		else
			//or not
			System.out.println("The command has not been recognised.");			
		}
		
		catch (ExeptionNotEnoughArguments e) {
			//shit happens
			System.out.println("Not Enough Arguments, correct use:");
			System.out.println(e.getMessage());
		}
		
		
	}
	
	//Basically a game over/ save screen.
	protected void processClose()
	{
		
	}

	//create shit.
	protected void setupWorld(Player p) {}


	//and player
	protected Player createPlayer() {

		return new Player(c.readLine("What is Your name?\n"));
	}

}
