package txa;

import java.io.Console;

import txa.core.Game;
import txa.game.Adventure;

public class Main {

	private static Game g;
	public static void main(String[] args) {
		Console c = System.console();
		if (c == null) {
	            for(int i=0x2800;i<0x2900;i++)
	            	System.out.print((char)i);
	            System.exit(1);
	        }
		g = new Adventure(c);

		while(!g.close) 
		{
		g.update();
		}
       
//        Vector<Exit> e = new Vector<Exit>();
//        e.add(new Exit(null, "Mysterious Door", "The Black Door seems to be emmiting a glow./n On the door You can see a text written in what appears to be blood reading\n \"The Ones who enter the Void shall not return \"", true));
//        e.add(new Exit(null, "Entrance"));
//       Place p= new Place(e, "The Room", "The dark room appears to be small. \nYou do not sence any presence. \nYou see a dark door in front of you.");
//       p.enter(new Player(c.readLine("What is Your name?\n")));
	}
	
	public static Game getGame()
	{
		return g;		
	}

}
