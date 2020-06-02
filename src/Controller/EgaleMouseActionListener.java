package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

import Model.Model;
import Patterns.Chain.AbstractLogger;
import Patterns.State.Context.GameStatus;
import View.Tile;
import View.View;

public class EgaleMouseActionListener  implements MouseListener 
{
	private Model model;
	private View view;
	
	public EgaleMouseActionListener(View view, Model model) {
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
			view.updateEagleLog(model.getLoggerChain().message);
		}
		else 
		{
			Tile tile = (Tile) e.getSource();
			if(tile != null) 
			{
				if(Arrays.asList(model.eagles()).contains(tile.getAttribute()))
					if(view.getBoard().getSelectedRow() == -1 && view.getBoard().getSelectedColumn() == -1) {
						view.getBoard().setSelectedRow(tile.getRow());
						view.getBoard().setSelectedColumn(tile.getColumn());
						view.getBoard().setSelectedname(tile.getName());
						model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, tile.getAttribute() + " ( " +tile.getRow() + "," +tile.getColumn() + " )");
						view.updateEagleLog(model.getLoggerChain().message);
					}	
				
				
//				for(Eagle eagle : model.getEagles())
//				{
//					if(eagle.getName().contains(tile.getAttribute()))
//					{
//						if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) 
//						{
//							board.setSelectedRow(tile.getRow());
//							board.setSelectedColumn(tile.getColumn());
//							board.setSelectedname(tile.getName());
//							model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "EAGLE ( " +tile.getRow() + "," +tile.getColumn() + " )");	
//						}
////						view.getCurrentAnimalPanel().removeAll();
////						JLabel currentLabel = new JLabel("This is the animal that you choose");
////						JLabel eagleName = new JLabel(eagle.getName());
////						JLabel eagleLife = new JLabel("Life: " + String.valueOf(eagle.getLife()));
////						JLabel movementType = new JLabel("Movement: in 3 tiles");
////						JButton changeBehaviour = new JButton("Use Ability");
//////						changeBehaviour.add(null);
////						view.getCurrentAnimalPanel().add(currentLabel);
////						view.getCurrentAnimalPanel().add(eagleName);
////						view.getCurrentAnimalPanel().add(eagleLife);
////						view.getCurrentAnimalPanel().add(movementType);
////						view.getCurrentAnimalPanel().add(changeBehaviour);
////						view.getCurrentAnimalPanel().validate();
//						
//					}
//				}		
			}
		}
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
		Tile tile = (Tile) e.getSource();
 		if(tile != null) {
 			if(tile.getAttribute().compareTo("Black") == 0)
 			tile.setToolTipText("<html>"
                     + "▓"
                     +"<br>"
                     + "▓"
                     +"<br>"
                     + "▓ ▓ ▓ ▓"
                + "</html>");
 			if(tile.getAttribute().compareTo("Bald") == 0)
 			tile.setToolTipText("<html>"
                     + "▓"
                     +"<br>"
                     + "▓"
                     +"<br>"
                     + "▓ ▓ ▓"
                + "</html>");
 			if(tile.getAttribute().compareTo("Bateleur") == 0)
 			tile.setToolTipText("<html>"
                     + "▓"
                     +"<br>"
                     + "▓"
                     +"<br>"
                     + "▓ ▓"
                + "</html>");
 		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
