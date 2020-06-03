package Patterns.Command;

public interface Command {
	
	// Undo Action
	public void undo();

	// Redo Action an action
	public void redo();
}