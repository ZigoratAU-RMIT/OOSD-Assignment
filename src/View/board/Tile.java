package View.board;

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

import Model.*;


@SuppressWarnings("serial")
public class Tile extends JButton
{
	private int row;
	private int column;
	private int selectedRow;
	private int selectedColumn;
	private String attribute;
	private Color lastColor;
	private Color moveColor = Color.RED;
	private Pieces piece;
	
	public Tile(boolean isIsland,int row, int column)
	{	
		this.row = row;
		this.column = column;
		setOpaque(true);
		if(isIsland)
		{
			attribute = "island";
			setBackground(Color.GRAY);
			try
			{
				Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator,"Island.jpg")));
				setIcon(new ImageIcon(img));
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
		else
		{
			attribute = "ocean";
			setBackground(Color.BLUE);
			try
			{
				Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator,"Ocean.jpg")));
				setIcon(new ImageIcon(img));
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
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lastColor = getBackground();
				setBackground(moveColor);
			    setBorder(BorderFactory.createLineBorder(moveColor, 1));
			}

		@Override
		public void mouseExited(MouseEvent e) {
			if(!isSelected()) {
				setBackground(lastColor);
				setBorder(BorderFactory.createLineBorder(moveColor, 0));
			}
			}	
		
		@Override
		public void mouseClicked(MouseEvent e) {
			setSelected(!isSelected());		
			if(isSelected()) {
				selectedRow = row;
				selectedColumn = column;
				moveColor = Color.GREEN;
			}
			else
			{
				moveColor = Color.RED;
			}
			setBackground(moveColor);
			setBorder(BorderFactory.createLineBorder(moveColor, 1));
//			JOptionPane.showMessageDialog(null,attribute + "\n" + getRow()+","+getColumn());
			
//			String filename = Paths.get(getIcon().toString()).getFileName().toString();
//			filename = filename.substring(0, filename.lastIndexOf("."));
//			if(filename.compareToIgnoreCase("Island") == 0)
//				setIcon(new ImageIcon(this.getClass().getResource("/images/Ocean.jpg")));
//			else
//				setIcon(new ImageIcon(this.getClass().getResource("/images/Island.jpg")));
			}
		}
		);
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
	
	public void setPiece(Pieces piece)
	{
		this.piece = piece;
	}
}
