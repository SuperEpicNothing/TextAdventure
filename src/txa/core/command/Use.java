package txa.core.command;

import txa.core.GameController;
import txa.core.player.Player;

public class Use extends Command {

	//aliases
		private final static String[] COMMAND = {"use","u"};
		public Use() {
			super(COMMAND, 2, " <Item>");
		}
		
		@Override
		public void execute(String[] command) throws ExeptionNotEnoughArguments {
			super.execute(command);
			
			String item = command[1];
			Player p = GameController.getGame().getPlayer();

			
			if(p.getLocation().getItem(item) != null && p.getLocation().getItem(item).isVisible())
			{
				System.out.println("You try to use " + p.getLocation().getItem(item).getName());
				p.getLocation().getItem(item).use(p);;
			}
			else
			{
				System.out.println("No such Object has been found.");
			}
		
		}
}
