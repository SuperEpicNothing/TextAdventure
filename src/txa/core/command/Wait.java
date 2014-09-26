package txa.core.command;

public class Wait extends Command {
	private static String[] keys = {"wait"};
	public Wait() {
		super(keys, 1, "");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(String[] command) throws ExeptionNotEnoughArguments {
		super.execute(command);
		System.out.print("\n You decide to wait.");
	}

}
