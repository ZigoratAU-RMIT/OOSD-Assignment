package Model;

public class Board {
	private int Row = 8;
	private int Column = 8;
	
	public Board(int row, int column)
	{
		Row = row;
		Column = column;
	}
	public int getRow() {
		return Row;
	}
	public void setRow(int row) {
		Row = row;
	}
	public int getColumn() {
		return Column;
	}
	public void setColumn(int column) {
		Column = column;
	}
}
