package txa.core.command;

import txa.Main;
import txa.core.UI.EnumUI;

public class Inventory extends Command {

	//possible aliases 
	private final static String[] COMMAND = {"inventory","i"};
	public Inventory() {
		super(COMMAND, 1, "");
	}
	
	//work
	@Override
	public void execute(String[] command) throws ExeptionNotEnoughArguments {
		super.execute(command);
		Main.getGame().
		getPlayer()
		.currentUI = EnumUI.INVENTORY.getUI();
	}
}
