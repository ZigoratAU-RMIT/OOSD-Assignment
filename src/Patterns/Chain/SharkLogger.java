package Patterns.Chain;


public class SharkLogger extends AbstractGameLogger{

	public SharkLogger(int level) {
		this.level = level;
	}

	@Override
	protected void changeMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

}
