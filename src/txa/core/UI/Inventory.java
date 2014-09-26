package txa.core.UI;

import java.io.Console;
import java.util.HashMap;
import java.util.Map.Entry;

import txa.core.player.Player;
import txa.core.world.Item;

public class Inventory extends UI {
	
	public Inventory() {
		super("Inv");
	}
	
	public void processCommand(Console c, Player p) {
		String[] command = c.readLine("<%S>: ",name).split(" ");
		HashMap<String, Item> inv= p.getInventory();
		switch(command[0])
		{
			case "exit":
			case "e":
			{
				p.currentUI=EnumUI.NOTHING.getUI();
			}	
			break;
			
			case "list":
			case "l":
			{
				System.out.printf("<%S>: You are Carring following items:\n",name);
				//get all values
				for(Item e:inv.values())
				{	//get pairs of keys and values 
					 for (Entry<String, Item> entry : inv.entrySet()) {
					        if (e.equals(entry.getValue())) {//if key is equal to the value
					        	if(e.isVisible())//and is visible
					        	System.out.println("Item: "+entry.getKey()+" "+e.getName());//spit it out
					        	break;//continue with next value
					        }
					    }			
				};
				System.out.println();
			}
			break;	
			
			case "drop":
			case "d":
			{
				if(command.length<2)
					break;
				
				String ID = command[1];
				Item i = p.removeItem(ID);
				
				if( i != null )
				{
					System.out.printf("<%S>: You dropped %S.\n", name, i.getName());				
					p.getLocation().addItem(i);
				}
				else
				System.out.printf("<%S>: Item not in your possesion.\n",name);
			}
			break;	
			
			case "inspect":
			case "i":
			{
				if(command.length<2)
					break;
				
				String ID = command[1];
				Item i = p.getItem(ID);
				
				if( i != null )
				{
					System.out.printf("<%S>: You Inspect %S.\n%S\n", name, i.getName(), i.getDescription());				
				}
				else
				System.out.printf("<%S>: Item not in your possesion.\n",name);
			}
			break;	
			
			case "use":
			case "u":
			{
				if(command.length<2)
					break;
				
				String ID = command[1];
				Item i = p.getItem(ID);
				
				if( i != null )
				{				
					System.out.printf("<%S>: You Try to Use %S.\n", name, i.getName());	
					i.use(p);
				}
				else
				System.out.printf("<%S>: Item not in your possesion.\n",name);
			}
			break;	
		
			default:
			{
				System.out.printf("<%S>: Command not recognised!\n",name);
			}
			break;
		}
		return;

	}

}
