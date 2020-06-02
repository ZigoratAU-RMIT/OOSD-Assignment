package Entity;

public class Shark extends Animal {
	
	private int life;
	private String name;
	public Shark() {
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
