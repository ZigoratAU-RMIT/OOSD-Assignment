package Controller;

import java.awt.event.*;
import Model.*;
import View.*;


public class PieceMoveActionListener implements MouseListener 
{
	private Model model;
	private Controller controller;

	public PieceMoveActionListener(Controller controller) {
		this.controller = controller;
		this.model = controller.getModel();
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		Tile tileItem = (Tile) e.getSource();
		if(tileItem != null) 
		{
			switch(model.getContext().getGameState()) {
			case EGALE:
			case EGALEATTACK:
				if(tileItem.getAttribute().compareToIgnoreCase("egale") != 0) 
				{
					controller.doMovement(tileItem);		
				}
				break;
			case SHARK:
			case SHARKATTACK:
				if(tileItem.getAttribute().compareToIgnoreCase("shark") != 0)
				{
					controller.doMovement(tileItem);									
				}
				break;
			default:
				break;
			}		
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub

	}
}
