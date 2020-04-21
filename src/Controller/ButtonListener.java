package Controller;

import java.awt.event.*;
import java.nio.file.Paths;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Entity.*;
import View.*;

public class ButtonListener implements ActionListener
{
	private Tile tile;
	private Element element;
	private Board board;
//	public ButtonListener(Tile tile,Pieces piece,Board board)
	public ButtonListener(Tile tile,Element element,Board board)
	{
		this.tile = tile;
		this.element = element;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(this.element != null)
		{
			if(tile.getAttribute() == "sharkOcean")
			{
				if(board.getSelectedRow() != -1 && board.getSelectedColumn() != -1) {
					double x = tile.getRow() - board.getSelectedRow();
					double y = tile.getColumn() - board.getSelectedColumn();
					
					
					
					if((Math.abs(x) == 1 && Math.abs(y) == 2) || (Math.abs(x) == 2 && Math.abs(y) == 1)) {
////					String filename = Paths.get(getIcon().toString()).getFileName().toString();
////					filename = filename.substring(0, filename.lastIndexOf("."));
////					if(filename.compareToIgnoreCase("Island") == 0)
////						setIcon(new ImageIcon(this.getClass().getResource("/images/Ocean.jpg")));
////					else
////						setIcon(new ImageIcon(this.getClass().getResource("/images/Island.jpg")));
						JOptionPane.showMessageDialog(null,"OK" + " \n" + tile.getIcon().toString()+"\n"+board.getSelectedTile().getIcon().toString());
					}
					else {
						JOptionPane.showMessageDialog(null,"False");
					}
					board.setSelectedRow(-1);
					board.setSelectedColumn(-1);
				}
				//JOptionPane.showMessageDialog(null,tile.getRow()+","+ tile.getColumn());
				//maybe need the move function
			}
			else if(tile.getAttribute() == "eagleOcean")
			{
				//maybe need the move function
			}
			else if(tile.getAttribute() == "eagleIsland")
			{
				//maybe need the move function
			}
		}
	}
}
