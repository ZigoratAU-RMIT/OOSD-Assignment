package Patterns.State;

public interface State {
	   public void doEgaleAttackAction(Context context);
	   public void doEgaleAction(Context context);
	   public void doSharkAttackAction(Context context);
	   public void doSharkAction(Context context);
	   public void doGameBeginAction(Context context);
	   public void doGameStartAction(Context context);
	   public void doGamePauseAction(Context context);
	   public void doGameEndAction(Context context);
	}