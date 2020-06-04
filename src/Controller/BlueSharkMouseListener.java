package Controller;

import java.awt.Container;
import java.awt.event.*;

import javax.swing.JLabel;

import Entity.*;
import View.View;

public class BlueSharkMouseListener implements MouseListener
{
	private Shark shark;
	private View view;
	public BlueSharkMouseListener(Shark shark, View view)
	{
		this.shark = shark;
		this.view = view;
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0)
	{
		((Container) view.getCurrentAnimalPanel().getComponent(0)).removeAll();
		JLabel currentLabel = new JLabel("This is the animal that you choose");
		JLabel sharkName = new JLabel(this.shark.getName());
		JLabel sharkLife = new JLabel("Life: " + String.valueOf(this.shark.getLife()));
		JLabel movementType = new JLabel("Movement: in '+' shape");
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(currentLabel);
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(sharkName);
		((Container) view.getCurrentAnimalPanel().getComponent(0)).add(sharkLife);
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
