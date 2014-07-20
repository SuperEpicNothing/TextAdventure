package txa.core.command;

import txa.core.GameController;
import txa.core.player.Player;

public class Pickup extends Command {
	//aliases
	private final static String[] COMMAND = {"pickup","p"};
	public Pickup() {
		super(COMMAND, 2, " <Item>");
	}
	
	//WIP
	@Override
	public void execute(String[] command) throws ExeptionNotEnoughArguments {
		super.execute(command);
		
		String item = command[1];
		Player p =GameController.getGame().getPlayer();

		
		if(p.getLocation().getItem(item) != null && p.getLocation().getItem(item).isVisible() && p.getLocation().getItem(item).isPickupable(p))
		{
			System.out.println("You picked up " + p.getLocation().getItem(item).getName());
			p.addItem(p.getLocation().getItem(item));
		}
		else if(p.getLocation().getItem(item).isPickupable(p))
			System.out.println("You can't pick this up.");
		else
		{
			System.out.println("No such Object has been found.");
		}
	}

}
