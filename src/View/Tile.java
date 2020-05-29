package View;

import java.awt.*;
import javax.swing.*;




@SuppressWarnings("serial")
public class Tile extends JButton
{
	private int row;
	private int column;
	private String attribute;
	private String name;
	private String currentTileAttribute;

	public Tile(String name,int row, int column)
	{	
		this.row = row;
		this.column = column;
		this.name = name;
		this.attribute = name;
		setOpaque(true);
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
	
	public void setEagle()
	{
		this.attribute = "eagle";
		this.currentTileAttribute = "eagleIsland";
	}
	
	public void setShark()
	{
		this.attribute = "shark";
		this.currentTileAttribute = "sharkOcean";
	}
	
	public String getAttribute()
	{
		return this.attribute;
	}

	public void setAttribute(String attribute)
	{
		this.attribute = attribute;
	}
	
	public void setCurrentTileAttribute(String attribute)
	{
		this.currentTileAttribute = attribute;
	}
	
	public String getCurrentTileAttribute()
	{
		return this.currentTileAttribute;
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int x) {
		row = x;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int y) {
		column = y;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}