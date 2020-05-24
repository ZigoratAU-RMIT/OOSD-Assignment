package Controller;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JOptionPane;



import View.Board;
import View.Tile;

public class EgaleMouseActionListener  implements MouseListener 
{
	private Board board;
	private String[] eagles;
	
	public EgaleMouseActionListener(Board board,String[] eagles) {
		this.setBoard(board);
		this.eagles = eagles;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(board.isEagleSharkTurn())
			JOptionPane.showMessageDialog(null,"It is shark turn");
		else {
		Tile tile = (Tile) e.getSource();
		if(tile != null) {
			JOptionPane.showMessageDialog(null,tile.getAttribute());
			 if(Arrays.asList(eagles).contains(tile.getAttribute()))
			//if(tile.getAttribute().compareToIgnoreCase("egale")==0)
				if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) {
					board.setSelectedRow(tile.getRow());
					board.setSelectedColumn(tile.getColumn());
					board.setSelectedname(tile.getName());
					//JOptionPane.showMessageDialog(null,board.getSelectedRow()+","+board.getSelectedColumn());
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
