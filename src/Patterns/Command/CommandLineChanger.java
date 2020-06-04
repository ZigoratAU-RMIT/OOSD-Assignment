package Patterns.Command;


import java.util.Collections;
import Controller.Controller;

public class CommandLineChanger implements Command{
	private final int source;
	private final int destination;
	private final Controller controller;

	public CommandLineChanger(Controller controller, int source, int destination){
		super();
		this.source = source;
		this.destination = destination;
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