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
	
	ArrayList<Shark> sharks;
	ArrayList<Egale> eagles;
	
	public Model() {
		super();

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
	
	public void initModel(int row, int column)
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
		

		
		for(int x = 0;x<row;x++)
			for(int y = 0;y<column;y++)
			{
				int[] islandSet = {0,1,2,3,4};
				int rand = (int)(Math.random() * islandSet.length - 0.3);
				Tile tile = new Tile(true,x+1,y+1);
				switch(islandSet[rand]) {
				case 0:
					tile.setIsland();
					break;
				case 1:
					tile.setEagleIsland();
					break;
				case 2:
					tile.setEagleOcean();
					break;
				case 3:
					tile.setOcean();
					break;
				case 4:
					tile.setSharkOcean();
					break;
				}
				setImageToTile(tile,tile.getAttribute());

				tiles.add(tile);
			}
		//Arrange eagle at the top left of the board
		for(int x = 0;x<3;x++) {
			tiles.get(x).setEagle();
			setImageToTile(tiles.get(x),eagles.get(x).getName());
		}
		//Arrange sharks at the bottom of the board
		for(int x = 0;x<3;x++) {
			tiles.get(tiles.size() - x - 1).setShark();
			setImageToTile(tiles.get(tiles.size() - x - 1),sharks.get(x).getName());			
		}
	}

	
	public List<Tile> getTiles() {
		return tiles;
	}


	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}	
}
