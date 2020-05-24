package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

import javax.swing.JButton;

public class ChangeBehaviour extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeBehaviour frame = new ChangeBehaviour();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChangeBehaviour() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(contentPane, popupMenu);
		JRadioButtonMenuItem leftJustify = new JRadioButtonMenuItem("Egale 1"/*,new ImageIcon("1.gif")*/);
	    leftJustify.setHorizontalTextPosition(JMenuItem.RIGHT);
	    //leftJustify.setAccelerator(KeyStroke.getKeyStroke('L', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
	    //leftJustify.addActionListener(actionPrinter);
	    popupMenu.add(leftJustify);
	    
	    JRadioButtonMenuItem rightJustify = new JRadioButtonMenuItem("Egale 2"/*,new ImageIcon("2.gif")*/);
	    rightJustify.setHorizontalTextPosition(JMenuItem.RIGHT);
	    //rightJustify.setAccelerator(KeyStroke.getKeyStroke('R', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
	    //rightJustify.addActionListener(actionPrinter);
	    popupMenu.add(rightJustify);
	    
	    JRadioButtonMenuItem centerJustify = new JRadioButtonMenuItem("Egale 3"/*,new ImageIcon("3.gif")*/);
	    centerJustify.setHorizontalTextPosition(JMenuItem.RIGHT);
	    //centerJustify.setAccelerator(KeyStroke.getKeyStroke('M', Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
	    //centerJustify.addActionListener(actionPrinter);
	    popupMenu.add(centerJustify);
	    
	    ButtonGroup group = new ButtonGroup();
	    group.add(leftJustify);
	    group.add(rightJustify);
	    group.add(centerJustify);

	    
		
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("New button");
		
		List<String> items = new ArrayList<>();
		items.add("1");
		items.add("Egale 2");
		items.add("test");
		ChangeEgaleBehaviour item = new ChangeEgaleBehaviour(items.toArray(new String[items.size()]),btnNewButton);
		
		
		contentPane.add(btnNewButton, BorderLayout.WEST);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
