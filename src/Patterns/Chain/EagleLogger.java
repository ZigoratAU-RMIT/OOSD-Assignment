package Patterns.Chain;

public class EagleLogger extends AbstractGameLogger {

	public EagleLogger(int level) {
		this.level = level;
	}

	@Override
	protected void changeMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

}
