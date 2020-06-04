package Controller;
import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import Entity.*;
import Model.Model;
import Patterns.Chain.AbstractLogger;
import Patterns.Command.CommandLineChanger;
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
		if(model.getContext().getGameState() != GameStatus.EGALE)
		{
			JOptionPane.showMessageDialog(null,"It is shark turn");
			Tile tileItem = (Tile) e.getSource();
			Shark sharkChoose = new Shark("");
			for(Shark shark : model.getSharks())
			{
				if(shark.getName().equalsIgnoreCase(tileItem.getAttribute()))
				{
					sharkChoose = shark;
				}
			}
			Eagle eagleChoose = new Eagle("");
			if(tileItem != null && controller.checkMovement(tileItem.getRow()-view.getBoard().getSelectedRow(),
					tileItem.getColumn()-view.getBoard().getSelectedColumn()))
			{
				for(Eagle eagle : model.getEagles())
				{
					if(eagle.getName().contains(tileItem.getAttribute()))
					{
						eagleChoose = eagle;
					}
				}
				if(eagleChoose.getLife() > 0)
				{
					eagleChoose.reduceLife(sharkChoose.getLifeAbility());
					if(eagleChoose.getLife() <= 0)
					{
						controller.doMovement(tileItem);
					}
				}
			}
			else
			{
				model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "Wrong selection");
				view.updateEagleLog(model.getLoggerChain().message);
			}
		}
		else 
		{
			Tile tile = (Tile) e.getSource();
			Eagle eagleChoose = new Eagle("");
			if(tile != null) 
			{
				if(Arrays.asList(model.eagles()).contains(tile.getAttribute()))
				{
					if(view.getBoard().getSelectedRow() == -1 && view.getBoard().getSelectedColumn() == -1) 
					{
						view.getBoard().setSelectedRow(tile.getRow());
						view.getBoard().setSelectedColumn(tile.getColumn());
						view.getBoard().setSelectedname(tile.getName());
						model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, tile.getAttribute() + " ( " +tile.getRow() + "," +tile.getColumn() + " )");
						view.updateEagleLog(model.getLoggerChain().message);
					}	
				}
				
				for(Eagle eagle : model.getEagles())
				{
					if(eagle.getName().contains(tile.getAttribute()))
					{
						eagleChoose = eagle;
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
					MouseListener bald = new BaldMouseListener();
					changeBehaviour.addMouseListener(bald);	
				}
				else if(eagleChoose.getName().equalsIgnoreCase("Black"))
				{
					MouseListener black = new BlackMouseListener();
					changeBehaviour.addMouseListener(black);	
				}
				else if(eagleChoose.getName().equalsIgnoreCase("Bateleur"))
				{
					MouseListener bateleur = new BateleurMouseListener();
					changeBehaviour.addMouseListener(bateleur);	
				}
				
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(currentLabel);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(eagleName);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(eagleLife);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(movementType);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).add(changeBehaviour);
				((Container) view.getCurrentAnimalPanel().getComponent(0)).validate();
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
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
