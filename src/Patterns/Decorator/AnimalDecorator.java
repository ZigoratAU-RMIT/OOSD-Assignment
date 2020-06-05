package Patterns.Decorator;

import Entity.Animal;

public abstract class AnimalDecorator extends Animal  {
	private int life;
	private int lifeAbility;

	public AnimalDecorator(String name) {
		super(name);
		// TODO Auto-generated constructor stub
		this.life = 3;
		this.lifeAbility = 1;
	}
	
	public int getLife()
	{
		return this.life;
	}
	
	public void setLife(int life)
	{
		this.life = life;
	}
	
	public void increaseLife()
	{
		this.life++;
	}

	public void reduceLife(int reduceNumber)
	{
		this.life -= reduceNumber;
	}
		
	public void setLifeAbility(int number)
	{
		this.lifeAbility = number;
	}
	
	public int getLifeAbility()
	{
		return this.lifeAbility;
	}

}
