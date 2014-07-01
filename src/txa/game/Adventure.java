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
	
	@Override
	protected void setupWorld(Player p) 
	{ 
		HashMap<String, Exit> e = new HashMap<String, Exit>();
		HashMap<String, Item> i = new HashMap<String, Item>();
		e.put(AdvString.getString("Adventure.place.id.0"),
				new Exit(null, AdvString.getString("Adventure.place.name.0"), 
				AdvString.getString("Adventure.place.desc.0"), true)); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		e.put(AdvString.getString("Adventure.place.id.1"),
				new Exit(null, AdvString.getString("Adventure.place.name.1"))); //$NON-NLS-1$ //$NON-NLS-2$
		
		world.put(AdvString.getString("Adventure.place.name.2"),
				new Place(null, AdvString.getString("Adventure.place.name.2"), AdvString.getString("Adventure.place.desc.1"))); //$NON-NLS-1$ //$NON-NLS-2$
		i.put("key", 
				new Item("key","The Golden Key", "The key is made of gold\n"
										 + "It seems to hold immesurable power." , true)
				);
		
		
		world.get(AdvString.getString("Adventure.place.name.2")).addExits(e);
		world.get(AdvString.getString("Adventure.place.name.2")).addItems(i);
		world.get(AdvString.getString("Adventure.place.name.2")).enter(p);

		
		e = new HashMap<String, Exit>();
		i = new HashMap<String, Item>();
		world.put(AdvString.getString("Adventure.place.name.3") ,
				new Place(null, AdvString.getString("Adventure.place.name.3"),AdvString.getString("Adventure.place.desc.2"))); //$NON-NLS-1$ //$NON-NLS-2$
		world.get(AdvString.getString("Adventure.place.name.2")).addExits(e);
		world.get(AdvString.getString("Adventure.place.name.2")).addItems(i);
		
		world.get(AdvString.getString("Adventure.place.name.2"))
			.getExit(AdvString.getString("Adventure.place.id.0"))
			.setTarget(world.get(AdvString.getString("Adventure.place.name.3"))); //$NON-NLS-1$
	}

}
