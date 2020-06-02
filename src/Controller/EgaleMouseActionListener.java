package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Entity.Eagle;
import Model.Model;
import Patterns.Chain.AbstractLogger;
import Patterns.State.Context.GameStatus;
import View.Board;
import View.Tile;
import View.View;

public class EgaleMouseActionListener  implements MouseListener 
{
	private Board board;
	private Model model;
	private View view;
	
	public EgaleMouseActionListener(View view, Model model) {
		this.board = view.getBoard();
		this.model = model;
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(model.getContext().getGameState() != GameStatus.EGALE)
		{
			JOptionPane.showMessageDialog(null,"It is shark turn");
			model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "Wrong selection");
		}
		else 
		{
			Tile tile = (Tile) e.getSource();
			if(tile != null) 
			{
				for(Eagle eagle : model.getEagles())
				{
					if(eagle.getName().contains(tile.getAttribute()))
					{
						if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) 
						{
							board.setSelectedRow(tile.getRow());
							board.setSelectedColumn(tile.getColumn());
							board.setSelectedname(tile.getName());
							model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "EAGLE ( " +tile.getRow() + "," +tile.getColumn() + " )");	
						}
//						view.getCurrentAnimalPanel().removeAll();
//						JLabel currentLabel = new JLabel("This is the animal that you choose");
//						JLabel eagleName = new JLabel(eagle.getName());
//						JLabel eagleLife = new JLabel("Life: " + String.valueOf(eagle.getLife()));
//						JLabel movementType = new JLabel("Movement: in 3 tiles");
//						JButton changeBehaviour = new JButton("Use Ability");
////						changeBehaviour.add(null);
//						view.getCurrentAnimalPanel().add(currentLabel);
//						view.getCurrentAnimalPanel().add(eagleName);
//						view.getCurrentAnimalPanel().add(eagleLife);
//						view.getCurrentAnimalPanel().add(movementType);
//						view.getCurrentAnimalPanel().add(changeBehaviour);
//						view.getCurrentAnimalPanel().validate();
						
					}
				}		
			}
		}
		view.updateEagleLog(model.getLoggerChain().message);
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
	
	
}
