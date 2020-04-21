package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.swing.*;

import Entity.*;


@SuppressWarnings("serial")
public class Tile extends JButton
{
	private int row;
	private int column;

	private String attribute;
	
	public Tile(boolean isIsland,int row, int column)
	{	
		this.row = row;
		this.column = column;
		setOpaque(true);
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
}