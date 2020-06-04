package Controller;

import java.awt.event.*;
import java.util.Collections;
import Model.*;
import Patterns.Chain.AbstractLogger;
import Patterns.Command.CommandLineChanger;
import Patterns.State.Context.GameStatus;
import View.*;


public class PieceMoveActionListener implements MouseListener 
{
	private View view;
	private Model model;
	private Controller controller;

	public PieceMoveActionListener(Controller controller) {// View view, Model model) {
		this.controller = controller;
		this.model = controller.getModel();// model;
		this.view = controller.getView();// view;
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		Tile tileItem = (Tile) e.getSource();
		if(tileItem != null) 
		{
			switch(model.getContext().getGameState()) {
			case EGALE:
				if(tileItem.getAttribute().compareToIgnoreCase("egale") != 0) 
				{
					controller.doMovement(tileItem);		
				}
				break;
			case SHARK:
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
