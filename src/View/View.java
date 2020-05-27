package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;





public class View {

	private JFrame frmOodsAssignment;
	private JMenuBar menuBar;
	private JMenu mnuStart;
	private JMenu mnuPause;
	private JMenu mnuExit;
	
	private Board board;
	private JCheckBoxMenuItem chkTurn;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnuOptions;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblTimer;
	
	private Timer timer;
		
	public JMenu getMnuBoardOptions() {
		return mnuOptions;
	}

	public void setMnuBoardOptions(JMenu mnuOptions) {
		this.mnuOptions = mnuOptions;
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
	
	/**
	 * Create the application.
	 */
	
	Double timeLeft=(double) 30000;
	public View() {
		initialFrame();
		initialMenu();
		ToolTipManager.sharedInstance().setInitialDelay(0);
		
		
		ActionListener countDown=new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        timeLeft -= 100;
		        SimpleDateFormat df=new SimpleDateFormat("mm:ss");
		        lblTimer.setText(df.format(timeLeft));
		        if(timeLeft<=0)
		        {
		        	timeLeft =(double) 30000;
		        	if(chkTurn.getBackground() == Color.BLUE)
		        		chkTurn.setBackground(Color.RED);
		        	else
		        		chkTurn.setBackground(Color.BLUE);
		            //timer.stop();
		        }
		    }
		};
		Timer timer = new Timer(100 ,countDown);
        timer.start();
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
		frmOodsAssignment.getContentPane().setLayout(new BorderLayout(0, 0));
		board = new Board();//8,8);
		frmOodsAssignment.getContentPane().add(board);
		
		panel = new JPanel();
		frmOodsAssignment.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("Timer:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblNewLabel);
		
		lblTimer = new JLabel("30");
		lblTimer.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblTimer.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblTimer);
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
		
		mnuOptions = new JMenu("BoardOptions");
		menuBar.add(mnuOptions);
		
		mnuExit = new JMenu("Exit");
		mnuExit.setMnemonic('x');
		menuBar.add(mnuExit);
		
		mntmNewMenuItem = new JMenuItem("");
		menuBar.add(mntmNewMenuItem);
		
		chkTurn = new JCheckBoxMenuItem("New check item");
		menuBar.add(chkTurn);
	}

	public JCheckBoxMenuItem getChkTurn() {
		return chkTurn;
	}

	public void setChkTurn(JCheckBoxMenuItem chkTurn) {
		this.chkTurn = chkTurn;
	}
}
