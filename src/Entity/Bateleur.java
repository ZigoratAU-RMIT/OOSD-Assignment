package Entity;

public class Bateleur extends Eagle
{
	private String name;
	private int life;
	public Bateleur()
	{
		this.name = "Bateleur";
		this.life = 3;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}

	public void reduceLife(int reduceNumber)
	{
		this.life -= reduceNumber;
	}
	
	public int getLife()
	{
		return this.life;
	}
}
