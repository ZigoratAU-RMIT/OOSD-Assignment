package View;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class View {

	private JFrame frmOodsAssignment;
	private JMenuBar menuBar;
	private JMenu mnuStartSop;
	private JMenu mnuSave;
	private JMenu mnuExit;
	
	private Board board;
	private boolean chkTurn;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnuOptions;
	private JPanel pnlMain;
	private JLabel lblNewLabel;
	private JLabel lblTimer;
	
	Double timeLeft=(double) 30000;
	
	private JRadioButton btnEgale;
	private JRadioButton btnShark;
	private JPanel pnlGameReport;
	private JLabel lblNewLabel_1;
	private JLabel lblEgaleScore;
	private JPanel pnlShark;
	private JLabel lblNewLabel_3;
	private JLabel lblSharkScore;
	private JPanel pnlInfo;
	private JPanel pnlEgale;
	private JLabel lblNewLabel_4;
	private JPanel pnlTimerContainer;
	private JPanel pnlTurn;
	private JPanel pnlEgaleInfo;
	private JLabel lblBateleur;
	private JLabel lblBlack;
	private JLabel lblBald;
	private JLabel lblBlackLife;
	private JLabel lblBaldLife;
	private JLabel lblBateleurLife;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_2;
	private JPanel panel_2;
	private JLabel lblwhiteshark;
	private JLabel lblWhitesharkLife;
	private JLabel lblblueshark;
	private JLabel lblBluesharkLife;
	private JLabel lbltigershark;
	private JLabel lbTtigersharkLife;	
	private Timer timer;
	private JMenu mnuNew;
	private JPanel panel;
	private JLabel lblNewLabel_5;
	private JPanel pnlTimer;
		
	public JMenu getMnuNew() {
		return mnuNew;
	}

	public void setMnuNew(JMenu mnuNew) {
		this.mnuNew = mnuNew;
	}

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

	public JMenu getMnuStartStop() {
		return mnuStartSop;
	}

	public void setMnuStartStop(JMenu mnuStart) {
		this.mnuStartSop = mnuStart;
	}

	public JMenu getMnuPause() {
		return mnuSave;
	}

	public void setMnuPause(JMenu mnuPause) {
		this.mnuSave = mnuPause;
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
		        	pnlTimerContainer.setBackground(Color.RED);
		        	pnlTimerContainer.setBackground(Color.RED);
		        	
		        }
		        else {
		        	pnlTimerContainer.setBackground(Color.LIGHT_GRAY);
		        	pnlTimerContainer.setBackground(Color.LIGHT_GRAY);
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
		frmOodsAssignment.setBounds(100, 100, 764, 521);
		frmOodsAssignment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmOodsAssignment.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmOodsAssignment.getContentPane().setLayout(new BorderLayout(0, 0));
		board = new Board();//8,8);
		frmOodsAssignment.getContentPane().add(board, BorderLayout.CENTER);
		
		pnlMain = new JPanel();
		frmOodsAssignment.getContentPane().add(pnlMain, BorderLayout.NORTH);
		pnlMain.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		pnlEgaleInfo = new JPanel();
		pnlEgaleInfo.setBackground(Color.ORANGE);
		pnlMain.add(pnlEgaleInfo);
		pnlEgaleInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_11 = new JLabel("Egale Life");
		pnlEgaleInfo.add(lblNewLabel_11);
		
		lblBateleur = new JLabel("");
		lblBateleur.setToolTipText("Bateleur");
		lblBateleur.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEgaleInfo.add(lblBateleur);
		
		lblBateleurLife = new JLabel("3");
		lblBateleurLife.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEgaleInfo.add(lblBateleurLife);
		
		lblBald = new JLabel("");
		lblBald.setToolTipText("Bald");
		lblBald.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEgaleInfo.add(lblBald);
		
		lblBaldLife = new JLabel("3");
		lblBaldLife.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEgaleInfo.add(lblBaldLife);
		
		lblBlack = new JLabel("");
		lblBlack.setToolTipText("Black");
		lblBlack.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEgaleInfo.add(lblBlack);
		
		lblBlackLife = new JLabel("3");
		lblBlackLife.setHorizontalAlignment(SwingConstants.CENTER);
		pnlEgaleInfo.add(lblBlackLife);
		
		pnlGameReport = new JPanel();
		pnlGameReport.setBackground(Color.GRAY);
		pnlGameReport.setAlignmentX(0.0f);
		pnlMain.add(pnlGameReport);
		pnlGameReport.setLayout(new BorderLayout(0, 0));
		
		pnlInfo = new JPanel();
		pnlInfo.setBackground(Color.LIGHT_GRAY);
		pnlGameReport.add(pnlInfo);
		
		pnlTurn = new JPanel();
		pnlTurn.setBackground(Color.LIGHT_GRAY);
		pnlInfo.add(pnlTurn);
		
		lblNewLabel_4 = new JLabel("Turn :");
		pnlTurn.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		
		pnlEgale = new JPanel();
		pnlEgale.setBackground(Color.LIGHT_GRAY);
		pnlInfo.add(pnlEgale);
		
		btnEgale = new JRadioButton("Egale");
		pnlEgale.add(btnEgale);
		btnEgale.setEnabled(false);
		btnEgale.setSelected(true);
		btnEgale.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("Score:");
		pnlEgale.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblEgaleScore = new JLabel();
		pnlEgale.add(lblEgaleScore);
		lblEgaleScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		pnlShark = new JPanel();
		pnlShark.setBackground(Color.LIGHT_GRAY);
		pnlInfo.add(pnlShark);
		
		btnShark = new JRadioButton("Shark");
		pnlShark.add(btnShark);
		btnShark.setEnabled(false);
		btnShark.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblNewLabel_3 = new JLabel("Score:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pnlShark.add(lblNewLabel_3);
		
		lblSharkScore = new JLabel();
		lblSharkScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pnlShark.add(lblSharkScore);
		
		pnlTimerContainer = new JPanel();
		pnlTimerContainer.setBackground(Color.LIGHT_GRAY);
		pnlGameReport.add(pnlTimerContainer, BorderLayout.NORTH);
		
		pnlTimer = new JPanel();
		pnlTimer.setBackground(Color.LIGHT_GRAY);
		pnlTimerContainer.add(pnlTimer);
		
		lblNewLabel = new JLabel("Timer:");
		pnlTimer.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblTimer = new JLabel("30");
		pnlTimer.add(lblTimer);
		lblTimer.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblTimer.setHorizontalAlignment(SwingConstants.RIGHT);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		pnlMain.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_2 = new JLabel("Shrk Life");
		panel_2.add(lblNewLabel_2);
		
		lblwhiteshark = new JLabel("");
		lblwhiteshark.setToolTipText("White Shark");
		lblwhiteshark.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblwhiteshark);
		
		lblWhitesharkLife = new JLabel("3");
		lblWhitesharkLife.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblWhitesharkLife);
		
		lblblueshark = new JLabel("");
		lblblueshark.setToolTipText("Blue Shark");
		lblblueshark.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblblueshark);
		
		lblBluesharkLife = new JLabel("3");
		lblBluesharkLife.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblBluesharkLife);
		
		lbltigershark = new JLabel("");
		lbltigershark.setToolTipText("Tiger Shark");
		lbltigershark.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lbltigershark);
		
		lbTtigersharkLife = new JLabel("3");
		lbTtigersharkLife.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lbTtigersharkLife);
		
		panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frmOodsAssignment.getContentPane().add(panel, BorderLayout.SOUTH);
		
		lblNewLabel_5 = new JLabel("Game is running now");
		panel.add(lblNewLabel_5);
	}
	
	public JLabel getLblEgaleScore() {
		return lblEgaleScore;
	}

	public void setLblEgaleScore(int score) {
		this.lblEgaleScore.setText(String.valueOf(score));
	}

	public JLabel getLblSharkScore() {
		return lblSharkScore;
	}

	public void setLblSharkScore(int score) {
		this.lblSharkScore.setText(String.valueOf(score));
	}

	private void initialMenu() {
		menuBar = new JMenuBar();
		frmOodsAssignment.setJMenuBar(menuBar);
		
		mnuStartSop = new JMenu("Stop");
		mnuStartSop.setMnemonic('S');
		menuBar.add(mnuStartSop);
		
		mnuSave = new JMenu("Save Game");
		mnuSave.setMnemonic('P');
		menuBar.add(mnuSave);
		
		mnuNew = new JMenu("New Game");
		mnuNew.setMnemonic('P');
		menuBar.add(mnuNew);
		
		mnuOptions = new JMenu("BoardOptions");
		menuBar.add(mnuOptions);
		
		mnuExit = new JMenu("Exit");
		mnuExit.setMnemonic('x');
		menuBar.add(mnuExit);
		
		mntmNewMenuItem = new JMenuItem("");
		menuBar.add(mntmNewMenuItem);		
	}

	public JMenu getMnuSave() {
		return mnuSave;
	}

	public void setMnuSave(JMenu mnuSave) {
		this.mnuSave = mnuSave;
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
        	board.changeTurn();
        }
    	if(chkTurn) {
    		btnEgale.setSelected(true);
    		btnShark.setSelected(false);
    		pnlEgale.setBackground(Color.GREEN);
    		pnlShark.setBackground(Color.LIGHT_GRAY);
    	}
    	else
    	{
    		btnShark.setSelected(true);
    		btnEgale.setSelected(false);
    		pnlEgale.setBackground(Color.LIGHT_GRAY);
    		pnlShark.setBackground(Color.GREEN);
    	}
	}
	
	public void ResetTurnStatus() {
		timeLeft =(double) 30000;
		UpdateTurnStatus();
		chkTurn = !chkTurn;
	}
	
	private Image loadImage(String imageName) {
		try
		{
			Image img = ImageIO.read(new FileInputStream(String.format("resources%s%s%s%s", File.separator, "images",File.separator, imageName + ".jpg")));
			return img;
		}
		catch (FileNotFoundException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		catch (IOException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}
	public void ShowGameDetails(String[] eagls,String[] sharks) {
		for(int i=0; i< eagls.length; i++) {
			Image img = loadImage(eagls[i]);
			if(img!= null)
				switch(i) {
				case 0:
					lblBateleur.setIcon(new ImageIcon(img.getScaledInstance(45,45, Image.SCALE_SMOOTH)));
					break;
				case 1:
					lblBlack.setIcon(new ImageIcon(img.getScaledInstance(45,45, Image.SCALE_SMOOTH)));
					break;
				case 2:
					lblBald.setIcon(new ImageIcon(img.getScaledInstance(45,45, Image.SCALE_SMOOTH)));
					break;
				}
		}
		for(int i=0; i< sharks.length; i++) {
			Image img = loadImage(sharks[i]);
			if(img!= null)
				switch(i) {
				case 0:
					lblwhiteshark.setIcon(new ImageIcon(img.getScaledInstance(45,45, Image.SCALE_SMOOTH)));
					break;
				case 1:
					lblblueshark.setIcon(new ImageIcon(img.getScaledInstance(45,45, Image.SCALE_SMOOTH)));
					break;
				case 2:
					lbltigershark.setIcon(new ImageIcon(img.getScaledInstance(45,45, Image.SCALE_SMOOTH)));
					break;
				}
		}}
	
	public void UpdateScore(boolean item, int score) {
		if(item)
			lblEgaleScore.setText(String.valueOf(Integer.parseInt(lblEgaleScore.getText()) + 1));
		else
			lblSharkScore.setText(String.valueOf(Integer.parseInt(lblSharkScore.getText()) + 1));
	}
	
	public JLabel getLblBateleur() {
		return lblBateleur;
	}

	public void setLblBateleur(JLabel lblBateleur) {
		this.lblBateleur = lblBateleur;
	}

	public JLabel getLblBlack() {
		return lblBlack;
	}

	public void setLblBlack(JLabel lblBlack) {
		this.lblBlack = lblBlack;
	}

	public JLabel getLblBald() {
		return lblBald;
	}

	public void setLblBald(JLabel lblBald) {
		this.lblBald = lblBald;
	}

	public JLabel getLblBlackLife() {
		return lblBlackLife;
	}

	public void setLblBlackLife(JLabel lblBlackLife) {
		this.lblBlackLife = lblBlackLife;
	}

	public JLabel getLblBaldLife() {
		return lblBaldLife;
	}

	public void setLblBaldLife(JLabel lblBaldLife) {
		this.lblBaldLife = lblBaldLife;
	}

	public JLabel getLblBateleurLife() {
		return lblBateleurLife;
	}

	public void setLblBateleurLife(JLabel lblBateleurLife) {
		this.lblBateleurLife = lblBateleurLife;
	}

	public void StartStopGame(boolean StartStop) {
		if(StartStop) {
			mnuStartSop.setText("Start");
			timer.stop();
			pnlMain.setEnabled(false);
		}
		else {
			mnuStartSop.setText("Stop");
			timer.start();
			pnlMain.setEnabled(true);
		}
	}
}
