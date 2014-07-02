package txa.core.player;

import java.util.HashMap;

import txa.core.world.Item;
import txa.core.world.Place;

public class Player {
	protected String name;
	protected Place location;
	protected HashMap<String,Item> inventory;

	//going comment it when i get to it
	public Player(String n)
	{
		name=n;
		inventory = new HashMap<String,Item>();
	}
	public Place getLocation() {
		return location;
	}
	public void setLocation(Place location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
		
	public Item getItem(String key)
	{
		return inventory.get(key);
	}
	public Item removeItem(String key)
	{
		Item item = inventory.get(key);
		inventory.remove(item);
		return item;
	}
	
	public void addItem(Item e)
	{
		inventory.put(e.getID(), e);
	}
	public void addItems(HashMap<String,Item> m)
	{
		inventory.putAll(m);
	}
	
}
