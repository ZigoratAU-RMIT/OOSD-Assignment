package Patterns.Chain;

public class SharkAttackLogger extends AbstractGameLogger{

	public SharkAttackLogger(int level) {
		this.level = level;
	}

	@Override
	protected void changeMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

}
