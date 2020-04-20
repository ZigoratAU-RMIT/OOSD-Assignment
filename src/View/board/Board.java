package View.board;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.*;
import javax.swing.*;
import View.board.*;
import Model.*;
import java.util.*;

public class Board extends JPanel
{
	public Board()
	{
		setLayout(new GridLayout(8,8));
		ArrayList<Shark> sharks = new ArrayList<Shark>();
		sharks.add(new Shark1("shark"));
		sharks.add(new Shark2("shark"));
		sharks.add(new Shark3("shark"));
		ArrayList<Eagle> eagles = new ArrayList<Eagle>();
		eagles.add(new Eagle1("eagle"));
		eagles.add(new Eagle2("eagle"));
		eagles.add(new Eagle3("eagle"));
		
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++)
			{
				int[] islandSet = {0,1};
				int rand = (int)(Math.random()*islandSet.length - 0.6);
				if(islandSet[rand] == 1)
				{
					Tile tile = new Tile(true);
					if(!eagles.isEmpty())
					{
						tile.setAnimal(eagles.get(0));
						eagles.remove(0);
						try 
						{
						    Image img = ImageIO.read(new FileInputStream(String.format("Image%s%s", File.separator, "tiger shark.jpg")));
						    int width = tile.getWidth();
						    int height = tile.getHeight();
						    Image resizeImg = img.getScaledInstance(100, 60, Image.SCALE_SMOOTH);
						    tile.setIcon(new ImageIcon(resizeImg));
						} 
						catch (Exception e) 
						{
						    System.out.println(e);
						}
					}
					add(tile);
				}
				else
				{
					Tile tile = new Tile(false);
					if(!sharks.isEmpty())
					{
						tile.setAnimal(sharks.get(0));
						sharks.remove(0);
						try 
						{
						    Image img = ImageIO.read(new FileInputStream(String.format("Image%s%s", File.separator, "tiger shark.jpg")));
						    int width = tile.getWidth();
						    int height = tile.getHeight();
						    Image resizeImg = img.getScaledInstance(100, 60, Image.SCALE_SMOOTH);
						    tile.setIcon(new ImageIcon(resizeImg));
						} 
						catch (Exception e) 
						{
						    System.out.println(e);
						}
					}
					add(tile);
				}
			}
		}
	}
}
