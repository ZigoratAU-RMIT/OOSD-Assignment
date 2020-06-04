package Controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Model.Model;
import Patterns.Chain.AbstractLogger;
import Patterns.Command.CommandLineChanger;
import Patterns.State.Context.GameStatus;
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
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void updateBoard() {
//		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(this);//view,model);
//		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(this);//view,model);
//		PieceMoveActionListener pieceMoveActionListener = new PieceMoveActionListener(this);//view,model);

		int item = 0;
		Tile tile;
		for(int x = 0;x<view.getBoard().getRow();x++)
			for(int y = 0;y<view.getBoard().getColumn();y++) {
				tile = model.getTiles().get(item++);
				//String attribute = tile.getAttribute();
//				if(model.isContaingEagle(attribute)) 
//				{
//					tile.addMouseListener(egaleMouseActionListener);
//				}
//				else if(model.isContaingShark(attribute))
//				{
//					tile.addMouseListener(sharkMouseActionListener);
//				}
//				else
//				{
//					tile.addMouseListener(pieceMoveActionListener);
//				}
				view.getBoard().add(tile);
			}		
	}
	
	public void showBoard() {
		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(this);//view,model);
		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(this);//view,model);
		PieceMoveActionListener pieceMoveActionListener = new PieceMoveActionListener(this);//view,model);

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


	private void createTimer() {
		ActionListener countDown=new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				double timerCounter = view.updateTimer();
				if(timerCounter < 0) {
					if(model.getContext().getGameState() == GameStatus.EGALE)
						model.getGameState().doSharkAction(model.getContext());
					else
						model.getGameState().doEgaleAction(model.getContext());
					view.changeGameStateTimer(model.getContext().getGameState());
				}
			}
		};
		view.setTimer( new Timer(100 ,countDown));
		view.getTimer().start();
		view.UpdateTurnViewStatus(model.getContext().getGameState());
	}

	private void initMouseListener() {
		view.getMnuStartStop().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startStopClick();
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

		view.getMnuSave().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doSave();
			}
		});

		view.getMnuNew().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doNew();
			}
		});		

		view.getBtnUndoButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(model.getUndoRedoManager().canUndo())
					model.getUndoRedoManager().undo();
				else
					JOptionPane.showMessageDialog(null,"No UNDO");
			}			
		});

		view.getBtnRedoButton().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(model.getUndoRedoManager().canRedo())
					model.getUndoRedoManager().redo();
				else
					JOptionPane.showMessageDialog(null,"No REDO");
			}			
		});
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

		view.setLblEgaleScore(model.getApplicationConfiguration().getEgaleScore());
		view.setLblSharkScore(model.getApplicationConfiguration().getSharkScore());
		view.ShowGameDetails(model.eagles(),model.sharks());
		if(model.getContext().getGameState() == GameStatus.START)
			model.getGameState().doEgaleAction(model.getContext());
		createTimer();
		initMouseListener();		
	}

	private void doSave() {
		model.getApplicationConfiguration().WriteApplicationConfiguration(this);
		JOptionPane.showMessageDialog(null,"Current game was saved.");
	}

	private void doNew() {
		JOptionPane.showMessageDialog(null,"New.");
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

				Tile sourceTile = model.getTiles().get(source);
				Tile destinationTile = model.getTiles().get(destination);
				String sourceAttribute = sourceTile.getAttribute();
				String destinationAttribute = destinationTile.getAttribute();

				String sourceAttributeChange = "";
//				if(destinationAttribute.equalsIgnoreCase("Black") || 
//						destinationAttribute.equalsIgnoreCase("Bateleur") || 
//						destinationAttribute.equalsIgnoreCase("Bald"))
				if(model.isContaingEagle(destinationAttribute))
				{
					sourceAttributeChange = "island";
				}
				else
				{
					sourceAttributeChange = "ocean";
				}

				if(destinationTile.getCurrentTileAttribute() == null)
				{
//					if(destinationAttribute.equalsIgnoreCase("Black") || 
//							destinationAttribute.equalsIgnoreCase("Bateleur") || 
//							destinationAttribute.equalsIgnoreCase("Bald"))
					if(model.isContaingEagle(destinationAttribute))
					{
						model.getTiles().get(destination).setCurrentTileAttribute("EagleIsland");
					}
					else
					{
						model.getTiles().get(destination).setCurrentTileAttribute("SharkOcean");
					}

					if(destinationTile.getCurrentTileAttribute().equalsIgnoreCase("EagleOcean")
							|| destinationTile.getCurrentTileAttribute().equalsIgnoreCase("SharkOcean"))
					{
						sourceAttributeChange = "ocean";
					}
					else
					{
						sourceAttributeChange = "island";
					}
				}
				else
				{
					if(destinationTile.getCurrentTileAttribute().equalsIgnoreCase("EagleIsland"))
					{
						sourceAttributeChange = "island";
					}
					else
					{
						sourceAttributeChange = "ocean";
					}
				}

				if(sourceAttribute.equalsIgnoreCase("ocean") && model.isContaingEagle(destinationAttribute))
//						(destinationAttribute.equalsIgnoreCase("Black") || 
//						destinationAttribute.equalsIgnoreCase("Bateleur") || 
//						destinationAttribute.equalsIgnoreCase("Bald")))
				{
					destinationTile.setCurrentTileAttribute("EagleOcean");
				}
				else if(sourceAttribute.equalsIgnoreCase("island") && model.isContaingEagle(destinationAttribute))
//						(destinationAttribute.equalsIgnoreCase("Black") || 
//						destinationAttribute.equalsIgnoreCase("Bateleur") || 
//						destinationAttribute.equalsIgnoreCase("Bald")))
				{
					destinationTile.setCurrentTileAttribute("EagleIsland");
				}


				model.getTiles().get(source).setRow(x2);
				model.getTiles().get(source).setColumn(y2);
				model.getTiles().get(destination).setRow(x1);
				model.getTiles().get(destination).setColumn(y1);
				Collections.swap(model.getTiles(), source, destination);

				model.getTiles().get(destination).setAttribute(sourceAttributeChange);
				model.setImageToTile(model.getTiles().get(destination), sourceAttributeChange);

				view.getBoard().removeAll();
				updateBoard();
				view.getBoard().validate();
				switch(model.getContext().getGameState()) {
				case SHARK:
				case SHARKATTACK:
					//Shark log show in right side of panel
					model.getLoggerChain().setwMessage(AbstractLogger.SHARK, destinationAttribute + " Moved ( " +x1+ "," +y1 + " )");
					view.updateSharkLog(model.getLoggerChain().message);
					//scored the Shark
					view.UpdateScore(model.getContext().getGameState() == GameStatus.EGALE,1);
					model.getLoggerChain().setwMessage(AbstractLogger.SHARK, "Scoreed");
					view.updateSharkLog(model.getLoggerChain().message);
					//Change state to Eagle turn
					model.getGameState().doEgaleAction(model.getContext());
					
					//save command for doing UNDO and REDO
					model.getUndoRedoManager().addUndoRedoManager(new CommandLineChanger(
						 	model.getContext().getGameState(),
						  	source,
						  	destination,
						  	model.getTiles()));
					break;
				case EGALE:
				case EGALEATTACK:
					model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, destinationAttribute + " Moved ( " +x1+ "," +y1 + " )");
					view.updateEagleLog(model.getLoggerChain().message);
					//scored the Eagle
					view.UpdateScore(model.getContext().getGameState() == GameStatus.EGALE,1);
					model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "Scoreed");
					view.updateEagleLog(model.getLoggerChain().message);
					//Change state to Shark turn
					model.getGameState().doSharkAction(model.getContext());
					
					//save command for doing UNDO and REDO
					model.getUndoRedoManager().addUndoRedoManager(new CommandLineChanger(
						 	model.getContext().getGameState(),
						  	source,
						  	destination,
						  	model.getTiles()));
					break;
				default:
					break;
				}
				if((model.getContext().getGameState() == GameStatus.SHARK) || (model.getContext().getGameState() == GameStatus.EGALE))
					view.changeGameStateTimer(model.getContext().getGameState());
