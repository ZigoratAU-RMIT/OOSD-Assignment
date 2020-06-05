package View;

import javax.swing.*;
import java.awt.*;

public class CurrentAnimalPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CurrentAnimalPanel()
	{
		this.setLayout(new GridLayout(0,1));
		JLabel currentAnimalTitle = new JLabel("This is the animal that you choose");
		this.add(currentAnimalTitle);
	}
	
}
