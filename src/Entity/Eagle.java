package Entity;

public class Eagle extends Animal {


	private int life;
	private String name;
	public Eagle(String name) 
	{
		super(name);
		this.name = name;
		this.life = 3;
	}
	
	public int getLife()
	{
		return this.life;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}

	public void reduceLife(int reduceNumber)
	{
		this.life -= reduceNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	
}