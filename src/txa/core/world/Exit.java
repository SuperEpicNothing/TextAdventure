package txa.core.world;

public class Exit 
{
	private Place target;
	private boolean visible;
	private String description;
	private String name;
	
	public Exit(Place t)
	{
		this(t,t.getName(),"",true);
	}
	
	public Exit(Place t,Boolean v)
	{
		this(t,t.getName(),"",v);
	}
	
	public Exit(Place t,String n)
	{
		this(t,n,"",true);
	}
	public Exit(Place t,String n,Boolean v)
	{
		this(t,n,"",v);
	}

	
	public Exit(Place target,String name, String description,Boolean visible)
	{
		this.target = target;
		this.name = name;
		this.description= description;
		this.visible = visible;
	}
	
	public void setTarget(Place target) {
		this.target = target;
	}

	public Place getTarget()
	{
		return target;		
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
