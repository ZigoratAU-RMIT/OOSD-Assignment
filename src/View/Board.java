package View;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import Controller.*;
import Entity.*;




public class Board extends JPanel
{
	private int row;
	private int column;
	private int selectedRow;
	private int selectedColumn;
	
	public int getRow() {
		return row;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getSelectedColumn() {
		return selectedColumn;
	}

	public void setSelectedColumn(int selectedColumn) {
		this.selectedColumn = selectedColumn;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Board(int row,int column)
	{
		this.row = row;
		this.column = column;
		selectedRow = -1;
		selectedColumn = -1;
		setLayout(new GridLayout(row,column));
		
		ArrayList<Shark> sharks = new ArrayList<Shark>();
		sharks.add(new Shark("white shark"));
		sharks.add(new Shark("blue shark"));
		sharks.add(new Shark("tiger shark"));
		ArrayList<Egale> eagles = new ArrayList<Egale>();
		eagles.add(new Egale("Bateleur"));
		eagles.add(new Egale("Bald"));
		eagles.add(new Egale("Black"));
		
		for(int x = 0;x<row;x++)
		{
			for(int y = 0;y<column;y++)
			{
				int[] islandSet = {0,1};
				int rand = (int)(Math.random() * islandSet.length - 0.6);
				long start = new Date().getTime();
				while(new Date().getTime() - start < 10L)
				{
					
				}
				if(islandSet[rand] == 1)
				{
					Tile tile = new Tile(true,x+1,y+1);
					if(!eagles.isEmpty())
					{
						Pieces piece = new Pieces(eagles.get(0));
						tile.addMouseListener(new MoveController(tile,piece,this));
						
						//maybe need a kind of picture change here
						tile.setEagle();
						try
						{
							Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator, eagles.get(0).getName() + ".jpg")));
							tile.setIcon(new ImageIcon(img));
						}
						catch (FileNotFoundException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						eagles.remove(0);
					}
					else {
						Element element = new Element("island");
						//maybe need a kind of picture change here
						tile.addActionListener(new ButtonListener(tile, element, this));
						tile.setEagleIsland();
						try
						{
							Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator,"Island.jpg")));
							tile.setIcon(new ImageIcon(img));
						}
						catch (FileNotFoundException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					add(tile);
				}
				else
				{
					Tile tile = new Tile(false,x+1,y+1);
					if(!sharks.isEmpty())
					{
						Pieces piece = new Pieces(sharks.get(0));
						tile.addMouseListener(new MoveController(tile,piece,this));
						//maybe need a kind of picture change here
						tile.setShark();
						try
						{
							Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator, sharks.get(0).getName() + ".jpg")));
							tile.setIcon(new ImageIcon(img));
						}
						catch (FileNotFoundException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						sharks.remove(0);
					}
					else
					{
						Element element = new Element("ocean");
						//maybe need a kind of picture change here
						tile.addActionListener(new ButtonListener(tile, element, this));
						tile.setSharkOcean();
						try
						{
							Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator,"Ocean.jpg")));
							tile.setIcon(new ImageIcon(img));
						}
						catch (FileNotFoundException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						catch (IOException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					add(tile);
				}
			}
		}
	}
	
	public Tile getTile(int x, int y)
	{
		return (Tile) this.getComponentAt(x, y);
	}

	public Tile getSelectedTile()
	{
		return (Tile) this.getComponentAt(selectedRow, selectedColumn);
	}}

