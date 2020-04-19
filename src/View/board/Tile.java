package View.board;

import java.awt.*;
import javax.swing.*;

public class Tile extends JButton
{
	private String attribute;
	public Tile(boolean isIsland)
	{	
	package View.board;

import java.awt.*;
import javax.swing.*;

public class Tile extends JButton
{
	private String attribute;
	
	///////////////////////////////////////////////////
	public Tile(String type)
	{
		if(type.equals("water"))
		{
			setBackground(Color.BLUE);
		}
		
		if(type.equals("land"))
		{
			setBackground(Color.GRAY);
		}
		
		//change color to image of animal
		if(type.equals("shark1"))
		{
			setBackground(Color.WHITE);
			setText("I AM SHARK 1");
		}
		
		if(type.equals("shark2"))
		{
			setBackground(Color.WHITE);
			setText("I AM SHARK 2");
		}
		
		if(type.equals("shark3"))
		{
			setBackground(Color.WHITE);
			setText("I AM SHARK 3");
			
		}
		
		if(type.equals("eagle1"))
		{
			setBackground(Color.BLACK);
			setText("I AM EAGE 1");
		}
		
		if(type.equals("eagle2"))
		{
			setBackground(Color.BLACK);
			setText("I AM EAGE 2");
		}
		
		if(type.equals("eagle3"))
		{
			setBackground(Color.BLACK);
			setText("I AM EAGE 3");
		}
		
	}
	///////////////////////////////////////////////////
	
	public Tile(boolean isIsland)
	{	
		if(isIsland)
		{
			attribute = "island";
			setBackground(Color.GRAY);
			setText("HELLO");
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
}
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
}
