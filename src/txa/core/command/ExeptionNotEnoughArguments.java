package txa.core.command;

public class ExeptionNotEnoughArguments extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4588920362609068760L;

	public ExeptionNotEnoughArguments(String commandUse) 
	{
		super(commandUse);
	}
}
