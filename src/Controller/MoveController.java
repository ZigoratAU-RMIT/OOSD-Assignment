package Controller;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import java.lang.*;
import Entity.*;
import View.Board;
import View.Tile;

public class MoveController implements MouseListener {
	private Tile tile;
	private Pieces pieces;
	private Board board;
	
	private Color moveColor = Color.RED;
	private Color lastColor;

	
	public MoveController(Tile tile,Pieces pieces,Board board)
	{
		this.tile = tile;
		this.pieces = pieces;
		this.board = board;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.pieces != null) {
		if(board.getSelectedRow() == -1 && board.getSelectedColumn() == -1) {
			board.setSelectedRow(tile.getRow());
			board.setSelectedColumn(tile.getColumn());
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
		if(this.pieces != null) {
		lastColor = tile.getBackground();
		tile.setBackground(moveColor);
		tile.setBorder(BorderFactory.createLineBorder(moveColor, 1));	
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(this.pieces != null) {
		tile.setBackground(lastColor);
		tile.setBorder(BorderFactory.createLineBorder(moveColor, 0));	
		}
	}

}
