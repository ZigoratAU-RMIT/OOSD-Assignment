package Controller;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Model;
import View.*;

public class Controller {

	private View view;	
	private Model model;
	
	public Controller() {
		
	}
	
	
	public void initView() {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				view.getFrame().setVisible(true);
				//view.getBoard().changeTurn();// changeTurn();
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
	
	private void showBoard() {
		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(view.getBoard(),model.eagles());
		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(view.getBoard(),model.sharks());
		PieceMoveActionListener pieceMoveActionListener = new PieceMoveActionListener(view,model);

		int item = 0;
		Tile tile;
		for(int x = 0;x<view.getBoard().getRow();x++)
			for(int y = 0;y<view.getBoard().getColumn();y++) {
				tile = model.getTiles().get(item++);
				String attribute = tile.getAttribute();
				if(model.isContaingEagle(attribute)) 
				{
					tile.addMouseListener(egaleMouseActionListener);
				}
				else if(model.isContaingShark(attribute))
				{
					tile.addMouseListener(sharkMouseActionListener);
				}
				else
				{
					tile.addMouseListener(pieceMoveActionListener);
				}
				view.getBoard().add(tile);
			}		
	}
	
	public void initController() {					
		model.getApplicationConfiguration().ReadApplicationConfiguration();
		model.checkLoadingGame();
		
		view.getBoard().setRow(model.getApplicationConfiguration().getBoardRows());
		view.getBoard().setColumn(model.getApplicationConfiguration().getBoardColumns());
		view.getBoard().initBoard();		
		
		model.initModel(view.getBoard().getRow(),view.getBoard().getColumn());	
		
		initView();
		showBoard();
		
		view.setChkTurn(model.getApplicationConfiguration().getGameTurn());
		view.setLblEgaleScore(model.getApplicationConfiguration().getEgaleScore());
		view.setLblSharkScore(model.getApplicationConfiguration().getSharkScore());
		view.UpdateTurnStatus();
		view.getTimer().start();
		
		view.getMnuStart().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			startClick();
			}	
		});		
		
		view.getMnuPause().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
				pauseClick();
			}	
		});

		view.getMnuExit().addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			doExit();
			}	
		});
		
		view.getMnuBoardOptions().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				boardOptionsClick(); 	
			}
		});
	}
	
	private void doExit() {
		int result = JOptionPane.showConfirmDialog(null, "Do you want to exit and save?");
		if(result == 0) {
			model.getApplicationConfiguration().WriteApplicationConfiguration(this);
			System.exit(0);
		}
		if(result == 1) {
			System.exit(0);
		}
	}
	
	private void boardOptionsClick() {
		try {
			BoardOptions dialog = new BoardOptions(view.getBoard().getRow(),view.getBoard().getColumn());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			if(view.getBoard().getRow() != dialog.getRows()) {
				view.getBoard().setRow(dialog.getRows());
				view.getBoard().setColumn(dialog.getColumns());
				view.getBoard().updateBoard();
				model.initModel(view.getBoard().getRow(),view.getBoard().getColumn());
				view.getBoard().removeAll();
				showBoard();
				view.getBoard().validate();
				JOptionPane.showMessageDialog(null,"Board was changed and game was rested.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	private void startClick() {
		JOptionPane.showMessageDialog(null,view.getBoard().getComponentCount()); 	
	}

	private void pauseClick() {
		if(view.getMnuPause().getText().equalsIgnoreCase("pause"))
			view.getMnuPause().setText("Start");
		else
			view.getMnuPause().setText("Pause");
	}
	
	public View getView() {
		return view;
	}

	public void setView(View view) {
		this.view = view;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
