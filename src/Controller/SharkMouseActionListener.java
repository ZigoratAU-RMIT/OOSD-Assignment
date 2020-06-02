package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Entity.Eagle;
import Entity.Shark;
import Model.Model;
import Patterns.Chain.AbstractLogger;
import Patterns.State.Context.GameStatus;
import View.Board;
import View.Tile;
import View.View;

public class SharkMouseActionListener  implements MouseListener 
{
	private Board board;
	private View view;
	private Model model;
	
	public SharkMouseActionListener(View view, Model model) {
		this.board = view.getBoard();
		this.model = model;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{	
		// TODO Auto-generated method stub	
		if(model.getContext().getGameState() != GameStatus.SHARK)
		{
			JOptionPane.showMessageDialog(null,"It is Eagle turn");
			model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "Wrong selection");
		}
		else 
		{
			Tile tile = (Tile) e.getSource();
			if(tile != null) 
			{
				for(Shark shark : model.getSharks())
				{
					if(shark.getName().contains(tile.getAttribute()))
					{
						if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) 
						{
							board.setSelectedRow(tile.getRow());
							board.setSelectedColumn(tile.getColumn());
							board.setSelectedname(tile.getName());
							//set Shark message
							model.getLoggerChain().setwMessage(AbstractLogger.SHARK, "SHARK ( " +tile.getRow() + "," +tile.getColumn() + " )");
						}
//						view.getCurrentAnimalPanel().removeAll();
//						JLabel currentLabel = new JLabel("This is the animal that you choose");
//						JLabel sharkName = new JLabel(shark.getName());
//						JLabel sharkLife = new JLabel("Life: " + String.valueOf(shark.getLife()));
//						JLabel movementType = new JLabel("Movement: in '+' shape");
//						view.getCurrentAnimalPanel().add(currentLabel);
//						view.getCurrentAnimalPanel().add(sharkName);
//						view.getCurrentAnimalPanel().add(sharkLife);
//						view.getCurrentAnimalPanel().add(movementType);
//						view.getCurrentAnimalPanel().validate();
					}
				}
			}		
		}
		view.updateSharkLog(model.getLoggerChain().message);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void showBoard() {
		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(view,model);//.eagles());
		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(view,model);//.sharks());
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

	
}
