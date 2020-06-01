package Entity;

public class WhiteShark extends Shark
{
	private String name;
	private int life;
	public WhiteShark()
	{
		this.life = 3;
		this.name = "white shark";
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
