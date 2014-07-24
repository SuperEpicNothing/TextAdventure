package txa.core.command;

import txa.core.Game;

public abstract class Command {
	//data!
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
	//this is just for error checks
	public Command(String[] keys,int length, String commandUse) 
	{
		this.length=length;
		this.commandUse=commandUse;
		
		//this generates "how do i use this shit"
		String temp = "";
		for(String key:keys)
		{
			Game.commands.put(key.toLowerCase(), this);
			temp+=key.toLowerCase()+"|";
		}
		this.commandUse=temp+commandUse;
		
	}
	
	//this function makes stuff happen
	public void execute(String[] command) throws ExeptionNotEnoughArguments
	{
		if(command.length<length)
			throw new ExeptionNotEnoughArguments(commandUse);
	}
	
	//this gets CommandUse
	public String getUse()
	{
		return commandUse;
	}
}