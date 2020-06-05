package Entity;

public class Shark extends Animal {

//	private int life;
	private String name;
//	private int lifeAbility;
	public Shark(String name) 
	{
		super(name);
		this.name = name;
//		this.life = 3;
//		this.lifeAbility = 1;
	}
	
//	public int getLife()
//	{
//		return this.life;
//	}
//	
//	public void setLife(int life)
//	{
//		this.life = life;
//	}
//	
//	public void increaseLife()
//	{
//		this.life++;
//	}
//
//	public void reduceLife(int reduceNumber)
//	{
//		this.life -= reduceNumber;
//	}
	
	public String getName()
	{
		return this.name;
	}
	
//	public void setLifeAbility(int number)
//	{
//		this.lifeAbility = number;
//	}
//	
//	public int getLifeAbility()
//	{
//		return this.lifeAbility;
//	}

}
