package Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Model.Model;
import View.*;

public class Controller {

	private View view;	
	private Model model;
	
	public Controller() {
		
	}
	
//	public Controller(View v, Model m) {
//		model = m;
//		m.getApplicationConfiguration().ReadApplicationConfiguration();
//		
//		view = v;
//		v.getBoard().setRow(m.getApplicationConfiguration().getBoardRows());
//		v.getBoard().setColumn(m.getApplicationConfiguration().getBoardColumns());
//		v.getBoard().initBoard();
//		
//		m.initModel(v.getBoard().getRow(),v.getBoard().getColumn());	
//		
//		initView();
//		showBoard();
//		
//		v.setChkTurn(m.getApplicationConfiguration().getGameTurn());
//		v.UpdateTurnStatus();
//		v.getTimer().start();
//	}
	
	
	
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

		int item = 0;
		Tile tile;
		for(int x = 0;x<view.getBoard().getRow();x++)
			for(int y = 0;y<view.getBoard().getColumn();y++) {
				tile = model.getTiles().get(item++);
				String attribute = tile.getAttribute();
				if(model.isContaingEagle(attribute)) {
					tile.addMouseListener(egaleMouseActionListener);
				}
				else if(model.isContaingShark(attribute))
					tile.addMouseListener(sharkMouseActionListener);
				else
					tile.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {							
							Tile tileItem = (Tile) e.getSource();
							if(tileItem != null) {
								if(view.getBoard().getEagleSharkTurn()) {
									if(tileItem.getAttribute().compareToIgnoreCase("egale") != 0) {
										view.getBoard().setEagleSharkTurn(true);
										doMovement(tileItem);		
									}
								}
								else {
									if(tileItem.getAttribute().compareToIgnoreCase("shark") != 0)
										view.getBoard().setEagleSharkTurn(false);
										doMovement(tileItem);									
									}
								}							
							}	
						});		
				view.getBoard().add(tile);
				}		
	}
	
	private boolean checkMovement(double x, double y) {
		boolean result = false;
		if(view.getBoard().getEagleSharkTurn()) {// EagleOrShark) {
			//find the eagle name for selecting different movement.
			if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(0).getName()) == 0)
				result = (Math.abs(x) == 1 && Math.abs(y) == 3) || (Math.abs(x) == 3 && Math.abs(y) == 1);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(1).getName()) == 0)
				result = (Math.abs(x) == 2 && Math.abs(y) == 3) || (Math.abs(x) == 3 && Math.abs(y) == 2);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(2).getName()) == 0)
				result = (Math.abs(x) == 3 && Math.abs(y) == 3) || (Math.abs(x) == 3 && Math.abs(y) == 3);
		}
		else {
			//find the shark name for selecting different movement.
			if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(0).getName()) == 0)
				result = Math.abs(x) ==  Math.abs(y);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(1).getName()) == 0)
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(2).getName()) == 0)
				result = (Math.abs(x) ==  Math.abs(y)) || ( (Math.abs(x) == 0 ) ||( Math.abs(y) == 0));			
		}
		return result;
	}
	
	public void doMovement(Tile tileItem) {
		if(view.getBoard().getSelectedRow() != -1 && view.getBoard().getSelectedColumn() != -1) {
			//calculate distance
			double x = tileItem.getRow() - view.getBoard().getSelectedRow();
			double y = tileItem.getColumn() - view.getBoard().getSelectedColumn();
			
			boolean isMoveAllowed = checkMovement(x,y);
			if(isMoveAllowed) {				
				//find source and destination location in the board
				int x1 = tileItem.getRow();
				int y1 = tileItem.getColumn();
				int x2 = view.getBoard().getSelectedRow() ;
				int y2 = view.getBoard().getSelectedColumn();
				
				int source = ((x1 - 1) * 8) + (y1 - 1);
				int destination = ((x2 - 1) * 8) + (y2 - 1);
				model.getTiles().get(source).setRow(x2);
				model.getTiles().get(source).setColumn(y2);
				model.getTiles().get(destination).setRow(x1);
				model.getTiles().get(destination).setColumn(y1);
				Collections.swap(model.getTiles(), source, destination); 
				view.getBoard().removeAll();
				showBoard();
				view.getBoard().validate();
				//changeTurn();
				view.getBoard().changeTurn();
				view.ResetTurnStatus();
				view.UpdateScore(view.getBoard().getEagleSharkTurn(),1);
			}
			else
			{
				if(view.getBoard().getEagleSharkTurn())
					JOptionPane.showMessageDialog(null,"Egale movement is wrong");
				else
					JOptionPane.showMessageDialog(null,"Shark movement is wrong");
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);			
		}		
	}

	
	public void initController() {	
		
		
		model.getApplicationConfiguration().ReadApplicationConfiguration();
		
		view.getBoard().setRow(model.getApplicationConfiguration().getBoardRows());
		view.getBoard().setColumn(model.getApplicationConfiguration().getBoardColumns());
		view.getBoard().initBoard();
		
		model.initModel(view.getBoard().getRow(),view.getBoard().getColumn());	
		
		initView();
		showBoard();
		
		view.setChkTurn(model.getApplicationConfiguration().getGameTurn());
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
		int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
		if(result == 0) {
				model.getApplicationConfiguration().WriteApplicationConfiguration(this);
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
