package txa.core.command;

import txa.core.GameController;
import txa.core.player.Player;
import txa.core.world.Place;

public class Move extends Command {
	//aliases
	private final static String[] COMMAND = {"goto","g","moveto","m"};
	
	public Move() {
		
		super(COMMAND, 2," <Exit>");
	}

	@Override
	//work!
	public void execute(String[] command) throws ExeptionNotEnoughArguments {
		super.execute(command);
		
		//get player and location
		Player p = GameController.getGame().getPlayer();
		Place currloc = p.getLocation();
		
		//If you can find that exit and player can see it.
		if(command[1] != null && currloc.getExit(command[1]) != null && currloc.getExit(command[1]).isVisible())
			{
					//if it actually goes somewhere
					if(currloc.getExit(command[1]).getTarget() != null)
						//go in
						currloc.getExit(command[1]).getTarget().enter(p);
					else
					//say nope
					System.out.println(currloc.getExit(command[1]).getName()+" is locked.");
					
					return;
			}
		//inform player he misspelled stuff
		System.out.println("<EXIT> "+command[1]+" is nowhere to be found.");
		System.out.println("Try one of following exits:");
		//list the exits
		currloc.list();

		
		
	}

}
