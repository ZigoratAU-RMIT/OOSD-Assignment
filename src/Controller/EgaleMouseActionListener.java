package Controller;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Model.Model;
import Patterns.Chain.AbstractGameLogger;
import Patterns.Decorator.EagleDecorator;
import Patterns.Decorator.SharkDecorator;
import Patterns.State.Context.GameStatus;
import View.Tile;
import View.View;

public class EgaleMouseActionListener implements MouseListener
{
	private Model model;
	private View view;
	private Controller controller;

	public EgaleMouseActionListener(Controller controller) {// View view, Model model) {
		this.controller = controller;
		this.model = controller.getModel();// model;
		this.view = controller.getView();// view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		switch(model.getContext().getGameState()) {
		case BEGIN:
			JOptionPane.showMessageDialog(null,"The Game is not Started.");
			break;
		case START:
			JOptionPane.showMessageDialog(null,"Please select an Animal to play.");
			break;
		case PAUSE:
			JOptionPane.showMessageDialog(null,"Gmae is in pause mode.");
			break;
		case EGALE:
			Tile tile = (Tile) e.getSource();
			EagleDecorator eagleChoose = new EagleDecorator("");
			if(tile != null) 
			{
				if(Arrays.asList(model.eagles()).contains(tile.getAttribute()))
				{
					if(view.getBoard().getSelectedRow() == -1 && view.getBoard().getSelectedColumn() == -1) 
					{
						view.getBoard().setSelectedRow(tile.getRow());
						view.getBoard().setSelectedColumn(tile.getColumn());
						view.getBoard().setSelectedname(tile.getName());
						model.getLoggerChain().setwMessage(AbstractGameLogger.EAGLE, tile.getAttribute() + " ( " +tile.getRow() + "," +tile.getColumn() + " )");
						view.updateEagleLog(model.getLoggerChain().message);
					}	
				}

				for(EagleDecorator eagle : model.getEagles())
				{
					if(eagle.getName().contains(tile.getAttribute()))
					{
						eagleChoose = eagle;
						break;
					}
				}
				((Container) view.getCurrentAnimalPanel().getComponent(0)).removeAll();
				JLabel currentLabel = new JLabel("This is the animal that you choose");
				JLabel eagleName = new JLabel(eagleChoose.getName());
				JLabel eagleLife = new JLabel("Life: " + String.valueOf(eagleChoose.getLife()));
				JLabel movementType = new JLabel("Movement: in 3 tiles");

				JButton changeBehaviour = new JButton("Use Ability");
				if(eagleChoose.getName().equalsIgnoreCase("Bald"))
				{
					MouseListener bald = new BaldMouseListener(eagleChoose,view);
					changeBehaviour.addMouseListener(bald);	
				}
				else if(eagleChoose.getName().equalsIgnoreCase("Black"))
				{
					MouseListener black = new BlackMouseListener(eagleChoose,view);
					changeBehaviour.addMouseListener(black);	
				}
				else if(eagleChoose.getName().equalsIgnoreCase("Bateleur"))
				{
					MouseListener bateleur = new BateleurMouseListener(eagleChoose,view);
					changeBehaviour.addMouseListener(bateleur);	
				}

				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(currentLabel);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(eagleName);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(eagleLife);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(movementType);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(changeBehaviour);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).validate();
			}
			model.setAttacker(tile);
			model.getGameState().doEgaleAttackAction(model.getContext());
			break;
		case EGALEATTACK:
			JOptionPane.showMessageDialog(null,"Egale could not attack thmeselves. Select Egale Again");
			model.getGameState().doSharkAction(model.getContext());			
			break;
		case SHARK:
			JOptionPane.showMessageDialog(null,"It is Shark turn");
			break;
		case SHARKATTACK:
			//Tile tileItem = (Tile) e.getSource();
			//Tile tileItem =  model.getAttacker();
			SharkDecorator sharkChoose = new SharkDecorator("");
			for(SharkDecorator shark : model.getSharks())
			{
				if(shark.getName().equalsIgnoreCase(model.getAttacker().getAttribute()))
				{
					sharkChoose = shark;
					break;
				}
			}
			Tile tileItem = (Tile) e.getSource();
			EagleDecorator eagleChoose1 = new EagleDecorator("");
			if(tileItem != null && controller.checkMovement(tileItem.getRow()-view.getBoard().getSelectedRow(),
					tileItem.getColumn()-view.getBoard().getSelectedColumn()))
			{
				for(EagleDecorator eagle : model.getEagles())
				{
					if(eagle.getName().contains(tileItem.getAttribute()))
					{
						eagleChoose1 = eagle;
						break;
					}
				}
				if(eagleChoose1.getLife() > 0)
				{
					eagleChoose1.reduceLife(sharkChoose.getLifeAbility());
					view.updateLife(tileItem.getAttribute(),eagleChoose1.getLife());
					if(eagleChoose1.getLife() <= 0)
					{
						controller.doMovement(tileItem);
					}
				}
			}
			else
			{
				model.getLoggerChain().setwMessage(AbstractGameLogger.EAGLE, "Wrong selection");
				view.updateEagleLog(model.getLoggerChain().message);
			}
			break;
		case END:
			JOptionPane.showMessageDialog(null,"Game was finished.");
			break;
		default:
			break;
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
