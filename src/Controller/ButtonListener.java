package Controller;

import java.awt.event.*;
import Model.*;
import View.board.*;

public class ButtonListener implements ActionListener
{
	private Tile tile;
	private Pieces piece;
	private Board board;
	public ButtonListener(Tile tile,Pieces piece,Board board)
	{
		this.tile = tile;
		this.piece = piece;
		this.board = board;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(this.piece != null)
		{
			if(tile.getAttribute() == "sharkOcean")
			{
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
