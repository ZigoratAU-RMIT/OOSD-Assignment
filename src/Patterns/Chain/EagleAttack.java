package Patterns.Chain;

public class EagleAttack extends AbstractGameLogger{

	public EagleAttack(int level) {
		this.level = level;
	}
	
	@Override
	protected void changeMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

}
