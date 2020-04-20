package View.board;


import java.awt.*;
import java.util.*;
import javax.swing.*;



public class Board extends JPanel
{
	public Board()
	{
		setLayout(new GridLayout(8,8));
		
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
			{
				int[] islandSet = {0,1};
				int rand = (int)(Math.random() * islandSet.length - 0.6);
				long start = new Date().getTime();
				while(new Date().getTime() - start < 10L){}
				if(islandSet[rand] == 1)
				{
					Tile tile = new Tile(true,x+1,y+1);
					add(tile);
				}
				else
				{
					Tile tile = new Tile(false,x+1,y+1);
					add(tile);
				}
			}
		}
	}
	
}
