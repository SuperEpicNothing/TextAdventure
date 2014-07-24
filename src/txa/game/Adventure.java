package txa.game;

import java.io.Console;
import java.util.HashMap;

import txa.core.Game;
import txa.core.player.Player;
import txa.core.world.Exit;
import txa.core.world.Item;
import txa.core.world.Place;

public class Adventure extends Game {

	public Adventure(Console c) {
		super(c);
	}
	//this is a "Demo game" it is using the "engine" to create the game.
	@Override
	protected void setupWorld(Player p) 
	{ 
		HashMap<String, Exit> e = new HashMap<String, Exit>();
		HashMap<String, Item> i = new HashMap<String, Item>();
		
		e.put("mystdoor",
				new Exit(null, "Mysterious Door", 
				"The Black Door seems to be emmiting a glow.\n"
						+ "On the door You can see a text written in  blood reading:"
						+ "\n\t \"The Ones who enter the Void shall not return \"", true));
		e.put("entrance",
				new Exit(null, "Entrance")); 
		
		world.put("The Room",
				new Place(null, "The Room", "The dark room appears to be small. "
						+ "\nYou do not sense any presence."
						+ "\nYou see a dark door in front of you." ));
		i.put("key", 
				new Item("key","The Golden Key", "The key is made of gold\n"
										 + "It seems to hold immesurable power." , true)
				);
		
		
		world.get("The Room").addExits(e);
		world.get("The Room").addItems(i);
		world.get("The Room").enter(p);

		
		e = new HashMap<String, Exit>();
		i = new HashMap<String, Item>();
		world.put("The Void" ,
				new Place(null, "The Void","All you can see is empty blackness."
						+ "\nThere is no escape."));
		world.get("The Room").addExits(e);
		world.get("The Void").addItems(i);
		
		world.get("The Room")
			.getExit("mystdoor")
			.setTarget(world.get("The Void"));
	}

}
