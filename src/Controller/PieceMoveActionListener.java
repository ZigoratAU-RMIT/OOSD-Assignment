package Controller;

import java.awt.event.*;
import java.util.Collections;

import javax.swing.JOptionPane;

import Model.*;
import Patterns.State.Context.GameStatus;
import View.*;


public class PieceMoveActionListener implements MouseListener 
{
	private View view;
	private Model model;

	public PieceMoveActionListener(View view, Model model)
	{
		this.view = view;
		this.model = model;
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
					doMovement(tileItem);		
				}
				break;
			case SHARK:
				if(tileItem.getAttribute().compareToIgnoreCase("shark") != 0)
				{
					doMovement(tileItem);									
				}
				break;
			default:
				break;
			}
//			if(view.getBoard().getEagleSharkTurn()) 
//			{
//				if(tileItem.getAttribute().compareToIgnoreCase("egale") != 0) 
//				{
//					view.getBoard().setEagleSharkTurn(true);
//					doMovement(tileItem);		
//				}
//			}
//			else 
//			{
//				if(tileItem.getAttribute().compareToIgnoreCase("shark") != 0)
//				{
//					view.getBoard().setEagleSharkTurn(false);
//					doMovement(tileItem);									
//				}
//			}			
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

	public void showBoard() {
		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(view.getBoard(),model);//.eagles());
		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(view.getBoard(),model);//.sharks());
		PieceMoveActionListener pieceMoveActionListener = new PieceMoveActionListener(view,model);

		int item = 0;
		Tile tile;
		for(int x = 0;x<view.getBoard().getRow();x++)
			for(int y = 0;y<view.getBoard().getColumn();y++) 
			{
				tile = model.getTiles().get(item++);
				String attribute = tile.getAttribute();
				if(model.isContaingEagle(attribute)) 
				{
					tile.addMouseListener(egaleMouseActionListener);
				}
				else if(model.isContaingShark(attribute))
				{
					tile.addMouseListener(sharkMouseActionListener);
				}
				else
				{
					tile.addMouseListener(pieceMoveActionListener);
				}
				view.getBoard().add(tile);
			}
	}

	public void doMovement(Tile tileItem) {
		if(view.getBoard().getSelectedRow() != -1 && view.getBoard().getSelectedColumn() != -1) {
			//calculate distance
			double x = tileItem.getRow() - view.getBoard().getSelectedRow();
			double y = tileItem.getColumn() - view.getBoard().getSelectedColumn();

			boolean isMoveAllowed = checkMovement(x,y);
			if(isMoveAllowed) {				
				//find source and destination location in the board
				int x1 = tileItem.getRow();   
				int y1 = tileItem.getColumn();
				int x2 = view.getBoard().getSelectedRow() ;
				int y2 = view.getBoard().getSelectedColumn();

				int source = ((x1 - 1) * 8) + (y1 - 1);
				int destination = ((x2 - 1) * 8) + (y2 - 1);

				Tile sourceTile = model.getTiles().get(source);
				Tile destinationTile = model.getTiles().get(destination);
				String sourceAttribute = sourceTile.getAttribute();
				String destinationAttribute = destinationTile.getAttribute();

				String sourceAttributeChange = "";
				if(destinationAttribute.equalsIgnoreCase("Black") || 
						destinationAttribute.equalsIgnoreCase("Bateleur") || 
						destinationAttribute.equalsIgnoreCase("Bald"))
				{
					sourceAttributeChange = "island";
				}
				else
				{
					sourceAttributeChange = "ocean";
				}

				if(destinationTile.getCurrentTileAttribute() == null)
				{
					if(destinationAttribute.equalsIgnoreCase("Black") || 
							destinationAttribute.equalsIgnoreCase("Bateleur") || 
							destinationAttribute.equalsIgnoreCase("Bald"))
					{
						model.getTiles().get(destination).setCurrentTileAttribute("EagleIsland");
					}
					else
					{
						model.getTiles().get(destination).setCurrentTileAttribute("SharkOcean");
					}

					if(destinationTile.getCurrentTileAttribute().equalsIgnoreCase("EagleOcean")
							|| destinationTile.getCurrentTileAttribute().equalsIgnoreCase("SharkOcean"))
					{
						sourceAttributeChange = "ocean";
					}
					else
					{
						sourceAttributeChange = "island";
					}
				}
				else
				{
					if(destinationTile.getCurrentTileAttribute().equalsIgnoreCase("EagleIsland"))
					{
						sourceAttributeChange = "island";
					}
					else
					{
						sourceAttributeChange = "ocean";
					}
				}

				if(sourceAttribute.equalsIgnoreCase("ocean") && (destinationAttribute.equalsIgnoreCase("Black") || 
						destinationAttribute.equalsIgnoreCase("Bateleur") || 
						destinationAttribute.equalsIgnoreCase("Bald")))
				{
					destinationTile.setCurrentTileAttribute("EagleOcean");
				}
				else if(sourceAttribute.equalsIgnoreCase("island") && (destinationAttribute.equalsIgnoreCase("Black") || 
						destinationAttribute.equalsIgnoreCase("Bateleur") || 
						destinationAttribute.equalsIgnoreCase("Bald")))
				{
					destinationTile.setCurrentTileAttribute("EagleIsland");
				}


				model.getTiles().get(source).setRow(x2);
				model.getTiles().get(source).setColumn(y2);
				model.getTiles().get(destination).setRow(x1);
				model.getTiles().get(destination).setColumn(y1);
				Collections.swap(model.getTiles(), source, destination);

				model.getTiles().get(destination).setAttribute(sourceAttributeChange);
				model.setImageToTile(model.getTiles().get(destination), sourceAttributeChange);

				view.getBoard().removeAll();
				showBoard();
				view.getBoard().validate();
				//changeTurn();
				view.UpdateScore(model.getContext().getGameState() == GameStatus.EGALE,1);
				//view.getBoard().changeTurn();
				if(model.getContext().getGameState() == GameStatus.SHARK)
					model.getContext().setGameState(GameStatus.EGALE);
				else
					model.getContext().setGameState(GameStatus.SHARK);
				view.ResetTurnStatus(model.getContext().getGameState());
			}
			else
			{
				if(model.getContext().getGameState() == GameStatus.EGALE)
					JOptionPane.showMessageDialog(null,"Egale movement is wrong");
				else if(model.getContext().getGameState() == GameStatus.SHARK)
					JOptionPane.showMessageDialog(null,"Shark movement is wrong");
//				if(view.getBoard().getEagleSharkTurn())
//					JOptionPane.showMessageDialog(null,"Egale movement is wrong");
//				else
//					JOptionPane.showMessageDialog(null,"Shark movement is wrong");
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);			
		}		
	}

	public boolean checkMovement(double x, double y) {
		boolean result = false;
		if(model.getContext().getGameState() == GameStatus.EGALE) {// view.getBoard().getEagleSharkTurn()) {// EagleOrShark) {
			//find the eagle name for selecting different movement.
			if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(0).getName()) == 0)
				result = ((Math.abs(x) + Math.abs(y)) <= 3);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(1).getName()) == 0)
				result = ((Math.abs(x) + Math.abs(y)) <= 3);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(2).getName()) == 0)
				result = ((Math.abs(x) + Math.abs(y)) <= 3);
		}
		else if(model.getContext().getGameState() == GameStatus.SHARK){
			//find the shark name for selecting different movement.
			if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(0).getName()) == 0)	
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(1).getName()) == 0)	
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(2).getName()) == 0)	
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
		}
		return result;
	}
}
