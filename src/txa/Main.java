package txa;

import java.io.Console;

import txa.core.Game;
import txa.game.Adventure;

public class Main {

	private static Game g;
	public static void main(String[] args) {
		Console c = System.console();
		//if you can not play the game in this thing you are running it in spit characters at the player Yeah.
		if (c == null) {
			//for numbers
			for(int i=0x2800;i<0x2900;i++)
				//get characters
				System.out.print((char)i);
				//exit with code 1.
	            System.exit(1);
	        }
		
		//Adventure time!
		g = new Adventure(c);

		//Update it till the game tells you to
		while(!g.close) 
		{
		g.update();
		}
		//end correctly
		System.exit(0);
       
	}

}
