package View.board;

import java.awt.*;
import javax.swing.*;
import Model.*;

public class Tile extends JButton
{
	private String attribute;
	private Animal animal;
	public Tile(boolean isIsland)
	{	
		if(isIsland)
		{
			attribute = "island";
			setBackground(Color.GRAY);
		}
		else
		{
			attribute = "ocean";
			setBackground(Color.BLUE);
		}
	}
	
	public void setIsland()
	{
		attribute = "island";
		setBackground(Color.GRAY);
	}
	
	public void setOcean()
	{
		attribute = "ocean";
		setBackground(Color.BLUE);
	}
	
	public String getAttribute()
	{
		return this.attribute;
	}
	
	public void setAnimal(Animal animal)
	{
		this.animal = animal;
	}
	
	public Animal getAnimal()
	{
		return this.animal;
	}
	
//	public int getWidth()
//	{
//		return this.getWidth();
//	}
//	
//	public int getHeight()
//	{
//		return this.getHeight();
//	}
}
