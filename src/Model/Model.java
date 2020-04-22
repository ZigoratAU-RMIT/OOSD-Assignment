package Model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;



import View.*;
import Entity.*;


public class Model 
{	
	private List<Tile> tiles;
	private Board board;
	
	ArrayList<Shark> sharks;
	ArrayList<Egale> eagles;
	
	public Model() {
		super();
		initTilesList();
	}

	private void setImageToTile(Tile tileItem,String imageName) {
		try
		{
			Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator, imageName + ".jpg")));
			tileItem.setIcon(new ImageIcon(img.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH)));
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
	
	private void initTilesList()
	{
		tiles = new ArrayList<>();
		
		sharks = new ArrayList<Shark>();
		sharks.add(new Shark("white shark"));
		sharks.add(new Shark("blue shark"));
		sharks.add(new Shark("tiger shark"));
		eagles = new ArrayList<Egale>();
		eagles.add(new Egale("Bateleur"));
		eagles.add(new Egale("Bald"));
		eagles.add(new Egale("Black"));
		

		
		for(int x = 0;x<8;x++)
			for(int y = 0;y<8;y++)
			{
				int[] islandSet = {0,1};
				int rand = (int)(Math.random() * islandSet.length - 0.6);
				long start = new Date().getTime();
				while(new Date().getTime() - start < 10L)
				{
					
				}
				if(islandSet[rand] == 1 || ( x==6 && y==7) || ( x==7 && y==7)|| ( x==7 && y==6))
				{
					Tile tile = new Tile(true,x+1,y+1);
					if(( x==6 && y==7) || ( x==7 && y==7)|| ( x==7 && y==6))
					{
						if(!eagles.isEmpty())
						{
							//Pieces piece = new Pieces(eagles.get(0));
							//maybe need a kind of picture change here
							tile.setEagle();
							setImageToTile(tile,eagles.get(0).getName());
							eagles.remove(0);
						}
						else {
							//Element element = new Element("island");
							//maybe need a kind of picture change here
							tile.setEagleIsland();
							setImageToTile(tile,"Island");
						}
					}
					else {
						//Element element = new Element("island");
						//maybe need a kind of picture change here
						tile.setEagleIsland();
						setImageToTile(tile,"Island");
					}
					tiles.add(tile);
				}
				else if(islandSet[rand] == 0 ||( x==0 && y==1) || ( x==0 && y==0)|| ( x==1 && y==0))
				{
					Tile tile = new Tile(false,x+1,y+1);
					if(( x==0 && y==1) || ( x==0 && y==0)|| ( x==1 && y==0))
					{
						if(!sharks.isEmpty())
						{
							//Pieces piece = new Pieces(sharks.get(0));
							//maybe need a kind of picture change here
							tile.setShark();
							setImageToTile(tile,sharks.get(0).getName());
							sharks.remove(0);
						}
						else
						{
							//Element element = new Element("ocean");
							//maybe need a kind of picture change here
							tile.setSharkOcean();
							setImageToTile(tile,"Ocean");
						}
					}
					else
					{
						//Element element = new Element("ocean");
						//maybe need a kind of picture change here
						tile.setSharkOcean();
						setImageToTile(tile,"Ocean");
					}
					tiles.add(tile);
				}
			}
	}

	
	public List<Tile> getTiles() {
		return tiles;
	}


	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}	
}
