package txa.core.UI;

public enum EnumUI 
{	
	NOTHING(null),
	INVENTORY(new Inventory());
	
	private UI u;
	EnumUI(UI u)
	{
		this.u=u;
	}
	
	public UI getUI()
	{
		return u;
	}
}
