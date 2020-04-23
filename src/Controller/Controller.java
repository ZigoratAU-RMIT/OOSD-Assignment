package Controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;

import javax.swing.Icon;
import javax.swing.JOptionPane;

import Model.Model;
import View.*;

public class Controller {

	private View view;	
	private Model model;
	private EgaleMouseActionListener egaleMouseActionListener;
	private SharkMouseActionListener sharkMouseActionListener;
	
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
	
	private void updateBoard() 
	{
		EgaleMouseActionListener egaleMouseActionListener = new EgaleMouseActionListener(view.getBoard());
		SharkMouseActionListener sharkMouseActionListener = new SharkMouseActionListener(view.getBoard());

		int item = 0;
		Tile tile;
		for(int x = 0;x<8;x++)
		{
			for(int y = 0;y<8;y++) 
			{
				tile = model.getTiles().get(item++);
				String attribute = tile.getAttribute();
				if(attribute.compareToIgnoreCase("eagleIsland") == 0 || attribute.compareToIgnoreCase("eagleOcean") == 0)
				{
					tile.addMouseListener(egaleMouseActionListener);
				}
				else if(attribute.compareToIgnoreCase("sharkOcean") == 0)
				{
					tile.addMouseListener(sharkMouseActionListener);

				}
				else
				{
					tile.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e) 
						{							
							Tile tileItem = (Tile) e.getSource();
//							Tile sourceTile = null;
//							if(view.getBoard().getSelectedColumn() != -1 && view.getBoard().getSelectedRow() != -1)
//							{
//								int row = view.getBoard().getSelectedRow();
//								System.out.println(row);
//								int col = view.getBoard().getSelectedColumn();
//								System.out.println(col);
//								int destination = ((row - 1) * 8) + (col - 1);
//								System.out.println(destination);
//								sourceTile = model.getTiles().get(destination);
//								System.out.println(sourceTile.getAnimal());
//							}
							if(tileItem != null) 
							{
								if(!view.getBoard().isEagleSharkTurn()) 
								{
									if((tileItem.getAttribute().compareToIgnoreCase("eagleIsland") != 0 || tileItem.getAttribute().compareToIgnoreCase("eagleOcean") != 0))
//											&& sourceTile.getAnimal().equalsIgnoreCase("Bald"))
									{
										doEgaleMove1(tileItem);												
									}
									else if((tileItem.getAttribute().compareToIgnoreCase("eagleIsland") != 0 ||
									tileItem.getAttribute().compareToIgnoreCase("eagleOcean") != 0) )
//											&& sourceTile.getAnimal().equalsIgnoreCase("Bateleur"))
									{
//										doEgaleMove1(tileItem);	
									}
									else if((tileItem.getAttribute().compareToIgnoreCase("eagleIsland") != 0 ||
									tileItem.getAttribute().compareToIgnoreCase("eagleOcean") != 0))
//											&& sourceTile.getAnimal().equalsIgnoreCase("Black"))
									{
//										doEgaleMove1(tileItem);	
									}
								}
								else 
								{
									if(tileItem.getAttribute().compareToIgnoreCase("sharkOcean") != 0 )
//											&& sourceTile.getAnimal().equalsIgnoreCase("blue shark"))
									{
										doSharkMove1(tileItem);									
									}
									else if(tileItem.getAttribute().compareToIgnoreCase("sharkOcean") != 0 )
//											&& sourceTile.getAnimal().equalsIgnoreCase("tiger shark"))
									{
										doSharkMove2(tileItem);									
									}
									else if(tileItem.getAttribute().compareToIgnoreCase("sharkOcean") != 0 )
//											&& sourceTile.getAnimal().equalsIgnoreCase("white shark"))
									{
//										doSharkMove1(tileItem);									
									}
								}
							}	
						}
					});
				}		
				view.getBoard().add(tile);
			}		
		}
	}
	
	public Controller(View v, Model m) 
	{
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
	
	public void doEgaleMove1(Tile tileItem) {
		if(view.getBoard().getSelectedRow() != -1 && view.getBoard().getSelectedColumn() != -1) {
			double x = tileItem.getRow() - view.getBoard().getSelectedRow();
			double y = tileItem.getColumn() - view.getBoard().getSelectedColumn();
			if((Math.abs(x) == 1 && Math.abs(y) == 2) || (Math.abs(x) == 2 && Math.abs(y) == 1)) {
				
				int x1 = tileItem.getRow();
				int y1 = tileItem.getColumn();
				int x2 = view.getBoard().getSelectedRow() ;
				int y2 = view.getBoard().getSelectedColumn();
				
				int source = ((x1 - 1) * 8) + (y1 - 1);
				int destination = ((x2 - 1) * 8) + (y2 - 1);
								
				if(model.getTiles().get(destination).getAttribute().equalsIgnoreCase("eagleIsland") == true)
				{
					Icon destinationIcon = model.getTiles().get(destination).getIcon();
					model.getTiles().get(source).setIcon(destinationIcon);
					model.setImageToTile(model.getTiles().get(destination), "Island");

				}
				else if(model.getTiles().get(destination).getAttribute().equalsIgnoreCase("eagleOcean") == true)
				{
					Icon destinationIcon = model.getTiles().get(destination).getIcon();
					model.getTiles().get(source).setIcon(destinationIcon);
					model.setImageToTile(model.getTiles().get(destination), "Ocean");
				}
			
				
//				model.getTiles().get(source).setRow(x2);
//				model.getTiles().get(source).setColumn(y2);
//				model.getTiles().get(destination).setRow(x1);
//				model.getTiles().get(destination).setColumn(y1);
//				Collections.swap(model.getTiles(), source, destination); 
				view.getBoard().removeAll();
				updateBoard();
				view.getBoard().validate();
				changeTurn();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Egale movement is wrong");
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);
			
		}		
	}
	
	public void doSharkMove1(Tile tileItem) {
		if(view.getBoard().getSelectedRow() != -1 && view.getBoard().getSelectedColumn() != -1) {
			double x = tileItem.getRow() - view.getBoard().getSelectedRow();
			double y = tileItem.getColumn() - view.getBoard().getSelectedColumn();
			if(Math.abs(x) ==  Math.abs(y)) {
				
				int x1 = tileItem.getRow();
				int y1 = tileItem.getColumn();
				int x2 = view.getBoard().getSelectedRow() ;
				int y2 = view.getBoard().getSelectedColumn();
				
				int source = ((x1 - 1) * 8) + (y1 - 1);
				int destination = ((x2 - 1) * 8) + (y2 - 1);
//				System.out.println(x1 + " , " + y1 + " , " + x2 + " , " + y2 + " , " + source + " , " + destination);
				
				if(model.getTiles().get(destination).getAttribute().equalsIgnoreCase("sharkOcean") == true)
				{
					Icon destinationIcon = model.getTiles().get(destination).getIcon();
					model.getTiles().get(source).setIcon(destinationIcon);
					model.setImageToTile(model.getTiles().get(destination), "Ocean");
//					System.out.println(x1 + " , " + y1 + " , " + x2 + " , " + y2 + " , " + source + " , " + destination);
				}
				
//				model.getTiles().get(source).setRow(x2);
//				model.getTiles().get(source).setColumn(y2);
//				model.getTiles().get(destination).setRow(x1);
//				model.getTiles().get(destination).setColumn(y1);
//				Collections.swap(model.getTiles(), source, destination); 
				view.getBoard().removeAll();
				updateBoard();
				view.getBoard().validate();
				changeTurn();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shark movement is wrong");
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);
		}		
	}
	
	public void doSharkMove2(Tile tileItem) {
		if(view.getBoard().getSelectedRow() != -1 && view.getBoard().getSelectedColumn() != -1) {
			double x = tileItem.getRow() - view.getBoard().getSelectedRow();
			double y = tileItem.getColumn() - view.getBoard().getSelectedColumn();
			if(Math.abs(x) == 0 || Math.abs(y) == 0) {
				
				int x1 = tileItem.getRow();
				int y1 = tileItem.getColumn();
				int x2 = view.getBoard().getSelectedRow() ;
				int y2 = view.getBoard().getSelectedColumn();
				
				int source = ((x1 - 1) * 8) + (y1 - 1);
				int destination = ((x2 - 1) * 8) + (y2 - 1);
//				System.out.println(x1 + " , " + y1 + " , " + x2 + " , " + y2 + " , " + source + " , " + destination);
				
				if(model.getTiles().get(destination).getAttribute().equalsIgnoreCase("sharkOcean") == true)
				{
					Icon destinationIcon = model.getTiles().get(destination).getIcon();
					model.getTiles().get(source).setIcon(destinationIcon);
					model.setImageToTile(model.getTiles().get(destination), "Ocean");
//					System.out.println(x1 + " , " + y1 + " , " + x2 + " , " + y2 + " , " + source + " , " + destination);
				}
				
//				model.getTiles().get(source).setRow(x2);
//				model.getTiles().get(source).setColumn(y2);
//				model.getTiles().get(destination).setRow(x1);
//				model.getTiles().get(destination).setColumn(y1);
//				Collections.swap(model.getTiles(), source, destination); 
				view.getBoard().removeAll();
				updateBoard();
				view.getBoard().validate();
				changeTurn();
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Shark movement is wrong");
			}
			view.getBoard().setSelectedRow(-1);
			view.getBoard().setSelectedColumn(-1);
		}		
	}
	
	
	
	public void initController() {
		
		egaleMouseActionListener = new EgaleMouseActionListener(view.getBoard());
		sharkMouseActionListener = new SharkMouseActionListener(view.getBoard());
		
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

	public EgaleMouseActionListener getEgaleMouseActionListener() {
		return egaleMouseActionListener;
	}

	public void setEgaleMouseActionListener(EgaleMouseActionListener egaleMouseActionListener) {
		this.egaleMouseActionListener = egaleMouseActionListener;
	}

	public SharkMouseActionListener getSharkMouseActionListener() {
		return sharkMouseActionListener;
	}

	public void setSharkMouseActionListener(SharkMouseActionListener sharkMouseActionListener) {
		this.sharkMouseActionListener = sharkMouseActionListener;
	}
	
}
