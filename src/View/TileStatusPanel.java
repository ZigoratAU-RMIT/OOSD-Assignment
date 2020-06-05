package View;

import javax.swing.*;
import java.awt.*;

public class TileStatusPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TileStatusPanel()
	{
		this.setLayout(new GridLayout(0,1));
		JLabel tileTitle = new JLabel("Here is the information of the tile");
		this.add(tileTitle);
	}
	
}
