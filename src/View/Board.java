package View;

import java.awt.*;
import javax.swing.*;





public class Board extends JPanel
{
	private int row;
	private int column;
	private int selectedRow;
	private int selectedColumn;
	private boolean eagleSharkTurn;
	private String selectedname;
	
	public int getRow() {
		return row;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public int getSelectedColumn() {
		return selectedColumn;
	}

	public void setSelectedColumn(int selectedColumn) {
		this.selectedColumn = selectedColumn;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public Board(int row, int column) {
		this.row = row;
		this.column = column;
		setLayout(new GridLayout(row,column));
		selectedRow = -1;
		selectedColumn = -1;
		eagleSharkTurn = true;
		selectedname = "";
	}
	
	public boolean isEagleSharkTurn() {
		return eagleSharkTurn;
	}

	public void setEagleSharkTurn(boolean eagleSharkTurn) {
		this.eagleSharkTurn = eagleSharkTurn;
	}

	public String getSelectedname() {
		return selectedname;
	}

	public void setSelectedname(String selectedname) {
		this.selectedname = selectedname;
	}
}

