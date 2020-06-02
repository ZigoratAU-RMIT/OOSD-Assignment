package View;

import java.awt.*;
import javax.swing.*;

public class CurrentAnimalPanel extends JPanel
{
	public CurrentAnimalPanel()
	{
		this.setLayout(new GridLayout(5,1));
		JLabel currentLabel = new JLabel("This is the animal that you choose");
		this.add(currentLabel);	
	}

}
