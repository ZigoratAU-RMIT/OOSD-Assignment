package View;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;

import Patterns.State.Context.GameStatus;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;



public class View {

	private JFrame frmOodsAssignment;
	private JMenuBar menuBar;
	private JMenu mnuStartSop;
	private JMenu mnuSave;
	private JMenu mnuExit;
	
	private Board board;
	private JMenuItem mntmNewMenuItem;
	private JMenu mnuOptions;
	private JPanel pnlMain;
	private JLabel lblNewLabel;
	private JLabel lblTimer;
	private JRadioButton btnEgale;
	private JRadioButton btnShark;
	private JLabel lblNewLabel_1;
	private JLabel lblEgaleScore;
	private JPanel pnlShark;
	private JLabel lblNewLabel_3;
	private JLabel lblSharkScore;
	private JPanel pnlEgale;
	private JPanel pnlTimerContainer;
	private JPanel pnlEgaleInfo;
	private JLabel lblBateleur;
	private JLabel lblBlack;
	private JLabel lblBald;
	private JLabel lblBlackLife;
	private JLabel lblBaldLife;
	private JLabel lblBateleurLife;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_2;
	private JPanel pnlSharkInfo;
	private JLabel lblwhiteshark;
	private JLabel lblWhitesharkLife;
	private JLabel lblblueshark;
	private JLabel lblBluesharkLife;
	private JLabel lbltigershark;
	private JLabel lbTtigersharkLife;	
	private Timer timer;
	private JMenu mnuNew;
	private JPanel tileStatusPanel;
	private JPanel currentAnimalPanel;
	private JPanel pnlTimer;
	private JTextArea txtEagleLog;
	private JTextArea txtSharkLog;
		
