package View.board;

import java.awt.*;
import javax.swing.*;
import View.board.*;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Board extends JPanel
{
	public Board()
	{
		String[][] board = new String[][] {
		    {"shark1", "land", "shark2", "land", "shark3", "land", "water", "land"},
		    {"land", "water", "land", "water", "land", "water", "land", "water"},
		    {"water", "land", "water", "land", "water", "land", "water", "land"},
		    {"land", "water", "land", "water", "land", "water", "land", "water"},
		    {"water", "land", "water", "land", "water", "land", "water", "land"},
		    {"land", "water", "land", "water", "land", "water", "land", "water"},
		    {"water", "land", "water", "land", "water", "land", "water", "land"},
		    {"eagle1", "water", "eagle2", "water", "eagle3", "water", "land", "water"},
		};
		
		setLayout(new GridLayout(8,8));
		
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
			{
				String type = board[x][y];
				Tile tile = new Tile(type);
				add(tile);
			} 
			System.out.println("\n"); 
		}
		
		/*
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
			{
				//board[x][y] = x + y;
						
				int[] islandSet = {0,1};
				int rand = (int)(Math.random()*islandSet.length - 0.6);
				if(islandSet[rand] == 1)
				{
					Tile tile = new Tile(true);
					add(tile);
					  
				}
				else
				{
					Tile tile = new Tile(false);
					add(tile);
				}
			}
		}
		*/
	}
}
