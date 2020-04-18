package View.board;

import java.awt.*;
import javax.swing.*;

public class Tile extends JButton
{
	private String attribute;
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
}
