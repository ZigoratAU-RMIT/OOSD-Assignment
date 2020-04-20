package Controller;

import java.awt.event.*;
import Model.*;
import View.board.*;

public class ButtonListener implements ActionListener
{
	private Tile tile;
	private Pieces piece;
	public ButtonListener(Tile tile,Pieces piece)
	{
		this.tile = tile;
		this.piece = piece;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(this.piece != null)
		{
			if(tile.getAttribute() == "ocean")
			{
				
			}
			else
			{
				
			}
		}
		else
		{
			
		}
	}
}
