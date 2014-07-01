package txa.core.command;

import txa.Main;
import txa.core.player.Player;
import txa.core.world.Place;

public class Move extends Command {

	private final static String[] COMMAND = {"goto","g","moveto","m"};
	
	public Move() {
		
		super(COMMAND, 2," <Exit>");
	}

	@Override
	public void execute(String[] command) throws ExeptionNotEnoughArguments {
		super.execute(command);
		
		Player p = Main.getGame().getPlayer();
		Place currloc = p.getLocation();
		
		if(command[1] != null && currloc.getExit(command[1]) != null && currloc.getExit(command[1]).isVisible())
			{
					if(currloc.getExit(command[1]).getTarget() != null)
						currloc.getExit(command[1]).getTarget().enter(p);
					else
					System.out.println(currloc.getExit(command[1]).getName()+" is locked.");
					
					return;
			}
		
		System.out.println("<EXIT> "+command[1]+" is nowhere to be found.");
		System.out.println("Try one of following exits:");
		currloc.list();

		
		
	}

}
