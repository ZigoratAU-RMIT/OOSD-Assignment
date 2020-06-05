package Controller;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import Model.Model;
import Patterns.Chain.AbstractGameLogger;
import Patterns.Decorator.EagleDecorator;
import Patterns.Decorator.SharkDecorator;
import View.Board;
import View.Tile;
import View.View;

public class SharkMouseActionListener  implements MouseListener 
{
	private Board board;
	private View view;
	private Model model;
	private Controller controller;
	
	public SharkMouseActionListener(Controller controller) {// View view, Model model) {
		this.controller = controller;
		this.model = controller.getModel();// model;
		this.view = controller.getView();// view;
		this.board = view.getBoard();
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{	
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
			JOptionPane.showMessageDialog(null,"It is Eagle turn");
			break;
		case EGALEATTACK:
			EagleDecorator eagleChooseAttack = new EagleDecorator("");
			for(EagleDecorator eagle : model.getEagles())
			{
				if(eagle.getName().equalsIgnoreCase(model.getAttacker().getAttribute()))
				{
					eagleChooseAttack = eagle;
					break;
				}
			}
			Tile tileItemAttack = (Tile) e.getSource();
			SharkDecorator sharkChooseAttack = new SharkDecorator("");
			if(tileItemAttack != null && controller.checkMovement(tileItemAttack.getRow()-view.getBoard().getSelectedRow(),
					tileItemAttack.getColumn()-view.getBoard().getSelectedColumn()))
			{
				for(SharkDecorator shark : model.getSharks())
				{
					if(shark.getName().contains(tileItemAttack.getAttribute()))
					{
						sharkChooseAttack = shark;
						break;
					}
				}
				if(sharkChooseAttack.getLife() >  0)
				{
					sharkChooseAttack.reduceLife(eagleChooseAttack.getLifeAbility());
					view.updateLife(tileItemAttack.getAttribute(),eagleChooseAttack.getLife());
					if(sharkChooseAttack.getLife() <= 0)
					{
						controller.doMovement(tileItemAttack);
					}
					else if(sharkChooseAttack.getLife() != 3 && eagleChooseAttack.getName().equalsIgnoreCase("Bateleur"))
					{
						controller.doMovement(tileItemAttack);
					}
				}
			}
			else
			{
				model.getLoggerChain().setwMessage(AbstractGameLogger.EAGLE, "Wrong selection");
			}
			break;
		case SHARK:
			Tile tile = (Tile) e.getSource();
			SharkDecorator sharkChoose1 = new SharkDecorator("");
			if(tile != null) 
			{
				for(SharkDecorator shark : model.getSharks())
				{
					if(shark.getName().contains(tile.getAttribute()))
					{
						sharkChoose1 = shark;
						break;
					}
				}
				if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) 
				{
					board.setSelectedRow(tile.getRow());
					board.setSelectedColumn(tile.getColumn());
					board.setSelectedname(tile.getName());
					//set Shark message
					model.getLoggerChain().setwMessage(AbstractGameLogger.SHARK, "SHARK ( " +tile.getRow() + "," +tile.getColumn() + " )");
					view.updateSharkLog(model.getLoggerChain().message);
				}
				((Container) view.getCurrentAnimalPanel().getComponent(0)).removeAll();
				JLabel currentLabel = new JLabel("This is the animal that you choose");
				JLabel sharkName = new JLabel(sharkChoose1.getName());
				JLabel sharkLife = new JLabel("Life: " + String.valueOf(sharkChoose1.getLife()));
				JLabel movementType = new JLabel("Movement: in '+' shape");
				
				JButton changeBehaviour = new JButton("Use Ability");
				if(sharkChoose1.getName().equalsIgnoreCase("white shark"))
				{
					MouseListener whiteShark = new WhiteSharkMouseListener(sharkChoose1,view);
					changeBehaviour.addMouseListener(whiteShark);
				}
				else if(sharkChoose1.getName().equalsIgnoreCase("blue shark"))
				{
					MouseListener blueShark = new BlueSharkMouseListener(sharkChoose1,view);
					changeBehaviour.addMouseListener(blueShark);
				}
				else if(sharkChoose1.getName().equalsIgnoreCase("tiger shark"))
				{
					MouseListener tigerShark = new TigerSharkMouseListener(sharkChoose1,view);
					changeBehaviour.addMouseListener(tigerShark);
				}
				
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(currentLabel);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(sharkName);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(sharkLife);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(movementType);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(changeBehaviour);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).validate();
			}	
			model.setAttacker(tile);
			model.getGameState().doSharkAttackAction(model.getContext());
			break;
		case SHARKATTACK:
			JOptionPane.showMessageDialog(null,"Shark could not attack thmeselves. Select Shark Again");
			model.getGameState().doSharkAction(model.getContext());
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
