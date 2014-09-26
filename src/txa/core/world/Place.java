package txa.core.world;

import java.util.HashMap;
import java.util.Map.Entry;

import txa.core.player.Player;

public class Place {
	
	
	//data!
	protected String description;
	protected String name;
	protected HashMap<String,Exit> exits;
	protected HashMap<String,Item> items;

	//create a place with existing exits
	public Place(HashMap<String,Exit> e,String n,String d)
	{ 
		name=n;
		description=d;
		
		if(e != null)
		exits=e;
		else
		exits=new HashMap<String,Exit>();
		
		items=new HashMap<String,Item>();
	}
	//getters and setters
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	//a set of get add and remove stuff
	public HashMap<String,Exit> getExits(){
		return exits;
	}
	
	public Exit getExit(String key)
	{
		return exits.get(key);
	}
	public void addExit(String key,Exit e)
	{
		exits.put(key, e);
	}
	public void addExits(HashMap<String,Exit> m)
	{
		exits.putAll(m);
	}
	public void removeExit(Exit e)
	{
		exits.remove(e);
	}
	
	
	//a set of get add and remove stuff
	public HashMap<String,Item> getItems(){
		return items;
	}
	
	public Item getItem(String key)
	{
		return items.get(key);
	}
	public void addItem(Item e)
	{
		items.put(e.getID(), e);
	}
	public void addItems(HashMap<String,Item> m)
	{
		items.putAll(m);
	}
	public void removeItem(Item e)
	{
		items.remove(e);
	}
	
	//lists every thing in a place
	public void list()
	{
		//get all values
		for(Exit e:exits.values())
		{		
			//get pairs of keys and values 
			 for (Entry<String, Exit> entry : exits.entrySet()) {
				 //if key is equal to the value
				 if (e.equals(entry.getValue())) {
			        	if(e.isVisible())//and is visible
			        	System.out.println("Exit: "+entry.getKey()+" "+e.getName());//spit it out
			        	break;//continue with next value
			        }
			    }			
		}
		
		//get all values
		for(Item e:items.values())
		{	//get pairs of keys and values 
			 for (Entry<String, Item> entry : items.entrySet()) {
			        if (e.equals(entry.getValue())) {//if key is equal to the value
			        	if(e.isVisible())//and is visible
			        	System.out.println("Item: "+entry.getKey()+" "+e.getName());//spit it out
			        	break;//continue with next value
			        }
			    }			
		}
	}

	//when player enters the room this happens is mostly describes the room
	public void enter(Player p) {
		System.out.println();
		System.out.println(p.getName()+" enters "+name);
		System.out.println(description);
		System.out.println();
		list();
		System.out.println();

		p.setLocation(this);
	}
	public void update() {
		
	}


	

}
