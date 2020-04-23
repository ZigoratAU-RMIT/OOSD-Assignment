package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import View.Board;
import View.Tile;

public class SharkMouseActionListener  implements MouseListener 
{
	private Board board;
	
	public SharkMouseActionListener(Board board) {
		this.setBoard(board);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub	
		if(!board.isEagleSharkTurn())
			JOptionPane.showMessageDialog(null,"It is Eagle turn");
		else {
		Tile tile = (Tile) e.getSource();
		if(tile != null) {
			if(tile.getAttribute().compareToIgnoreCase("shark")==0)
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

}
