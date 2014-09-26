package txa.core.command;

import txa.Main;
import txa.core.GameController;
import txa.core.player.Player;

public class Examine extends Command {

	//possible aliases 
	private final static String[] COMMAND = {"examine","e"};

	public Examine() {
		super(COMMAND, 3, " <world|w|inventory|i> <object>");
	}
	
	@Override
	//work!
	public void execute(String[] command) throws ExeptionNotEnoughArguments {
		super.execute(command);
		String item=command[2];
		Player p = GameController.getGame().getPlayer();
		
		switch(command[1])
		{
			case "world":
			case "w":
			{
				if(p.getLocation().getExit(item) != null && p.getLocation().getExit(item).isVisible())
				{
					System.out.println(p.getLocation().getExit(item).getDescription());
				}
				else if(p.getLocation().getItem(item) != null && p.getLocation().getItem(item).isVisible())
				{
					System.out.println(p.getLocation().getItem(item).getDescription());
				}
				else
				{
					System.out.println("No such Object has been found.");
				}
				
				
			}
			break;
			
			case "inventory":
			case "i":
			{
				if(p.getItem(item) != null)
				{
					System.out.println(p.getItem(item).getDescription());
				}
				else
				{
					System.out.println("You do not posses such Item.");
				}
			}
			break;							
		}
		
		
		
	}

}
