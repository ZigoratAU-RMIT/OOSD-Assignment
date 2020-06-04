package Patterns.Command;


import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import Controller.Controller;
import Model.Model;
import Patterns.State.Context.GameStatus;
import View.Tile;
import View.View;

public class CommandLineChanger implements Command{
	private final GameStatus gameStatus;
	private final int source;
	private final int destination;
	private final List<Tile> tilesLists;
	private final Controller controller;

	public CommandLineChanger(Controller controller, GameStatus gameStatus, int source, int destination,  List<Tile> tilesLists){
		super();
		this.gameStatus = gameStatus;
		this.source = source;
		this.destination = destination;
		this.tilesLists = tilesLists;
		this.controller = controller;

	}

	public void undo(){
		Collections.swap(controller.getModel().getTiles(), source, destination);
		controller.getView().getBoard().removeAll();
		controller.updateBoard();
		controller.getView().getBoard().validate();
	}

	public void redo(){
		Collections.swap(controller.getModel().getTiles(), source, destination);
		controller.getView().getBoard().removeAll();
		controller.updateBoard();
		controller.getView().getBoard().validate();
	}
}