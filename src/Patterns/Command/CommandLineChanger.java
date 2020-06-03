package Patterns.Command;

import java.util.List;

import javax.swing.JOptionPane;

import Patterns.State.Context.GameStatus;
import View.Tile;

public class CommandLineChanger implements Command{
	private final GameStatus gameStatus;
	private final int source;
	private final int destination;
	private final List<Tile> tilesLists;

	public CommandLineChanger(GameStatus gameStatus, int source, int destination,  List<Tile> tilesLists){
		super();
		this.gameStatus = gameStatus;
		this.source = source;
		this.destination = destination;
		this.tilesLists = tilesLists;
	}

	public void undo(){
		JOptionPane.showMessageDialog(null, gameStatus.toString() + "\n" + String.valueOf(source) + "\n" + String.valueOf(destination) + "\n" + tilesLists  + "\n UNDO");
	}

	public void redo(){
		JOptionPane.showMessageDialog(null, gameStatus.toString() + "\n" + String.valueOf(source) + "\n" + String.valueOf(destination) + "\n" + tilesLists  + "\n REDO");
	}
}