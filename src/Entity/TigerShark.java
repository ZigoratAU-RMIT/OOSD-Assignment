package Entity;

public class TigerShark extends Shark
{
	private String name;
	private int life;
	public TigerShark()
	{
		this.life = 3;
		this.name = "tiger shark";
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
