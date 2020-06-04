package Controller;

import java.awt.Container;
import java.awt.event.*;

import javax.swing.JLabel;

import Entity.*;
import View.View;

public class BlackMouseListener implements MouseListener
{
	private Eagle eagle;
	private View view;
	public BlackMouseListener(Eagle eagle, View view)
	{
		this.eagle = eagle;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		((Container) view.getCurrentAnimalPanel().getComponent(0)).removeAll();
		JLabel currentLabel = new JLabel("This is the animal that you choose");
		JLabel eagleName = new JLabel(this.eagle.getName());
		JLabel eagleLife = new JLabel("Life: " + String.valueOf(this.eagle.getLife()));
		JLabel movementType = new JLabel("Movement: in 3 tiles");
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(currentLabel);
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(eagleName);
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(eagleLife);
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(movementType);
		((Container) view.getCurrentAnimalPanel().getComponent(0)).validate();
		
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

