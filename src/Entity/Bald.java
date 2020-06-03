package Entity;

public class Bald extends Eagle
{
	private String name;
	private int life;
	public Bald()
	{
		this.name = "Bald";
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
