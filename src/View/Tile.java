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

	public Tile(String name,int row, int column)
	{	
		this.row = row;
		this.column = column;
		this.name = name;
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
	
	public void setSharkOcean()
	{
		this.attribute = "sharkOcean";
	}
	
	public void setEagleOcean()
	{
		this.attribute = "eagleOcean";
	}
	
	public void setEagleIsland()
	{
		this.attribute = "eagleIsland";
	}
	
	public void setEagle()
	{
		this.attribute = "egale";
	}
	
	public void setShark()
	{
		this.attribute = "shark";
	}
	
	public String getAttribute()
	{
		return this.attribute;
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