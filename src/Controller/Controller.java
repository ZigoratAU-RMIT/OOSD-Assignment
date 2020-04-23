package Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import javax.swing.JOptionPane;

import Model.Model;
import View.*;

public class Controller {

	private View view;	
	private Model model;
	
	private void updateBoard() {
		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(view.getBoard());
		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(view.getBoard());

		int item = 0;
		Tile tile;
		for(int x = 0;x<8;x++)
			for(int y = 0;y<8;y++) {
				tile = model.getTiles().get(item++);
				String attribute = tile.getAttribute();
				if(attribute.compareToIgnoreCase("egale") == 0)
					tile.addMouseListener(egaleMouseActionListener);
				else if(attribute.compareToIgnoreCase("shark") == 0)
					tile.addMouseListener(sharkMouseActionListener);
				else
					tile.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {							
							Tile tileItem = (Tile) e.getSource();
							if(tileItem != null) {
								if(!view.getBoard().isEagleSharkTurn()) {
									if(tileItem.getAttribute().compareToIgnoreCase("egale") != 0)
										doMovement(true,tileItem);									
								}
								else {
									if(tileItem.getAttribute().compareToIgnoreCase("shark") != 0)
										doMovement(false,tileItem);									
									}
								}							
							}	
						});		
				view.getBoard().add(tile);
				}		
	}
	
	public Controller(View v, Model m) {
		view = v;
		model = m;
		initView();
		updateBoard();
	}
	
	public void initView() {
		EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				view.getFrame().setVisible(true);
				changeTurn();
			} 
			catch (Exception e) {
				e.printStackTrace();
				}
			}
		});
	}
	
	
	public void changeTurn() {
		if(view.getBoard().isEagleSharkTurn()) {
			view.getChkTurn().setText("Egale Turn");
			view.getChkTurn().setBackground(Color.BLUE);
			view.getBoard().setEagleSharkTurn(!view.getBoard().isEagleSharkTurn());
		}
		else {
			view.getChkTurn().setText("Shark Turn");
			view.getChkTurn().setBackground(Color.RED);
			view.getBoard().setEagleSharkTurn(!view.getBoard().isEagleSharkTurn());
		}
	}
	
	private boolean checkMovement(boolean EagleOrShark,double x, double y) {
		boolean result = false;
		if(EagleOrShark) {
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
	
	public void doMovement(boolean EagleOrShark,Tile tileItem) {
		if(view.getBoard().getSelectedRow() != -1 && view.getBoard().getSelectedColumn() != -1) {
			//calculate distance
			double x = tileItem.getRow() - view.getBoard().getSelectedRow();
			double y = tileItem.getColumn() - view.getBoard().getSelectedColumn();
			
			boolean isMoveAllowed = checkMovement(EagleOrShark,x,y);
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
				updateBoard();
				view.getBoard().validate();
				changeTurn();
			}
			else
			{
				if(EagleOrShark)
					JOptionPane.showMessageDialog(null,"Egale movement is wrong");
				else
					JOptionPane.showMessageDialog(null,"Shark movement is wrong");
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);			
		}		
	}

	
	public void initController() {		
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
			int result = JOptionPane.showConfirmDialog(null, "Do you want to exit?");
			if(result == 0)
				System.exit(0);
			}	
		});
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
