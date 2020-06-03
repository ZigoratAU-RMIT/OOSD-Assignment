package Patterns.Command;

public class UndoRedoManager {
	// the current index node
	private Node currentIndex = null;
	// the parent node far left node.
	private Node parentNode = new Node();


	public UndoRedoManager() {
		currentIndex = parentNode;
	}

	// Creates a new UndoRedoManager  contents and current index

	public UndoRedoManager(UndoRedoManager manager) {
		this();
		currentIndex = manager.currentIndex;
	}

	// Clean UndoRedoManager

	public void clear() {
		currentIndex = parentNode;
	}

	// add items to UndoRedoManager

	public void addUndoRedoManager(Command changeable) {
		Node node = new Node(changeable);
		currentIndex.right = node;
		node.left = currentIndex;
		currentIndex = node;
	}
	
	// check if any undo item is in the tree

	public boolean canUndo() {
		return currentIndex != parentNode;
	}

	// check if any redo item is in the tree

	public boolean canRedo() {
		return currentIndex.right != null;
	}

	// do undo action

	public void undo() {
		if (!canUndo()) {
			throw new IllegalStateException("Index is out of range for doing undo.");
		}
		currentIndex.changeable.undo();
		moveLeft();
	}

	// move index to the left of list
	private void moveLeft() {
		if (currentIndex.left == null) {
			throw new IllegalStateException("Internal index set to null.");
		}
		currentIndex = currentIndex.left;
	}

	// move to the right of the list

	private void moveRight() {
		if (currentIndex.right == null) {
			throw new IllegalStateException("Internal index set to null.");
		}
		currentIndex = currentIndex.right;
	}

	// do Redo action

	public void redo() {
		if (!canRedo()) {
			throw new IllegalStateException("Index is out of range for doing redo");
		}
		moveRight();
		currentIndex.changeable.redo();
	}

	// Node data structure for Undo and Redo list
	private class Node {
		private Node left = null;
		private Node right = null;
		private final Command changeable;
		public Node(Command c) {
			changeable = c;
		}
		public Node() {
			changeable = null;
		}
	}

}
