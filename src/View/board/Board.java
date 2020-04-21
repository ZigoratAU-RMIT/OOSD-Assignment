package View.board;


import java.awt.*;
import java.util.*;
import javax.swing.*;

import Controller.*;
import Model.*;
import View.board.*;



public class Board extends JPanel
{
	public Board()
	{
		setLayout(new GridLayout(8,8));
		
		ArrayList<Shark> sharks = new ArrayList<Shark>();
		sharks.add(new Shark("shark"));
		sharks.add(new Shark("shark"));
		sharks.add(new Shark("shark"));
		ArrayList<Eagle> eagles = new ArrayList<Eagle>();
		eagles.add(new Eagle("eagle"));
		eagles.add(new Eagle("eagle"));
		eagles.add(new Eagle("eagle"));
		
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
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
						tile.addActionListener(new ButtonListener(tile, piece, this));
						//maybe need a kind of picture change here
						tile.setPiece(piece);
						tile.setEagleIsland();
						eagles.remove(0);
					}
					add(tile);
				}
				else
				{
					Tile tile = new Tile(false,x+1,y+1);
					if(!sharks.isEmpty())
					{
						Pieces piece = new Pieces(sharks.get(0));
						tile.addActionListener(new ButtonListener(tile, piece, this));
						//maybe need a kind of picture change here
						tile.setPiece(piece);
						tile.setSharkOcean();
						sharks.remove(0);
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
}
