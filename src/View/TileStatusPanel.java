package View;

import javax.swing.*;
import java.awt.*;
import Entity.*;
import Controller.*;

public class TileStatusPanel extends JPanel
{
	public TileStatusPanel()
	{
		this.setLayout(new GridLayout(4,1));
		JLabel lblNewLabel_5 = new JLabel("Here is the information of the tile");
		this.add(lblNewLabel_5);
	}
}
