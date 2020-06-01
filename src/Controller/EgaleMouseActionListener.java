package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JOptionPane;

import Model.Model;
import Patterns.State.Context.GameStatus;
import View.Board;
import View.Tile;

public class EgaleMouseActionListener  implements MouseListener 
{
	private Board board;
	private Model model;
	
	public EgaleMouseActionListener(Board board, Model model) {// String[] eagles) {
		this.board = board;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(model.getContext().getGameState() != GameStatus.EGALE)
			JOptionPane.showMessageDialog(null,"It is shark turn");
		else {
		Tile tile = (Tile) e.getSource();
		if(tile != null) {
			 if(Arrays.asList(model.eagles()).contains(tile.getAttribute()))
				if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) {
					board.setSelectedRow(tile.getRow());
					board.setSelectedColumn(tile.getColumn());
					board.setSelectedname(tile.getName());
					}			
			}		
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
