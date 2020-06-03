package Entity;

public class Shark extends Animal {

	private int life;
	private String name;
	public Shark(String name) 
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
