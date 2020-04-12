package View;


import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Panel;


public class View {

	private JFrame frmOodsAssignment;
	private JMenuBar menuBar;
	private JMenu mnuStart;
	private JMenu mnuPause;
	private JMenu mnuExit;
	private JButton btnNewButton;
	
	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}
	
	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenu getMnuStart() {
		return mnuStart;
	}

	public void setMnuStart(JMenu mnuStart) {
		this.mnuStart = mnuStart;
	}

	public JMenu getMnuPause() {
		return mnuPause;
	}

	public void setMnuPause(JMenu mnuPause) {
		this.mnuPause = mnuPause;
	}

	public JMenu getMnuExit() {
		return mnuExit;
	}

	public void setMnuExit(JMenu mnuExit) {
		this.mnuExit = mnuExit;
	}
	
	public JFrame getFrame() {
		return frmOodsAssignment;
	}

	public void setFrame(JFrame frame) {
		this.frmOodsAssignment = frame;
	}

	/**
	 * Create the application.
	 */
	public View() {
		initialFrame();
		initialMenu();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialFrame() {
		frmOodsAssignment = new JFrame();
		frmOodsAssignment.setTitle("OODS Assignment 1");
		frmOodsAssignment.setBounds(100, 100, 496, 423);
		frmOodsAssignment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOodsAssignment.setExtendedState(JFrame.MAXIMIZED_BOTH);
		Panel panel = new Panel();
		frmOodsAssignment.getContentPane().add(panel, BorderLayout.CENTER);
		btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	}
	
	private void initialMenu() {
		menuBar = new JMenuBar();
		frmOodsAssignment.setJMenuBar(menuBar);
		
		mnuStart = new JMenu("Start");
		mnuStart.setMnemonic('S');
		menuBar.add(mnuStart);
		
		mnuPause = new JMenu("Pause");
		mnuPause.setMnemonic('P');
		menuBar.add(mnuPause);
		
		mnuExit = new JMenu("Exit");
		mnuExit.setMnemonic('x');
		menuBar.add(mnuExit);
	}

}
