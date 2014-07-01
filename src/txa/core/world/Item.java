package txa.core.world;

import txa.core.player.Player;

public class Item {

	private boolean visible;
	private String description;
	private String name;
	private final String ID;
		
	public Item(String ID,String n)
	{
		this(ID,n,"",true);
	}
	
	public Item(String ID,String n,Boolean v)
	{
		this(ID,n,"",v);
	}
	
	public Item(String ID,String name, String description,Boolean visible)
	{
		this.ID=ID;
		this.name = name;
		this.description= description;
		this.visible = visible;
	}
	
	public void use(Player p)
	{
		
		
	}
	public boolean isPickupable(Player p)
	{
		return true;
	}
	

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}
	
	public String getID() {
		return ID;
	}

	public void setName(String name) {
		this.name = name;
	}

}
