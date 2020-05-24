package View;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;

public class ChangeEgaleBehaviour {
	
	JPopupMenu popupMenu;
	ButtonGroup group = new ButtonGroup();
	List<JRadioButtonMenuItem> radioButtonMenuItems = new ArrayList<>();
	
	public ChangeEgaleBehaviour(String[] items, JButton parent) {
		popupMenu = new JPopupMenu();
		initMenu(items,parent);
	}
	
	private void initMenu(String[] items, JButton parent) {
		ActionListener actionPrinter = new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        try {
		          //pane.getStyledDocument().insertString(0,"Action [" + e.getActionCommand()+ "] performed!\n", null);
		        	JOptionPane.showMessageDialog(null,e.getActionCommand());
		        } catch (Exception ex) {
		          ex.printStackTrace();
		        }
		      }
		    };
		
		
		for(int i=0; i<items.length; i++) {
			JRadioButtonMenuItem item = new JRadioButtonMenuItem(items[i]/*,new ImageIcon("1.gif")*/);
			item.addActionListener(actionPrinter);
			radioButtonMenuItems.add(item);	
		}
		
		for(int i=0; i<radioButtonMenuItems.size(); i++) {
			popupMenu.add(radioButtonMenuItems.get(i));
			group.add(radioButtonMenuItems.get(i));
		}		
		parent.setComponentPopupMenu(popupMenu);
	}
	
	public void selectItem(String title) {
		for(int item = 0; item < radioButtonMenuItems.size(); item++) {
			if(radioButtonMenuItems.get(item).getText().compareToIgnoreCase(title)==0)
				radioButtonMenuItems.get(item).setSelected(true);
		}
	}
}
