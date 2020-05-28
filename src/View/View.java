package View;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;





public class View {

	private JFrame frmOodsAssignment;
	private JMenuBar menuBar;
	private JMenu mnuStart;
	private JMenu mnuPause;
	private JMenu mnuExit;
	
	private Board board;
	private boolean chkTurn;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnuOptions;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblTimer;
	
	private Timer timer;
		
	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

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
	private JRadioButton btnEgale;
	private JRadioButton btnShark;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JLabel lblEgaleScore;
	private JPanel panel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblSharkScore;
	private Component horizontalGlue;
	private Component horizontalGlue_1;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	public View() {
		initialFrame();
		initialMenu();
		ToolTipManager.sharedInstance().setInitialDelay(0);
		
		
		ActionListener countDown=new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		        timeLeft -= 100;
		        if(timeLeft <= 10000) {
		        	lblTimer.setBackground(Color.RED);
		        	lblTimer.setOpaque(true);
		        	lblNewLabel.setBackground(Color.RED);
		        	lblNewLabel.setOpaque(true);
		        	
		        }
		        else {
		        	lblTimer.setBackground(Color.LIGHT_GRAY);
		        	lblTimer.setOpaque(false);
		        	lblNewLabel.setBackground(Color.LIGHT_GRAY);
		        	lblNewLabel.setOpaque(false);
		        }
		        SimpleDateFormat df=new SimpleDateFormat("mm:ss");
		        lblTimer.setText(df.format(timeLeft));
		        UpdateTurnStatus();
		    }
		};
		timer = new Timer(100 ,countDown);
		timer.stop();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialFrame() {
		frmOodsAssignment = new JFrame();
		frmOodsAssignment.setTitle("OODS Assignment 1");
		frmOodsAssignment.setBounds(100, 100, 713, 423);
		frmOodsAssignment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOodsAssignment.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmOodsAssignment.getContentPane().setLayout(new BorderLayout(0, 0));
		board = new Board();//8,8);
		frmOodsAssignment.getContentPane().add(board);
		
		panel = new JPanel();
		frmOodsAssignment.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		horizontalGlue = Box.createHorizontalGlue();
		panel.add(horizontalGlue);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setAlignmentX(0.0f);
		panel.add(panel_1);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_1.add(panel_5);
		
		lblNewLabel = new JLabel("Timer:");
		panel_5.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTimer = new JLabel("30");
		panel_5.add(lblTimer);
		lblTimer.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTimer.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_3.add(panel_4);
		
		btnEgale = new JRadioButton("Egale Turn");
		panel_4.add(btnEgale);
		btnEgale.setEnabled(false);
		btnEgale.setSelected(true);
		btnEgale.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblNewLabel_1 = new JLabel("Score:");
		panel_4.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblEgaleScore = new JLabel("0");
		panel_4.add(lblEgaleScore);
		lblEgaleScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_3.add(panel_2);
		
		btnShark = new JRadioButton("Shark Turn");
		panel_2.add(btnShark);
		btnShark.setEnabled(false);
		btnShark.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		
		lblNewLabel_3 = new JLabel("Score:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel_2.add(lblNewLabel_3);
		
		lblSharkScore = new JLabel("0");
		lblSharkScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		panel_2.add(lblSharkScore);
		
		horizontalGlue_1 = Box.createHorizontalGlue();
		panel.add(horizontalGlue_1);
	}
	
	public JLabel getLblEgaleScore() {
		return lblEgaleScore;
	}

	public void setLblEgaleScore(JLabel lblEgaleScore) {
		this.lblEgaleScore = lblEgaleScore;
	}

	public JLabel getLblSharkScore() {
		return lblSharkScore;
	}

	public void setLblSharkScore(JLabel lblSharkScore) {
		this.lblSharkScore = lblSharkScore;
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
	}

	public boolean getChkTurn() {
		return chkTurn;
	}

	public void setChkTurn(boolean chkTurn) {
		this.chkTurn = chkTurn;
	}
	
	public void UpdateTurnStatus() {
        if(timeLeft<=0)
        {
        	timeLeft =(double) 30000;
        	chkTurn = !chkTurn;
        }
    	if(chkTurn) {
    		btnEgale.setSelected(true);
    		btnShark.setSelected(false);
    		btnEgale.setBackground(Color.GREEN);
    		btnShark.setBackground(Color.LIGHT_GRAY);
    		btnEgale.setOpaque(true);
    		btnShark.setOpaque(false);
    	}
    	else
    	{
    		btnShark.setSelected(true);
    		btnEgale.setSelected(false);
    		btnShark.setBackground(Color.GREEN);
    		btnEgale.setBackground(Color.LIGHT_GRAY);
    		btnShark.setOpaque(true);
    		btnEgale.setOpaque(false);
    	}
	}
	
	public void ResetTurnStatus() {
		timeLeft =(double) 30000;
		chkTurn = !chkTurn;
		UpdateTurnStatus();
	}
	
	public void UpdateScore(boolean item, int score) {
		if(item)
			lblEgaleScore.setText(String.valueOf(Integer.parseInt(lblEgaleScore.getText()) + 1));
		else
			lblSharkScore.setText(String.valueOf(Integer.parseInt(lblSharkScore.getText()) + 1));
	}
}
