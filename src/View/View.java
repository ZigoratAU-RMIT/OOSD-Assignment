package View;


import javax.swing.*;
import java.awt.*;



public class View {

	private JFrame frmOodsAssignment;
	private JMenuBar menuBar;
	private JMenu mnuStart;
	private JMenu mnuPause;
	private JMenu mnuExit;
	
	private JPanel board;
	private JCheckBoxMenuItem chkTurn;
	private JMenuItem mntmNewMenuItem;
		
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

	public JPanel getBoard() {
		return board;
	}

	public void setBoard(JPanel board) {
		this.board = board;
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
		board = new Board(8,8);
		frmOodsAssignment.getContentPane().add(board, BorderLayout.CENTER);
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
		
		mntmNewMenuItem = new JMenuItem("");
		menuBar.add(mntmNewMenuItem);
		
		chkTurn = new JCheckBoxMenuItem("New check item");
		chkTurn.setEnabled(false);
		chkTurn.setBackground(Color.BLUE);
		chkTurn.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(chkTurn);
	}

	public JCheckBoxMenuItem getChkTurn() {
		return chkTurn;
	}

	public void setChkTurn(JCheckBoxMenuItem chkTurn) {
		this.chkTurn = chkTurn;
	}
}
