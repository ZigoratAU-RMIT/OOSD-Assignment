package Entity;

public class Black extends Eagle
{
	private String name;
	private int life;
	public Black()
	{
		this.life = 3;
		this.name = "Black";
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
}
