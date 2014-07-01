package txa.core.command;

import txa.core.Game;

public abstract class Command {
	protected int length;
	protected String commandUse;
//	<angle brackets> 	This is a required argument.
//	[square brackets] 	This is an optional argument.
//	italics 	Replace this with an appropriate value.
//	plain text 	Enter this literally, exactly as shown.
//	x|y 	Pick one of the options shown.
//
//	Available options are shown separated by vertical bars: |
//	ellipsis … 	The argument may consist of multiple words separated by spaces.
	public Command(String[] keys,int length, String commandUse) 
	{
		this.length=length;
		this.commandUse=commandUse;
		String temp = "";
		for(String key:keys)
		{
			Game.commands.put(key.toLowerCase(), this);
			temp+=key.toLowerCase()+"|";
		}
		this.commandUse=temp+commandUse;
		
	}
	
	public void execute(String[] command) throws ExeptionNotEnoughArguments
	{
		if(command.length<length)
			throw new ExeptionNotEnoughArguments(commandUse);
	}
}