//				if(model.getContext().getGameState() == GameStatus.SHARK) {
//					//Shark log show in right side of panel
//					model.getLoggerChain().setwMessage(AbstractLogger.SHARK, destinationAttribute + " Moved ( " +x1+ "," +y1 + " )");
//					view.updateSharkLog(model.getLoggerChain().message);
//					//scored the Shark
//					view.UpdateScore(model.getContext().getGameState() == GameStatus.EGALE,1);
//					model.getLoggerChain().setwMessage(AbstractLogger.SHARK, "Scoreed");
//					view.updateSharkLog(model.getLoggerChain().message);
//					//Change state to Eagle turn
//					model.getGameState().doEgaleAction(model.getContext());
//					
//					//save command for doing UNDO and REDO
//					model.getUndoRedoManager().addUndoRedoManager(new CommandLineChanger(
//						 	model.getContext().getGameState(),
//						  	source,
//						  	destination,
//						  	model.getTiles()));
//				}
//				else {
//					//Eagle log show in right side of panel
//					model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, destinationAttribute + " Moved ( " +x1+ "," +y1 + " )");
//					view.updateEagleLog(model.getLoggerChain().message);
//					//scored the Eagle
//					view.UpdateScore(model.getContext().getGameState() == GameStatus.EGALE,1);
//					model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "Scoreed");
//					view.updateEagleLog(model.getLoggerChain().message);
//					//Change state to Shark turn
//					model.getGameState().doSharkAction(model.getContext());
//					
//					//save command for doing UNDO and REDO
//					model.getUndoRedoManager().addUndoRedoManager(new CommandLineChanger(
//						 	model.getContext().getGameState(),
//						  	source,
//						  	destination,
//						  	model.getTiles()));
//				}
//				view.changeGameStateTimer(model.getContext().getGameState());
			}
			else
			{
				if(model.getContext().getGameState() == GameStatus.EGALE) {
					model.getLoggerChain().setwMessage(AbstractLogger.EAGLE, "Shark movement is wrong");
					view.updateEagleLog(model.getLoggerChain().message);
				}
				else if(model.getContext().getGameState() == GameStatus.SHARK) {
					model.getLoggerChain().setwMessage(AbstractLogger.SHARK, "Shark movement is wrong");
					view.updateSharkLog(model.getLoggerChain().message);
				}
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);			
		}		
	}
	
	public boolean checkMovement(double x, double y) {
		boolean result = false;
		if(model.getContext().getGameState() == GameStatus.EGALEATTACK) {
			//find the eagle name for selecting different movement.
			if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(0).getName()) == 0)
				result = ((Math.abs(x) + Math.abs(y)) <= 3);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(1).getName()) == 0)
				result = ((Math.abs(x) + Math.abs(y)) <= 3);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getEagles().get(2).getName()) == 0)
				result = ((Math.abs(x) + Math.abs(y)) <= 3);
		}
		else if(model.getContext().getGameState() == GameStatus.SHARKATTACK){
			//find the shark name for selecting different movement.
			if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(0).getName()) == 0)	
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(1).getName()) == 0)	
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
			else if(view.getBoard().getSelectedname().compareToIgnoreCase(model.getSharks().get(2).getName()) == 0)	
				result = (Math.abs(x) == 0 ) ||( Math.abs(y) == 0);
		}
		return result;
	}
	
	private void startStopClick() {
		boolean enable = false;
		switch(model.getContext().getGameState()) {
		case PAUSE:
			model.getGameState().doGameStartAction(model.getContext());
			enable = true;
			break;
		default:
			model.getGameState().doGamePauseAction(model.getContext());
			break;
		}
		view.StartStopGame(enable);
		model.setEnableDisableTiles(enable);
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
