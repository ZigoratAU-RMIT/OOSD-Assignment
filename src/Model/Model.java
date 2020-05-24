package Model;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Configuration.ApplicationConfiguration;
import View.*;
import Entity.*;


public class Model 
{	
	private List<Tile> tiles;
	private ArrayList<Shark> sharks;
	private ArrayList<Egale> eagles;
	private ApplicationConfiguration applicationConfiguration;

	public Model() {
		super();
		applicationConfiguration = new ApplicationConfiguration();

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
	
	private void loadGame() {
		int item = 0;
		for(int x = 0;x< applicationConfiguration.getBoardRows();x++)
			for(int y = 0;y<applicationConfiguration.getBoardColumns();y++)
			{
				String name = applicationConfiguration.getTilesList().get(item);
				Tile tile = new Tile(name,x+1,y+1);
				setImageToTile(tile,tile.getAttribute());
				if(isContaingEagle(name)) {
					ChangeEgaleBehaviour itemEgale = new ChangeEgaleBehaviour(eagles(),tile);
					itemEgale.selectItem(tile.getAttribute());
				}
				if(isContaingShark(name)) {
					ChangeEgaleBehaviour itemShark = new ChangeEgaleBehaviour(sharks(),tile);
					itemShark.selectItem(tile.getAttribute());
				}
				tiles.add(tile);
				item++;
			}		
	}
	
	
	public void initModel(int boardRows, int boardColumns)
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

		if(applicationConfiguration.getTilesList().size() > 0) {
			JOptionPane.showMessageDialog(null,"Loading game");
			loadGame();
			return;
		}
		
		for(int x = 0;x<boardRows;x++)
			for(int y = 0;y<boardColumns;y++)
			{
				int[] islandSet = {0,1,2,3,4};
				int rand = (int)(Math.random() * islandSet.length);
				Tile tile = new Tile("",x+1,y+1);
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
		ArrayList<Integer> numbers = new ArrayList<Integer>();  
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for(int x = 0;x<3;x++) {
			//Generate random number for different location
			Random randomGenerator = new Random();
			while (numbers.size() < 3) {

			    int random = randomGenerator .nextInt(boardRows);
			    if (!numbers.contains(random)) {
			        numbers.add(random);
			        }
			}
			tiles.get(numbers.get(x)).setEagle();
			tiles.get(numbers.get(x)).setName(eagles.get(x).getName());
			tiles.get(numbers.get(x)).setAttribute(eagles.get(x).getName());
			ChangeEgaleBehaviour item = new ChangeEgaleBehaviour(eagles(),tiles.get(numbers.get(x)));
			setImageToTile(tiles.get(numbers.get(x)),eagles.get(x).getName());
		}
		//Arrange sharks at the bottom of the board
		for(int x = 0;x<3;x++) {
			numbers.clear();  
			Random randomGenerator = new Random();
			while (numbers.size() < 3) {

			    int random = randomGenerator .nextInt(9);
			    if (!numbers.contains(random) && !numberList.contains(random)) {
			        numbers.add(random);
			    }
			}
			int location = tiles.size() - numbers.get(x) - 1;
			tiles.get(location).setShark();
			tiles.get(location).setName(sharks.get(x).getName());
			tiles.get(location).setAttribute(sharks.get(x).getName());
			setImageToTile(tiles.get(location),sharks.get(x).getName());		
			numberList.add(numbers.get(0));
			numberList.add(numbers.get(1));
			numberList.add(numbers.get(2));
		}
	}

	
	public List<Tile> getTiles() {
		return tiles;
	}

	public void setTiles(List<Tile> tiles) {
		this.tiles = tiles;
	}	
	
	public ArrayList<Shark> getSharks() {
		return sharks;
	}

	public void setSharks(ArrayList<Shark> sharks) {
		this.sharks = sharks;
	}

	public ArrayList<Egale> getEagles() {
		return eagles;
	}

	public void setEagles(ArrayList<Egale> eagles) {
		this.eagles = eagles;
	}
	
	public ApplicationConfiguration getApplicationConfiguration() {
		return applicationConfiguration;
	}

	public void setApplicationConfiguration(ApplicationConfiguration applicationConfiguration) {
		this.applicationConfiguration = applicationConfiguration;
	}
	
	public boolean isContaingEagle(String eagleName) {
		for(int i=0; i< eagles.size(); i++)
			if(eagles.get(i).getName().compareToIgnoreCase(eagleName) == 0) {
				return true;
			}
		return false;
	}

	public boolean isContaingShark(String sharkName) {
		for(int i=0; i< sharks.size(); i++)
			if(sharks.get(i).getName().compareToIgnoreCase(sharkName) == 0) {
				return true;
			}
		return false;
	}
	
	public String[] eagles() {
		String[] items = new String[eagles.size()];
		for(int i=0; i< eagles.size(); i++)
			items[i] = eagles.get(i).getName();
		return items;
	}

	public String[] sharks() {
		String[] items = new String[sharks.size()];
		for(int i=0; i< sharks.size(); i++)
			items[i] = sharks.get(i).getName();
		return items;
	}
}