	public JMenu getMnuNew() {
		return mnuNew;
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

	public JMenu getMnuStartStop() {
		return mnuStartSop;
	}

	public JMenu getMnuExit() {
		return mnuExit;
	}
	
	public JFrame getFrame() {
		return frmOodsAssignment;
	}

	public Board getBoard() {
		return board;
	}
	
	/**
	 * Create the application.
	 */
	
	public View() {
		initialFrame();
		initialMenu();
		ToolTipManager.sharedInstance().setInitialDelay(0);
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
		pnlEgaleInfo.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Egale", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
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
		
		pnlEgale = new JPanel();
		pnlEgaleInfo.add(pnlEgale);
		pnlEgale.setBackground(Color.ORANGE);
		
		btnEgale = new JRadioButton("");
		pnlEgale.add(btnEgale);
		btnEgale.setEnabled(false);
		btnEgale.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("Score:");
		pnlEgale.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblEgaleScore = new JLabel();
		pnlEgale.add(lblEgaleScore);
		lblEgaleScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		pnlTimerContainer = new JPanel();
		pnlMain.add(pnlTimerContainer);
		pnlTimerContainer.setBackground(Color.LIGHT_GRAY);
		
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
		
		pnlSharkInfo = new JPanel();
		pnlSharkInfo.setBorder(new TitledBorder(null, "Shark", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnlSharkInfo.setBackground(Color.PINK);
		pnlMain.add(pnlSharkInfo);
		pnlSharkInfo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_2 = new JLabel("Shrk Life");
		pnlSharkInfo.add(lblNewLabel_2);
		
		lblwhiteshark = new JLabel("");
		lblwhiteshark.setToolTipText("White Shark");
		lblwhiteshark.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSharkInfo.add(lblwhiteshark);
		
		lblWhitesharkLife = new JLabel("3");
		lblWhitesharkLife.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSharkInfo.add(lblWhitesharkLife);
		
		lblblueshark = new JLabel("");
		lblblueshark.setToolTipText("Blue Shark");
		lblblueshark.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSharkInfo.add(lblblueshark);
		
		lblBluesharkLife = new JLabel("3");
		lblBluesharkLife.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSharkInfo.add(lblBluesharkLife);
		
		lbltigershark = new JLabel("");
		lbltigershark.setToolTipText("Tiger Shark");
		lbltigershark.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSharkInfo.add(lbltigershark);
		
		lbTtigersharkLife = new JLabel("3");
		lbTtigersharkLife.setHorizontalAlignment(SwingConstants.CENTER);
		pnlSharkInfo.add(lbTtigersharkLife);
		
		pnlShark = new JPanel();
		pnlSharkInfo.add(pnlShark);
		pnlShark.setBackground(Color.PINK);
		
		btnShark = new JRadioButton("");
		pnlShark.add(btnShark);
		btnShark.setEnabled(false);
		btnShark.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		lblNewLabel_3 = new JLabel("Score:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pnlShark.add(lblNewLabel_3);
		
		lblSharkScore = new JLabel();
		lblSharkScore.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		pnlShark.add(lblSharkScore);
		
		tileStatusPanel = new TileStatusPanel();
		tileStatusPanel.setBackground(Color.LIGHT_GRAY);
		frmOodsAssignment.getContentPane().add(tileStatusPanel, BorderLayout.WEST);
		tileStatusPanel.setLayout(new GridLayout(0, 1, 0, 0));
		tileStatusPanel.setBorder(new LineBorder(new Color(255, 200, 0), 3, true));
		
		txtEagleLog = new JTextArea();
		txtEagleLog.setEditable(false);
		txtEagleLog.setColumns(10); 
		txtEagleLog.setLineWrap(false);
		tileStatusPanel.add(txtEagleLog);
		
		currentAnimalPanel = new CurrentAnimalPanel();
		currentAnimalPanel.setBackground(Color.LIGHT_GRAY);
		frmOodsAssignment.getContentPane().add(currentAnimalPanel, BorderLayout.EAST);
		currentAnimalPanel.setLayout(new GridLayout(0, 1, 0, 0));
		currentAnimalPanel.setBorder(new LineBorder(Color.PINK, 3, true));
		
		txtSharkLog = new JTextArea();
		txtSharkLog.setEditable(false);
		txtSharkLog.setColumns(10); 
		txtSharkLog.setLineWrap(false);
		currentAnimalPanel.add(txtSharkLog);
		txtSharkLog.setColumns(10);
		

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
	
	Double timeLeft=(double) 30000;
	public double updateTimer() {
		timeLeft -= 100;
        if(timeLeft <= 10000) {
        	pnlTimer.setBackground(Color.RED);
        }
        else {
        	pnlTimer.setBackground(Color.LIGHT_GRAY);
        }
        SimpleDateFormat df=new SimpleDateFormat("mm:ss");
        lblTimer.setText(df.format(timeLeft));
        return timeLeft;
	}
	
	public void changeGameStateTimer(GameStatus gameStatus) {
		timeLeft =(double) 30000;
		UpdateTurnViewStatus(gameStatus);
	}
	
	public void UpdateTurnViewStatus(GameStatus gameStatus) {
    	if(gameStatus == GameStatus.EGALE) {
    		pnlSharkInfo.setBackground(Color.PINK);
    		pnlEgaleInfo.setBackground(Color.GREEN);
    		btnEgale.setSelected(true);
    	}
    	else if(gameStatus == GameStatus.SHARK)
    	{
    		pnlSharkInfo.setBackground(Color.GREEN);
    		pnlEgaleInfo.setBackground(Color.ORANGE);
    		btnEgale.setSelected(false);
    	}
		btnShark.setSelected(!btnEgale.isSelected());
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
	
	public void updateEagleLog(String log) {
		if(log.length() == 0)
			return;
		if(txtEagleLog.getText().length() != 0) {
			txtEagleLog.append("\n");
			txtEagleLog.append(log);
		}
		else {
			txtEagleLog.append(log);
		}
	}

	public void updateSharkLog(String log) {
		if(log.length() == 0)
			return;
		if(txtSharkLog.getText().length() != 0) {
			txtSharkLog.append("\n");
			txtSharkLog.append(log);
		}
		else {
			txtSharkLog.append(log);
		}
	}
}
