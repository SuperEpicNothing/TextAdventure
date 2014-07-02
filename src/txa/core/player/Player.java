package txa.core.player;

import java.util.HashMap;

import txa.core.UI.EnumUI;
import txa.core.UI.Inventory;
import txa.core.UI.UI;
import txa.core.world.Item;
import txa.core.world.Place;

public class Player {
	protected String name;
	protected Place location;
	protected HashMap<String,Item> inventory;
	public UI currentUI;

	//going comment it when i get to it
	public Player(String n)
	{
		currentUI=EnumUI.NOTHING.getUI();
		name=n;
		inventory = new HashMap<String,Item>();
		addItem(new Item("coin","Coin","it is made of Gold",true));
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
		if(item!=null)
		inventory.remove(item);
		
		return item;
	}	
	public HashMap<String,Item> getInventory()
	{
		return inventory;		
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
